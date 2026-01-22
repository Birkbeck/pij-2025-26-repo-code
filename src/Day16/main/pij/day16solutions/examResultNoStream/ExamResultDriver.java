package pij.day16solutions.examResultNoStream;

import pij.day16.examResult.ExamResult;

import java.util.List;

import static pij.day16.examResult.ExamResultHelper.makeLargeTestData;
import static pij.day16.examResult.ExamResultHelper.makeTestData;
import static pij.day16solutions.examResultNoStream.ExamResultUtils.allClassificationsToResults;
import static pij.day16solutions.examResultNoStream.ExamResultUtils.classificationsToResults;
import static pij.day16solutions.examResultNoStream.ExamResultUtils.getStudents;
import static pij.day16solutions.examResultNoStream.ExamResultUtils.getStudentsOnExam;
import static pij.day16solutions.examResultNoStream.ExamResultUtils.getStudentsOnExamAsString;
import static pij.day16solutions.examResultNoStream.ExamResultUtils.groupByExams;

/**
 * Driver class for queries related to exam results.
 */
public class ExamResultDriver {

    /**
     * Runs a query on "large" test data. Prints on the
     * screen how many milliseconds the computation took.
     */
    public static void runLarge() {
        List<ExamResult> largeTestData = makeLargeTestData();
        long startTime = System.nanoTime();
        // use System.nanoTime() to measure time before and after the
        // method call, then compare
        List<String> results = getStudents(largeTestData);
        long finishTime = System.nanoTime();
        long totalTime = finishTime - startTime;
        System.out.println("Total time (ms): " + totalTime / 1000000);
    }

    /**
     * Tests several methods related to collections of exam results.
     *
     * @param args Ignored.
     */
    public static void main(String[] args) {
        System.out.println("getStudents: " + getStudents(makeTestData()));
        System.out.println("getStudentsOnExam: "
                + getStudentsOnExam(makeTestData(), "PiJ"));
        System.out.println("getStudentsOnExamAsString: "
                + getStudentsOnExamAsString(makeTestData(), "PiJ"));
        System.out.println("groupByExams: " + groupByExams(makeTestData()));
        System.out.println("classificationToResults: "
                + classificationsToResults(makeTestData(), "PiJ"));
        System.out.println("allClassificationsToResults: "
                + allClassificationsToResults(makeTestData(), "PiJ"));

        // note the duration compared to (even) the sequential stream version!
        runLarge();
    }
}
