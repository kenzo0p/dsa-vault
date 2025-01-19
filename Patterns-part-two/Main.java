public class Main {
    public static void hollowRectangle(int totRows, int totCols) {
        for (int i = 1; i <= totRows; i++) {
            for (int j = 1; j <= totCols; j++) {
                if (i == 1 || i == totRows || j == 1 || j == totCols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void invertedAndRotatedHalfPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            // for spaces
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            // for stars
            for (int stars = 1; stars <= i; stars++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void invertedHalfPyramidWithNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            for (int num = 1; num <= n - i + 1; num++) {
                System.out.print(num);
            }
            System.out.println();
        }
    }

    public static void floydsTriangle(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }

    public static void zeroOneTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }

    // butterfly pattern
    // <=2*(n-i)
    public static void butterflyPattern(int n) {
        for (int i = 1; i <= n; i++) {
            // for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // for spaces
            for (int space = 1; space <= 2 * (n - i); space++) {
                System.out.print(" ");
            }
            // for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // for second half
        for (int i = n; i >= 1; i--) {
            // for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // for spaces
            for (int space = 1; space <= 2 * (n - i); space++) {
                System.out.print(" ");
            }
            // for stars
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void hollowRhombus(int n, int m) {
        for (int i = 1; i <= n; i++) {
            // for spaces
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            // for stars
            for (int j = 1; j <= m; j++) {
                if (i == 1 || i == n || j == 1 || j == m) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void solidRhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // for spaces
            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");
            }
            for (int stars = 1; stars <= n; stars++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void diamondPattern(int n){
        for(int i = 1 ; i<=n;i++){
            // for spaces
            for(int space = 1 ; space<=n-i; space++){
                System.out.print(" ");
            }
            // for stars
            for(int star = 1 ; star<=2*i-1;star++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i = n ; i>=1;i--){
            // for spaces
            for(int space = 1 ; space<=n-i; space++){
                System.out.print(" ");
            }
            // for stars
            for(int star = 1 ; star<=2*i-1;star++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void numberPyramid(int n){
        for(int i =1;i<=n;i++){
            for(int space = 1;space<=n-i;space++){
                System.out.print(" ");
            }
            for(int j =1 ;j<=i;j++){
                System.out.print(j);
            }
            for(int j = i-1;j>=1;j--){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void numberPyramidTwo(int n){
        int num = 1;
        for(int i = 1;i<=n;i++){
            for(int space = 1;space<=n-i;space++){
                System.out.print("\t");
            }
            for(int j = 1;j<=i;j++){
                System.out.print(num+"\t\t");
                num++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        // hollowRectangle(5,7);
        // invertedAndRotatedHalfPyramid(5);
        // invertedHalfPyramidWithNumbers(100);
        // floydsTriangle(5);
        // zeroOneTriangle(5);
        // butterflyPattern(10);
        // solidRhombus(5);
        // hollowRhombus(10, 10);
        // diamondPattern(10);
        // numberPyramid(5);
        // numberPyramidTwo(8);
        
    }
}