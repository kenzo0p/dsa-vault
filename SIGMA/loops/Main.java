package SIGMA.loops;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // while loop
        // int counter = 1;
        // while(counter <= 100){
        // System.out.println(counter + "Hello world");
        // counter ++;
        // }
        // System.out.println(counter);

        // print numbers from 1 to 10

        // int number = 1;
        // while(number <= 10){
        // System.out.println(number);
        // number++;
        // }

        // 1 to n
        Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // int number = 1;
        // while (number <= n) {
        // System.out.println(number);
        // number++;
        // }

        // sum of n natural numbers

        // int number = 1;
        // int sum = 0;
        // while(number <= n) {
        // sum = sum + number;
        // number ++;
        // }
        // System.out.println(sum);

        // for loop
        // for(int i =1; i<=10;i++){
        // System.out.println("hello");
        // }
        // for(int i =1; i<=4;i++){
        // System.out.println("* * * *");
        // }

        // print reverse number

        // int number = 10899;
        // int reverse = 0;
        // while (number > 0) {
        // int lastDigit = number % 10;
        // reverse = (reverse * 10) + lastDigit;
        // number = number / 10;
        // }
        // System.out.println(reverse);

        // do while
        // int counter = 1;
        // do {
        // System.out.println(counter + " Hello world");
        // counter ++;
        // }while(counter <= 10);

        // break and continue

        // do{
        // System.out.print("Enter the number : ");
        // int n = scn.nextInt();
        // if(n%10 == 0) {
        // break;
        // }
        // System.out.println(n);
        // }while(true);
        // do {
        // System.out.print("Enter the number : ");
        // int n = scn.nextInt();
        // if (n % 10 == 0) {
        // continue;
        // }
        // System.out.println(n);
        // } while (true);

        // check if a number is prime or not
        // int prime = scn.nextInt();
        // boolean isPrime = true;
        // if (prime == 2) {
        // System.out.println("The number is prime");

        // } else {
        // for (int i = 2; i <= Math.sqrt(prime); i++) { //prime -1
        // if (prime % i == 0) {
        // isPrime = false;
        // }
        // }
        // if (isPrime == true) {

        // System.out.println("Number is prime");
        // } else {
        // System.out.println("Number is not prime number");
        // }
        // }

        // question 1 = 2

        // question 2

        // int choice;
        // int number;
        // int evenSum = 0;
        // int oddSum = 0;
        // do {
        // System.out.print("Enter the number : ");
        // number = scn.nextInt();
        // if(number % 2 == 0){
        // evenSum = evenSum+number;
        // }else {
        // oddSum = oddSum +number;
        // }
        // System.out.print("Enter 1 if you want to continue or enter any number to exit
        // : ");
        // choice = scn.nextInt();
        // } while (choice==1);
        // System.out.println("The addition of even numbers : " + evenSum);
        // System.out.print("The addition of odd numbers : " + oddSum);

        // another solution
        // System.out.println("Enter the number to get the input that much time : ");
        // int N = scn.nextInt();
        // int EVEN = 0;
        // int ODD = 0;
        // while (N > 0) {
        // System.out.println("Enter the numbers : ");
        // int curr = scn.nextInt();
        // if(curr % 2 == 0) {
        // EVEN = EVEN + curr;
        // }else {
        // ODD = ODD + curr;
        // }
        // N--;
        // }
        // System.out.println( "EVEN : " +EVEN);
        // System.out.println( "ODD : " +ODD);

        // question 3
        System.out.println("Enter the number : ");
        int number = scn.nextInt();
        int fact = 1;// for zero condition will false
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }
        System.out.println("The factorial of " + number + " is " + fact);

        // question 4
        // int table = scn.nextInt();
        // for (int i = 1;i<=10 ;i++){
        // System.out.println(table + "*" + i + "=" +table*i);

        // }

        // question 5
        // nothing wrong in this code

        // live sessionin
        // int a = 0;
        // while(a<5){
        // System.out.println("hii");
        // a++;
        // }

    }
}

//