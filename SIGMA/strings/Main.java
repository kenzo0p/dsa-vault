import java.util.Scanner;

public class Main {

    static void printStr(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    

    // !intuit
    public static boolean palindrome(String str) {
        int n = str.length();
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static float shortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char direction = path.charAt(i);
            // south
            if (direction == 'S') {
                y--;
                // north
            } else if (direction == 'N') {
                y++;
                // east
            } else if (direction == 'E') {
                x++;
                // west
            } else {
                x--;
            }
        }
        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);

    }

    public static String subString(String str  , int si , int ei){
        String subStr = "";
        for(int i = si;i<ei;i++){
            subStr += str.charAt(i);
        }
        return subStr;
    }
    // ! code notion
    public static String upperCase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i = 1;i< str.length();i++){
            if(str.charAt(i) == ' ' && i<str.length() - 1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    //! Amazon string compression
    public static String compress(String str){
        String newStr = "";
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<str.length();i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i  + 1)){
                    count++;
                    i++;
            } 
            // newStr += str.charAt(i);
            sb.append(str.charAt(i));
            if(count > 1) {
                // newStr += count.toString();
                sb.append(count.toString());
            }   
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
        String str = "xyz";
        String str3 = new String("Hii");
        // Strings are immutable in java
        Scanner sc = new Scanner(System.in);
        // String name = sc.next();
        // String FullName = sc.nextLine();
        // System.out.println(FullName.length());
        // System.out.println(FullName);
        // string concatination
        // String lastName = sc.nextLine();/
        // System.out.println(firstName +" "+ lastName);
        // charAt method

        // String firstName = sc.nextLine();
        // System.out.println(palindrome(firstName));

        // String path = "NSN";
        // System.out.println(shortestPath(path));
        // String s1 = "Tony";
        // String s2  = "Tony";
        // String s3 = new String("Tony");
        // if(s1==s2){
        //     System.out.println("String are equal");
        // }else {
        //     System.out.println("Strings are not eqaual");
        // }
        // if(s1==s3){
        //     System.out.println("String are equal");
        // }else {
        //     System.out.println("Strings are not eqaual");
        // }

        // if(s1.equals(s3)){ //for checking the string in which one is made using new keyword
        //     System.out.println("Eqaul");
        // }else {
        //     System.out.println("Not equal");
        // }



        // ! Substring
        // String s5 = "HelloWorld";
        // System.out.println(subString(s5 ,1 , 3));


        // compareTo a and A are treated as different
        // compareToIgnoreCase  a and A treated as same

        // String fruits[] = {"Apple" , "Banana" , "Mango"};
        // String largest = fruits[0];
        // for(int i = 0 ;i<fruits.length;i++){
        //     if(largest.compareTo(fruits[i]) < 0){
        //         largest = fruits[i];
        //     }
        // }
        // System.out.println(largest);


        // StringBuilder

        StringBuilder sb = new StringBuilder("");
        for(char ch = 'a' ;ch<='z';ch++){ //o(26)
            sb.append(ch);
        }
        System.out.println(sb.length());

        String ch = "aaabbcccdd";
        System.out.println(upperCase(ch));

        System.out.println(compress(ch));

    }
}