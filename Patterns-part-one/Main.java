import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of lines you want print : ");
        int n = sc.nextInt();

        // // Star pattern
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= i; j++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // // inverted star pattern
        // for (int i = 1; i <= n; i++) {
        //     for (int j = i; j <= n-1; j++) { // for (int j =1;j<=n-i+1

        //         System.out.print("* ");
        //     }
        //         System.out.println();
        //     }
       
        // }
        // System.out.println();
        // }

        // half pyramid pattern

        // for(int i =1;i<=n;i++){
        // for(int number = 1;number <=i;number++){
        // System.out.print(number+" ");
        // }
        // System.out.println();
        // }

        // character pattern
        // char ch = 'A';
        // for (int i = 1; i <= n; i++) {
        // for (int j = 1; j <= i; j++) {
        // System.out.print(ch + " ");
        // ch++;
        // }
        // System.out.println();
        // }

        // // reactangle pattern
        // int m = 5;
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < m; j++) {
        // System.out.print("* ");
        // }
        // System.out.println();
        // }
        // int number =1;
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(number + " ");
        // number++;
        // }
        // System.out.println();
        // }

        // pyramid

        // hollow reactangle
        int m= 5;
        for(int i =1;i<=n;i++){
            for(int j = 1;j<=m;j++){
               if(i==1 || i==n || j==1 ||j==m){
                System.out.print("*");
               }else {
                System.out.print(" ");
               }
            }
            System.out.println();
        }

    }
}
