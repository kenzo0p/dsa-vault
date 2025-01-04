import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {
        // System.out.println("****");
        // System.out.println("***");
        // System.out.println("**");
        // System.out.println("*");

        // ! varibles in java
        // int a = 10;
        // int b = 20;
        // System.out.println(a+b);

        // ! data types in java
        // byte c = 8;
        // System.out.println(c);
        // char d = 'a';
        // System.out.println(d);
        boolean var = true;
        // System.out.println(var);

        float price = 10;
        // System.out.println(price);
        int number = 10;
        long number2 = 1224567890;

        // sum of a and b
        // int num1 = 10;
        // int num2 = 20;
        // int sum = num1 + num2;
        // System.out.println(sum);

        // ! taking input from user

        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the first number : ");
        // int num4 = sc.nextInt();
        // System.out.println("Enter the second number : ");
        // int num5 = sc.nextInt();
        // int sum1 = num4 + num5;
        // System.out.println("the sum of two numbers are : "+sum1);

        // String input = sc.next();
        // String input1 = sc.nextLine(); //for multiword sentence
        // System.out.println(input
        // + " , " +input1);

        // product of a and b
        // System.out.println("Enter the first number : ");
        // int num4 = sc.nextInt();
        // System.out.println("Enter the second number : ");
        // int num5 = sc.nextInt();
        // int sum1 = num4 * num5;
        // System.out.println("the sum of two numbers are : "+sum1);

        // area of circle
        // System.out.println("Enter the radius of circle : ");
        // float radius = sc.nextFloat();
        // float areaOFCircle = 3.14f * radius * radius;
        // System.out.println("the sum of two numbers are : "+areaOFCircle);


        // byte -> short -> int -> float -> long -> double


        // ! type conversion
        // long a = 25;
        // int b = (int)a;
        // float a = 25.12f;
        // int b = (int) a;
        // System.out.println(b);

        // char ch = 'a';
        // int number1 = ch;
        // System.out.println(number1); //asciii value 


        // ! type promotion in expression
        // char a ='a';
        // char b = 'b';
        // System.out.println((int)a + "," + (int)b + "," + (b - a));

        // int a =10;
        // float b= 20.5f;
        // long c =25;
        // double d =30;
        // double ans = a +b +c +d;
      // // int ans = a +b +c +d; //error lossy conversion
        // System.out.println(ans);

        // byte b = 5;
        // byte a  = (byte)(b * 2);
        // System.out.println(a);


        // questions

        // 1

        // System.out.print("Enter the first number : ");
        // float num1 = sc.nextFloat(); 
        // System.out.print("Enter the second number : ");
        // float num2 = sc.nextFloat();
        // System.out.print("Enter the third number : ");
        // float num3  =sc.nextFloat();
        // float avg = (num1 + num2 + num3)/3;
        // System.out.println("The average of three numbers are : " +avg);

        // 2

        // System.out.println("Enter the side of square : ");
        // int side = sc.nextInt();
        // int areaOfSquare = side * side;
        // System.out.println("The area of sqaure is : " +areaOfSquare);

        // 3

        // System.out.println("Enter the price of pencil : ");
        // float pencil = sc.nextFloat();
        // System.out.println("Enter the price of pen : ");
        // float pen = sc.nextFloat();
        // System.out.println("Enter the price of eraser : ");
        // float eraser = sc.nextFloat();
        // float totalCost = (pen + pencil + eraser) * (1 + 18.0f/100);
        // float totalCost2 = (pen + pencil + eraser) * (0.18f * (pencil + pen + eraser));
        // System.out.println("The total cost is : "  +totalCost);

        // 4
        //ans :  double


        // 5
        // int $ = 20; //not it will not give an error "_ also valid"
    }
}