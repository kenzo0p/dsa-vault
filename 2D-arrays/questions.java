
public class questions {
    // !Google ,amazon, apple, oracle, microsoft
    public static void printspiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // top boundary
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }
            // right boundary
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " ");
            }
            // bottom boundary
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }
            // left boundary
            for (int i = endRow - 1; i >= startRow + 1; i--) {
                System.out.print(matrix[i][startCol] + " ");
            }
            startCol++;
            endCol--;
            startRow++;
            endRow--;
        }
        System.out.println();
    }

    // !amazon google
    public static int diagonalSum(int matrix[][]) {
        int sum = 0;
        // brute force o(n^2)
        // for (int i = 0; i < matrix.length; i++) {
        //     for (int j = 0; j < matrix[0].length; j++) {
        //         if (i == j) {
        //             sum = sum + matrix[i][j];
        //         } else if (i + j == matrix.length - 1) {
        //             sum = sum + matrix[i][j];
        //         }
        //     }
        // }



        // for best time compexicity o(n)
        for(int i = 0;i<matrix.length;i++){
            // for primary diagnol sum
            sum+=matrix[i][i];
            // secondary diagonal sum
            if(i!=matrix.length-1-i){
                sum+=matrix[i][matrix.length-i-1];
            }
        }
        return sum;
    }

    // ! oracle  , adobe

    public static boolean stairCaseSearch(int matrix[][],int key){
        int row = 0;
        int col = matrix[0].length-1;
        while(row < matrix.length && col>=0){
            if(matrix[row][col] == key){
                System.out.println("Found key at: "+row + " " + col);
                return true;
            }else if(key < matrix[row][col]){
                col--;
            }else {
                row++;
            }
        }
        System.out.println("Key is not found");
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        int key = 14;
        System.out.println(stairCaseSearch(matrix, key));
        int sum = diagonalSum(matrix);
        System.out.println(sum);
    }
}
