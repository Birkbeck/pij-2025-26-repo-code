package pij.day16solutions.examResultNoStream;

import pij.day16.examResult.ExamResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Utility class with several methods to retrieve information about given
 * Collections of ExamResult objects.
 */
public class ExamResultUtils {

    /**
     * Returns a list of the student names occurring in the given Collection
     * of ExamResult objects. The list is sorted by the natural order of String
     * and has only distinct entries.
     * Implementation note: Implementation using the stream() method
     * of the Collection is intended.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @return a sorted list of all distinct student names occurring in the
     *  given Collection of ExamResult objects
     * @throws NullPointerException if results is null or contains null
     */
    public static List<String> getStudents(Collection<? extends ExamResult> results) {
        // we want unique and sorted names, so collect them in a sorted set
        SortedSet<String> uniqueSortedNames = new TreeSet<>();
        for (ExamResult er : results) {
            uniqueSortedNames.add(er.getStudentName());
        }
        // now convert the collected names to an acceptable result type
        // for the method
        return new ArrayList<>(uniqueSortedNames);
    }

    /**
     * Returns a list of the student names occurring in the given Collection
     * of ExamResult objects who have taken the given exam. The list is sorted
     * by the natural order of String and has only distinct entries.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @param exam the exam for which we want to retrieve the students
     * @return a sorted list of all distinct student names occurring in the
     *  given Collection of ExamResult objects who have taken the given exam
     * @throws NullPointerException if results is null or contains null,
     *  or if exam is null
     */
    public static List<String>
            getStudentsOnExam(Collection<? extends ExamResult> results, String exam) {
        // we want unique and sorted names, so collect them in a sorted set
        SortedSet<String> uniqueSortedNames = new TreeSet<>();
        for (ExamResult er : results) {
            if (er.getExamName().equals(exam)) {
                uniqueSortedNames.add(er.getStudentName());
            }
        }
        // now convert the collected names to an acceptable result type
        // for the method
        return new ArrayList<>(uniqueSortedNames);
    }

    /**
     * Returns a String of the student names occurring in the given Collection
     * of ExamResult objects who have taken the given exam. The student names
     * in the string are sorted by the natural order of String and distinct.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @param exam the exam for which we want to retrieve the students
     * @return a String with sorted distinct student names occurring in the
     *  given Collection of ExamResult objects who have taken the given exam,
     *  separated by " | "
     * @throws NullPointerException if results is null or contains null,
     *  or if exam is null
     */
    public static String
            getStudentsOnExamAsString(Collection<? extends ExamResult> results, String exam) {
        // we want unique and sorted names, so collect them in a sorted set
        SortedSet<String> uniqueSortedNames = new TreeSet<>();
        for (ExamResult er : results) {
            if (er.getExamName().equals(exam)) {
                uniqueSortedNames.add(er.getStudentName());
            }
        }

        // now build the String for the result of the method
        final String DELIMITER = " | ";
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (String name : uniqueSortedNames) {
            if (first) { // omit the delimiter (only) before the first name
                first = false;
            } else {
                sb.append(DELIMITER);
            }
            sb.append(name);
        }
        return sb.toString();
    }

    /**
     * Returns a map from exam names occurring in results to corresponding non-empty
     * lists of all ExamResult objects in results that contain the given exam name.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @return a map from exam names occurring in results to corresponding non-empty
     *  lists of all ExamResult objects in results that contain the given exam name
     * @throws NullPointerException if results is null or contains null
     */
    public static Map<String, List<ExamResult>> groupByExams(Collection<? extends ExamResult> results) {
        Map<String, List<ExamResult>> examToExamResults = new LinkedHashMap<>();
        for (ExamResult er : results) {
            String exam = er.getExamName();
            List<ExamResult> examResultsForExam =
                    examToExamResults.getOrDefault(exam, new ArrayList<>());
            examResultsForExam.add(er);
            examToExamResults.put(exam, examResultsForExam);
        }
        return examToExamResults;
    }

    /**
     * Returns a map from classifications with at least one corresponding
     * ExamResult occurrence in results for the given exam to lists with
     * all corresponding such occurrences of ExamResult objects in results;
     * classifications that are not represented in results for the given
     * exam are not part of the returned map.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @param exam the exam for which we want to retrieve the results
     * @return a map from classifications with at least one corresponding
     *  ExamResult occurrence in results for the given exam to lists with
     *  all corresponding such occurrences of ExamResult objects in results;
     *  classifications that are not represented in results for the given
     *  exam are not part of the returned map
     */
    public static Map<ExamResult.Classification, List<ExamResult>>
                classificationsToResults(Collection<? extends ExamResult> results, String exam) {
        Map<ExamResult.Classification, List<ExamResult>> classificationToExamResults =
                new LinkedHashMap<>();
        for (ExamResult er : results) {
            if (er.getExamName().equals(exam)) {
                int marks = er.getMarks();
                ExamResult.Classification classification =
                        ExamResult.Classification.fromMarks(marks);
                List<ExamResult> examResultsForClassification =
                        classificationToExamResults.getOrDefault(classification,
                                new ArrayList<>());
                examResultsForClassification.add(er);
                classificationToExamResults.put(classification,
                        examResultsForClassification);
            }
        }
        return classificationToExamResults;
    }

    /**
     * Returns a map from all classifications to a list of all ExamResult
     * objects for the given exam with this classification in results.
     *
     * @param results the Collection of ExamResult objects to analyse
     * @param exam the exam for which we want to retrieve the results
     * @return a map from all classifications to a list of all ExamResult
     *  objects for the given exam with this classification in results
     */
    public static Map<ExamResult.Classification, List<ExamResult>>
                allClassificationsToResults(Collection<? extends ExamResult> results, String exam) {
        Map<ExamResult.Classification, List<ExamResult>> classificationToExamResults =
                new LinkedHashMap<>();

        // make sure that all Classifications are keys and that they are
        // mapped to a (modifiable) list
        for (ExamResult.Classification classification : ExamResult.Classification.values()) {
            classificationToExamResults.put(classification, new ArrayList<>());
        }

        for (ExamResult er : results) {
            if (er.getExamName().equals(exam)) {
                int marks = er.getMarks();
                ExamResult.Classification classification =
                        ExamResult.Classification.fromMarks(marks);

                // no getOrDefault needed; we made sure earlier that each value
                // of type Classification is mapped to (its own) modifiable list
                List<ExamResult> examResultsForClassification =
                        classificationToExamResults.get(classification);
                examResultsForClassification.add(er);

                // the following line is now optional (hint: aliasing)
                classificationToExamResults.put(classification,
                        examResultsForClassification);
            }
        }
        return classificationToExamResults;
    }
}
