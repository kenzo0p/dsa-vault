package Atlassian.Easy;

public class PalindromeNumber {

    public  boolean isPalindrome(int x){
        if(x < 0){
            return false;
        }

        int x_copy = x;
        int rev_num= 0;
        while(x_copy != 0){
            // int lastDigit = x_copy %10;
            rev_num = (rev_num *10) + (x_copy %10);
            x_copy /=10;
        }

        return rev_num == x;
    }
    
}
