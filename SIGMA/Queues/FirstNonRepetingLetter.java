import java.util.*;
public class FirstNonRepetingLetter {


    /*
     * Firs non repeating element 
     * example - > aabccxb ans - > x
     * 
     */

    public static void printNonRepeating(String str){
        // creating an freqeincy array to track the a to z numbers to track how many time they have come
        int freq[] = new int[26];//'a to z'
        // creating a queue for checking  the elem freq
        Queue<Character> q = new LinkedList<>();

        // a loop for string
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            // chechking the if my q first elem is  >  1 if not remove it
            while(!q.isEmpty() && freq[q.peek() - 'a'] > 1){
                q.remove();

            }
        }
        // then if q is empty that means koi non repeating elem exist nhi karta return -1   else return the peek elem
        if(q.isEmpty()){
            System.out.print(-1+" ");
        }else {
            System.out.print(q.peek() + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        String str  = "aabccxb";//output :- a -1 b b b b x
        printNonRepeating(str);
    }
}
