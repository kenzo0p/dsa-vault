package operators;
import java.util.Scanner;
public class Basics {
    public static void main(String[] args) {
        // arithmetic opearators

        // +,-,*,/,%
        int a = 10;
        int b = 5;
        // System.out.println("ad = " + (a+b));
        // System.out.println("mul = " + (a*b));
        // System.out.println("sub = " + (a - b));
        // System.out.println("div = " + (a / b));

        int c = --a;  // ++a
        System.out.println(c);

        //! relational operators
        // == , != , > ,< ,>=,<=


        //! logical opearators
        // && , || , !

        //!assignment operators
        // == , +=, -= , *= , /=

        // questions ----\
        // 1 = , 5 , 5
        // 2 = , java
        // 3 = , 4,0,0
        // 4 = 278
        // 5 = 20,20

        // livehhi
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the age of user : ");
        int age = sc.nextInt();
        if(age >= 18 & age < 60 ) {
            System.out.println("you are an adult");
        }else if (age >= 60) {
            System.out.println("Senior citizen");
        }else {
            System.out.println("You are child");
        }
    }
}