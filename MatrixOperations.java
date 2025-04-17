import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input dimensions of Matrix A
        System.out.print("Enter rows and columns of Matrix A: ");
        int rowsA = sc.nextInt();
        int colsA = sc.nextInt();

        // Input dimensions of Matrix B
        System.out.print("Enter rows and columns of Matrix B: ");
        int rowsB = sc.nextInt();
        int colsB = sc.nextInt();

        // Initialize matrices
        int[][] A = new int[rowsA][colsA];
        int[][] B = new int[rowsB][colsB];

        // Input Matrix A
        System.out.println("Enter elements of Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // Input Matrix B
        System.out.println("Enter elements of Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // Addition and Subtraction
        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("\nMatrix Addition:");
            printMatrix(addMatrices(A, B));

            System.out.println("\nMatrix Subtraction (A - B):");
            printMatrix(subtractMatrices(A, B));
        } else {
            System.out.println("\nAddition and Subtraction not possible due to different dimensions.");
        }

        // Multiplication
        if (colsA == rowsB) {
            System.out.println("\nMatrix Multiplication (A * B):");
            printMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("\nMultiplication not possible. Columns of A must equal rows of B.");
        }

        sc.close();
    }

    // Add matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    // Subtract matrices
    public static int[][] subtractMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    // Multiply matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Print matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }
}
