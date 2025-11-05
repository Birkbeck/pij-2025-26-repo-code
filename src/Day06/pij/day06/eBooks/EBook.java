package pij.day06.eBooks;


/**
 * An EBook represents an electronic book reader. Among other things,
 * it allows for navigating from one page to the next and for reading
 * a specific page aloud to the user.
 */
public class EBook {
    // fields, constructors, methods ...

    /**
     * Displays the page following the current one on the EBook display.
     * Does nothing if the EBook is already on the last page.
     */
    public void nextPage() {
        // ...
    }

    /**
     * Displays the page preceding the current one on the EBook display.
     * Does nothing if the EBook is already on the first page.
     */
    public void prevPage() {
        // ...
    }

    /**
     * Reads the given page aloud. Does nothing if the page does not exist.
     *
     * @param page the page to read aloud
     */
    public void readAloudPage(int page) {
        // ...
    }

}
