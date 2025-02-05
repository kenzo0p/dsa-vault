import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static void hollowReactangle(int n , int m){
        for(int i =1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(i==1 || i== n || j == 1 || j==n){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    public static void triangleOnePy(int n){
        for(int i = 1;i<=n;i++){
            for(int space = 1;space<=n-i;space++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void triangletWOPy(int n){
        for(int i = n;i>=1;i--){
            for(int space = 1;space<=n-i;space++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
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
                System.out.print("  ");
            }
            for(int j = 1;j<=i;j++){
                System.out.print(num+"   ");
                num++;
            }
            System.out.println();
        }
    }
    public static void numberPyramidThree(int n){
        int num = 1;
        for(int i = 1;i<=n;i++){
            for(int space = 1;space<=n-i;space++){
                System.out.print("  ");
            }
            for(int j = 1;j<=2*i-1;j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
        //hollowReactangle(4,4);
        //triangleOnePy(5);
        //triangletWOPy(5);
        //numberPyramid(5);
        numberPyramidTwo(5);

	}
}
