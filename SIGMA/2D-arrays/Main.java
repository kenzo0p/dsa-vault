import java.util.Scanner;

public class Main {
    public static void search(int matrix[][], int key) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (key == matrix[i][j]) {
                    System.out.println(i + " " + j);
                }
            }
        }
        System.out.println("Key is not found");
    }

    public static int largest(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        // int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (smallest > matrix[i][j]) {
                    smallest = matrix[i][j];
                }
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        int matrix[][] = new int[3][3];
        Scanner sc = new Scanner(System.in);
        int rows = matrix.length;// n
        int cols = matrix[0].length;// m
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // output the element
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        // search(matrix, 3);
        System.out.println(largest(matrix));

    }
}
