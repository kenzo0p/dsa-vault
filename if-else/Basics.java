import java.util.Scanner;

class Basics {
    public static void main(String[] args) {
        int a = 63;
        int b = 32;
        int c = 7;
        // if (a > b) {
        // System.out.println("A is greater");
        // } else {
        // System.out.println("B is greater");
        // }

        // print even and odd
        // if(a%2 == 0) {
        // System.out.println("It is a even number");
        // }else {
        // System.out.println("odd");
        // }

        // income tax calculator

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter your income : ");
        // int income = sc.nextInt();
        // int tax;
        // if(income < 500000){
        // tax = 0;
        // }else if(income >= 500000 && income < 1000000){
        // tax = (int)(income * 0.2);
        // } else {
        // tax = (int)(income*0.3);
        // }
        // System.out.println("Your tax is RS : " + tax);

        // largest of three
        // if(a>b && a > c){
        // System.out.println("a is greater");
        // }else if(b > c && b > a) {
        // System.out.println("b is greater");
        // }else {
        // System.out.println("c is greater");
        // }

        // ! ternary operator
        // int number = 4;
        // String type = ((number%2)==0) ? "even" : "odd";
        // System.out.println(type);

        // switch statements
        // int nm = 3;
        // switch (nm) {
        // case 1:
        // System.out.println("samosa + fat");
        // break;
        // case 2:
        // System.out.println("protein");
        // break;
        // case 3:
        // System.out.println("creatine + protein");
        // break;
        // default:
        // System.out.println("Go to the gym");
        // }

        // calculator
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter the first nnumber : ");
        // int x = sc.nextInt();
        // System.out.println("Enter the second number : ");
        // int y = sc.nextInt();
        // System.out.println("Enter the operation : ");
        // String operation = sc.next();
        // // char operator = sc.next().charAt(0);
        // switch (operation) {
        // case "Addition":
        // System.out.println(x + y);
        // break;
        // case "Substraction":
        // System.out.println(x - y);
        // break;
        // case "Multiplication":
        // System.out.println(x * y);
        // break;
        // case "Division":
        // System.out.println(x / y);
        // break;
        // case "Modulo":
        // System.out.println(x % y);
        // break;

        // default:
        // System.out.println("You entered a wrong operation");
        // }

        // questions

        // ! 1

        // float num = sc.nextFloat();
        // if (num >= 0) {
        // System.out.println("positive number");
        // }else {
        // System.out.println("Negative number");
        // }

        // ! 2

        // double temp = 103.5;
        // if (temp > 100) {
        // System.out.println("You have fever");
        // }else {
        // System.out.println("You don't have fever");
        // }

        // ! 3
        // int week = sc.nextInt();

        // switch (week) {
        // case 1:System.out.println("Monday");
        // break;
        // case 2:System.out.println("Tuesday");
        // break;
        // case 3:System.out.println("Wednesday");
        // break;
        // case 4:System.out.println("Thursday");
        // break;
        // case 5:System.out.println("Friday");
        // break;
        // case 6:System.out.println("Saturday");
        // break;
        // case 7:System.out.println("Sunday");
        // break;
        // default:
        // System.out.println("there are only 7 days in a week");
        // }

        // ! 4 ans = didnt print anything

        // !5

        System.out.print("Enter the year to check whether it's leap or not: ");
        int year = sc.nextInt();
        
        // if (year % 4 == 0) {
        //     if (year % 100 == 0) {
        //         if (year % 400 == 0) {
        //             System.out.println("Leap year");
        //         } else {
        //             System.out.println("Not a leap year");
        //         }
        //     } else {
        //         System.out.println("Leap year");
        //     }
        // } else {
        //     System.out.println("Not a leap year");
        // }
        
        // sc.close();

        // another method
        boolean x = (year %4) == 0;
        boolean y = (year % 100) != 0;
        boolean z = ((year % 100) == 0 && (year % 400 == 0));
        if(x && (y || z)) {
            System.out.println(year + " is a leap year");
        }else {
            System.out.println(year + " is not a leap year");
        }
    }
}