/**
 * Represents a two-dimensional matrix of int values.
 */
public class Matrix {
    // matrixEntries[i][j] is in the ith row and the jth column
    // - number of rows: matrixEntries.length
    // - number of columns: matrixEntries[0].length
    private int[][] matrixEntries;

    public Matrix(int row, int column) {
        this.matrixEntries = new int[row][column];
        for (int i = 0; i < this.matrixEntries.length; i++) {
            for (int j = 0; j < this.matrixEntries[0].length; j++) {
                this.matrixEntries[i][j] = 1;
            }
        }
    }

    public void setElement(int row, int col, int value) {
        if (row < 0 || row >= this.matrixEntries.length) {
            // do nothing; soon we will see a better way to handle "invalid" input
            return;
        }
        if (col < 0 || col >= this.matrixEntries[0].length) {
            return;
        }
        this.matrixEntries[row][col] = value;
    }

    // helper method for setRow and setColumn: this functionality is useful on its own
    private static int[] parseNumbers(String rowContent) {
        final char SEPARATOR = ',';
        // OPTION 1:
        String[] numbers = split(rowContent, SEPARATOR);
        // OPTION 2 (for those who have studied regular expressions, e.g.,
        // in Fundamentals of Computing):
        //String[] numbers = rowContent.split(SEPARATOR);
        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(numbers[i]);
        }
        return result;
    }

    private static String[] split(String text, char separator) {
        int resultLength = countOccurrences(text, separator) + 1;
        String[] result = new String[resultLength];
        int resultIndex = 0; // insert next substring at this position in result
        int startPos = 0; // copy the substring from this position in text
        for (int textIndex = 0; textIndex < text.length(); textIndex++) {
            if (separator == text.charAt(textIndex)) {
                result[resultIndex] = text.substring(startPos, textIndex);
                startPos = textIndex + 1; // next substring to copy starts after c
                resultIndex++;
            }
        }
        // now we still need to include the rest of the String
        // after the last occurrence of separator
        result[resultIndex] = text.substring(startPos);

        return result;
    }

    private static int countOccurrences(String text, char c) {
        int numberOfOccurrences = 0;
        for (int i = 0; i < text.length(); i++) {
            if (c == text.charAt(i)) {
                numberOfOccurrences++;
            }
        }
        return numberOfOccurrences;
    }

    public void setRow(int row, String content) {
        if (row < 0 || row >= this.matrixEntries.length) {
            return;
        }
        int[] nums = parseNumbers(content);
        if (nums.length != this.matrixEntries[row].length) {
            return; // content does not have the right number of integers
        }
        // OPTION 1 (for those who have read the Java API):
        //System.arraycopy(nums, 0, this.matrixEntries[row], 0, nums.length);
        // OPTION 2:
        for (int i = 0; i < nums.length; i++) {
            this.matrixEntries[row][i] = nums[i];
        }
    }

    public void setColumn(int col, String content) {
        if (col < 0 || col >= this.matrixEntries[0].length) {
            return;
        }
        int[] nums = parseNumbers(content);
        if (nums.length != this.matrixEntries.length) {
            return; // content does not have the right number of integers
        }
        for (int i = 0; i < nums.length; i++) {
            this.matrixEntries[i][col] = nums[i];
        }
    }

    @Override
    public String toString() {
        return toStringHelper(",", ";");
    }

    // When I noticed that I was writing pretty much the same code for
    // toString() and for prettyPrint(), I decided to write a private
    // method for the common parts, with the different Strings used
    // for separating entries and rows as method parameters.
    // DRY can (and should) become second nature, to the point of feeling
    // "wrong" when it there are repetitions in the code that could easily
    // be avoided.
    private String toStringHelper(String entrySeparator, String rowSeparator) {
        String result = "";
        for (int row = 0; row < this.matrixEntries.length; row++) {
            if (row > 0) {
                // IntelliJ rightly complains that I am using the + operator
                // to extend a String in a loop and suggests that I use a
                // StringBuilder. The impact on time complexity of the
                // toString() method can be significant!
                // More on the topic: Fundamentals of Computing.
                result += rowSeparator;
            }
            for (int col = 0; col < this.matrixEntries[0].length; col++) {
                if (col > 0) {
                    result += entrySeparator;
                }
                result += this.matrixEntries[row][col];
            }
        }
        return result;
    }

    // This method was not required. It is included to show the
    // best practice of using a (mutable) StringBuilder rather
    // than an (immutable) String to build a String in many steps.
    private String toStringHelperEfficient(String entrySeparator, String rowSeparator) {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < this.matrixEntries.length; row++) {
            if (row > 0) {
                // IntelliJ rightly complains that I am using the + operator
                // to extend a String in a loop and suggests that I use a
                // StringBuilder. The impact on time complexity of the
                // toString() method can be significant!
                // More on the topic: Fundamentals of Computing.
                result.append(rowSeparator);
            }
            for (int col = 0; col < this.matrixEntries[0].length; col++) {
                if (col > 0) {
                    result.append(entrySeparator);
                }
                result.append(this.matrixEntries[row][col]);
            }
        }
        return result.toString();
    }

    public void prettyPrint() {
        String prettyMatrix = toStringHelper("\t", "\n");
        System.out.println(prettyMatrix);
    }

    // Exercise 7
    public boolean isSymmetrical() {
        MatrixChecker checker = new MatrixChecker();
        return checker.isSymmetrical(this.matrixEntries);
    }

    // Exercise 7
    public boolean isTriangular() {
        MatrixChecker checker = new MatrixChecker();
        return checker.isTriangular(this.matrixEntries);
    }

    // Exercise 8
    public void setMatrix(String matrixAsText) {
        char ROW_SEPARATOR = ';';
        String[] rowsAsText = split(matrixAsText, ROW_SEPARATOR);

        // the specification is not clear on whether the number of rows and
        // the number of columns in the matrix provided as a text must be
        // the same as in this Matrix; the below code assumes that this is
        // required
        if (rowsAsText.length != this.matrixEntries.length) {
            return; // wrong number of rows, refuse to do anything
        }
        // we now need to check all entries of rowsAsText whether they
        // have the correct dimension
        int[][] protoMatrix = new int[rowsAsText.length][];
        for (int i = 0; i < rowsAsText.length; i++) {
            protoMatrix[i] = parseNumbers(rowsAsText[i]);
            if (protoMatrix[i].length != this.matrixEntries[0].length) {
                return; // row has wrong number of entries, refuse to do anything
            }
        }

        // now we can be sure that the operation of reading a matrix of the
        // same size with all int entries from the given matrixAsText, so
        // we can finally write into the instance variable

        // OPTION 1:
        for (int i = 0; i < this.matrixEntries.length; i++) {
            for (int j = 0; j < this.matrixEntries[0].length; j++) {
                this.matrixEntries[i][j] = protoMatrix[i][j];
            }
        }
        // OPTION 2 (no need to make yet another copy):
        //this.matrixEntries = protoMatrix;
    }
}
