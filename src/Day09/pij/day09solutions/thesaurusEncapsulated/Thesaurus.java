package pij.day09solutions.thesaurusEncapsulated;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Exercise 13.
 *
 * A Thesaurus allows its user to look up a set of synonyms for a given word.
 * Proper encapsulation has been applied to prevent "leaking references" to
 * mutable objects reachable from the fields of the class.
 */
public class Thesaurus {

    /** Mapping of words to synonyms. */
    private Map<String, Set<String>> wordsToSynonyms;

    /**
     * Initialises a new Thesaurus with a given mapping of words to synonyms.
     *
     * @param wordsToSynonyms the mapping of words to synonyms
     * @throws NullPointerException if wordsToSynonyms is null, contains null
     *  as key or value, or one of its values contains null
     */
    public Thesaurus(Map<String, Set<String>> wordsToSynonyms) {
        checkSanity(wordsToSynonyms);
        // we need to make a copy of wordsToSynonyms -- otherwise code external
        // to this class can modify the content of the encapsulated map
        this.wordsToSynonyms = makeUnmodifiableDeepCopy(wordsToSynonyms);
    }

    /**
     * Returns an unmodifiable deep copy of wordsToSynonyms.
     * Here "unmodifiable deep copy" means that also the intermediate data
     * structures (e.g., the values of the map) are copied to unmodifiable
     * structures as needed. Since class String is immutable, its elements
     * do not need to be copied.
     *
     * @param wordsToSynonyms map of which we want to make a deep copy
     * @return an unmodifiable deep copy of wordsToSynonyms
     * @throws NullPointerException if wordsToSynonyms is null or has null
     *  as the value of some entry
     */
    private static Map<String, Set<String>> makeUnmodifiableDeepCopy(Map<String, Set<String>> wordsToSynonyms) {
        // we don't know whether wordsToSynonyms is mutable, so make a copy;
        // just wrapping wordsToSynonyms into an unmodifiable map would not
        // prevent later calls to mutators like put(...) via the reference
        // that was passed to this method
        Map<String, Set<String>> wordsToSynonymsCopy = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> entry : wordsToSynonyms.entrySet()) {
            // class String is immutable, so we do not need a duplicate
            String key = entry.getKey();

            // we don't know whether e.getValue() is mutable, so make a copy;
            // the same considerations as for wordsToSynonyms apply
            Set<String> valueCopy = new LinkedHashSet<>(entry.getValue());
            Set<String> unmodifiableValueCopy = Collections.unmodifiableSet(valueCopy);
            wordsToSynonymsCopy.put(key, unmodifiableValueCopy);
        }
        Map<String, Set<String>> unmodifiableWordsToSynonymsCopy = Collections.unmodifiableMap(wordsToSynonymsCopy);
        return unmodifiableWordsToSynonymsCopy;
    }

    /**
     * Sanity check for map from words to synonyms. Throws NullPointerException
     * if wordsToSynonyms is null, contains null as key or value, or one of its
     * values contains null.
     *
     * @param wordsToSynonyms the map from words to synonyms to check for
     *                        absence of reachable null references
     * @throws NullPointerException if wordsToSynonyms is null, contains null
     *  as key or value, or one of its values contains null
     */
    private static void checkSanity(Map<String, Set<String>> wordsToSynonyms) {
        Objects.requireNonNull(wordsToSynonyms);
        for (Map.Entry<String, Set<String>> entry : wordsToSynonyms.entrySet()) {
            Objects.requireNonNull(entry.getKey());
            Objects.requireNonNull(entry.getValue());
            for (String s : entry.getValue()) {
                Objects.requireNonNull(s);
            }
        }
    }

    /**
     * Returns the set of known synonyms for key, or null if key is unknown.
     *
     * @param key the word whose synonyms should be retrieved
     * @return the set of known synonyms for key, or null if key is unknown
     */
    public Set<String> getSynonyms(String key) {
        return this.wordsToSynonyms.get(key);
    }

    /**
     * Adds or modifies an entry of synonyms for the word key.
     *
     * @param key the word for which we want to update our synonyms.
     * @param synonyms the set of synonyms
     * @throws NullPointerException if key or synonyms is null
     */
    public void addEntry(String key, Set<String> synonyms) {
        checkSanity(Map.of(key, synonyms));
        // use new LinkedHashSet, wrapped into an unmodifiable set,
        // instead of Set.copyOf as Set.copyOf does not guarantee that the
        // order of elements is preserved, so the change in the implementation
        // might be noticeable to the end user
        this.wordsToSynonyms.put(key,
                Collections.unmodifiableSet(new LinkedHashSet<>(synonyms)));
    }

    @Override
    public String toString() {
        return this.wordsToSynonyms.toString();
    }
}
