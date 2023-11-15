package edu.northeastern.csye6200;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class LAB8P1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();

        int[][] matrix = generateMatrix(rows, columns);

        System.out.println("The array content is:");
        printMatrix(matrix);

        ArrayList<Integer> maxRowIndices = findLargestRow(matrix);
        ArrayList<Integer> maxColumnIndices = findLargestColumn(matrix);

        System.out.println("The index of the largest row: " + maxRowIndices);
        System.out.println("The index of the largest column: " + maxColumnIndices);
    }

    public static int[][] generateMatrix(int rows, int columns) {
        Random random = new Random();
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(10);
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> findLargestRow(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        ArrayList<Integer> maxRowIndices = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int currentSum = sumRow(matrix[i]);
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxRowIndices.clear();
                maxRowIndices.add(i);
            } else if (currentSum == maxSum) {
                maxRowIndices.add(i);
            }
        }
        return maxRowIndices;
    }

    public static ArrayList<Integer> findLargestColumn(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        ArrayList<Integer> maxColumnIndices = new ArrayList<>();

        for (int j = 0; j < matrix[0].length; j++) {
            int currentSum = sumColumn(matrix, j);
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxColumnIndices.clear();
                maxColumnIndices.add(j);
            } else if (currentSum == maxSum) {
                maxColumnIndices.add(j);
            }
        }
        return maxColumnIndices;
    }

	public static int sumRow(int row[]) {
		int sum = 0;
        for (int value : row) {
            sum += value;
        }
        return sum;
	}

	public static int sumColumn(int matrix[][], int column) {
		int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][column];
        }
        return sum;
    }
}
