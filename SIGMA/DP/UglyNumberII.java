public class UglyNumberII {
      /*
         * 264. Ugly Number II
         * Solved
         * Medium
         * Topics
         * premium lock icon
         * Companies
         * Hint
         * An ugly number is a positive integer whose prime factors are limited to 2, 3,
         * and 5.
         * 
         * Given an integer n, return the nth ugly number.
         * 
         * 
         * 
         * Example 1:
         * 
         * Input: n = 10
         * Output: 12
         * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10
         * ugly numbers.
         * Example 2:
         * 
         * Input: n = 1
         * Output: 1
         * Explanation: 1 has no prime factors, therefore all of its prime factors are
         * limited to 2, 3, and 5.
         * 
         * 
         * Constraints:
         * 
         * 1 <= n <= 1690
         */

          public int nthUglyNumber(int n) {
            //creating array to store the ugly numbers
            int t[] = new int[n+1];

            // t[i] = ith ugly number
            // t[n] = nth ugly number
            // return t[n]

            //1st ugly number is one
            int i2;
            int i3;
            int i5;
            i2 = i3 = i5 = 1;

            //first ugly number is one
            t[1] = 1;



            for(int i = 2;i<=n;i++){
                int i2UglyNumber = t[i2]*2;
                int i3UglyNumber = t[i3]*3;
                int i5UglyNumber = t[i5]*5;

                int minUglyNumber = Math.min(i2UglyNumber , Math.min(i3UglyNumber , i5UglyNumber));


                //jiska minimum hua uske pointer ko bdhate hain
             //same bhi aa sakte hain isliye else if nahi on if statment
                if(minUglyNumber == i2UglyNumber){
                    i2++;
                }
                if(minUglyNumber == i3UglyNumber){
                    i3++;
                }
                if(minUglyNumber == i5UglyNumber){
                    i5++;
                }

            }


            return t[n]; // nth ugly number


          }
    public static void main(String[] args) {
      
    }
}
