public class Practice {
    public static int times(int matrix[][], int key) {
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (key == matrix[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int sumOfSecond(int matrix[][]){
        int row = matrix.length;
        int col = matrix[0].length;
        int sum = 0;
        for(int i =1;i<row;i++){
            for(int j =0;j<col;j++){
                if(i==1){
                    sum = sum + matrix[i][j];
                }
            }
        }
        return sum;
    }

    public static void transpose(int matrix[][]){
        int row = matrix.length;
        int col = matrix[0].length;
        int transpose[][] = new int[col][row];
        for(int i = 0;i<row;i++){
            for(int j = 0;j<col;j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        printMatrix(transpose);
    }
    public static void printMatrix(int matrix[][]){
        for(int i =0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 5, 5, 5}  
        };
        // System.out.println(times(matrix, 7));
        // System.out.println(sumOfSecond(matrix));
        transpose(matrix);
       
    }
}
