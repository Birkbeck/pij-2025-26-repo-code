public class MatrixTester {
    public static void main(String[] args) {
        // Exercise 6
        int rows = 3;
        int cols = 4;
        Matrix matrix = new Matrix(rows, cols);
        matrix.setElement(0, 0, 10);
        matrix.setRow(1, "2,3,4,5");
        matrix.setColumn(2, "6,7,8");
        matrix.prettyPrint();
        String encodedMatrix = matrix.toString();
        System.out.println(encodedMatrix);

        Matrix m2 = new Matrix(rows, cols);
        m2.setMatrix(encodedMatrix); // Exercise 8
        m2.prettyPrint();

        // Exercise 7
        System.out.println("Symmetrical: " + m2.isSymmetrical());
        System.out.println("Triangular: " + m2.isTriangular());

        Matrix symmetricalMatrix = new Matrix(3, 3);
        symmetricalMatrix.prettyPrint();
        System.out.println("Symmetrical: " + symmetricalMatrix.isSymmetrical());
        System.out.println("Triangular: " + symmetricalMatrix.isTriangular());

        Matrix triangularMatrix = new Matrix(2, 2);
        triangularMatrix.setElement(1, 0, 0);
        triangularMatrix.prettyPrint();
        System.out.println("Symmetrical: " + triangularMatrix.isSymmetrical());
        System.out.println("Triangular: " + triangularMatrix.isTriangular());
    }
}
