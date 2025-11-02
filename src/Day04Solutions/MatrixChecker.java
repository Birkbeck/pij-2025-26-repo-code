// Exercise 7
public class MatrixChecker {
    public boolean isSymmetrical(int[][] matrix) {
        if (! isSquareMatrix(matrix)) {
            return false;
        }
        // we now know that we can use matrix.length for all boundaries
        for (int i = 0; i < matrix.length; i++) {
            // for (int j = 0; j < i; j++) { // possible optimisation
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        // still here, despite all checks? Then symmetry must hold.
        return true;
    }

    private boolean isSquareMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            // the matrix is not a square
            if (matrix[i].length != matrix.length) {
                return false;
            }
        }
        return true;
    }

    public boolean isTriangular(int[][] matrix) {
        if (! isSquareMatrix(matrix)) {
            return false;
        }
        // we now know that we can use matrix.length for all boundaries
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
