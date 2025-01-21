import java.util.Scanner;

public class Main  {
    public static void update(int marks[]){
        for(int i =0;i<marks.length;i++){
            marks[i] = marks[i] +1;
        }
    }
    public static void main(String[]args){
        // int marks[] = new int[50];//static size we c
        // int marksA[] = {1,2,3};
        // Scanner sc = new Scanner(System.in);
        // marks[0] = sc.nextInt();
        // marks[1] = sc.nextInt();
        // marks[2] = sc.nextInt();
        // System.out.println("phy : " +marks[0]);
        // System.out.println("chem : " +marks[1]);
        // System.out.println("bio : " +marks[2]);
        // marks[2] = 100;
        
        // System.out.println("bio : " +marks[2]);
        // int per = (marks[0] + marks[1] + marks[2]) /3;
        // System.out.println(marks.length);
        // System.out.println(per+"%");
        
        int marks[] = {97,98,99};
        update(marks);
        for (int i= 0;i<marks.length;i++){
            System.out.println(marks[i]);//arrays are call by reference
        }
    }
}