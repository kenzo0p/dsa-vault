package LIS;

import java.util.Arrays;

public class EditDistance { 
            //solve it using m and  n 
        private static int t[][] = new int[501][501];
        private static int solve(String s1 , String s2 , int i , int j){
            if(i == s1.length()){
                return s2.length()-j; //insert in 1
            }else if(j==s2.length()){
                return s1.length() - i; // delete from 1
            }
            if(t[i][j] != -1){
                return t[i][j];
            }
            if(s1.charAt(i) == s1.charAt(j)){
                return t[i][j] =  solve(s1, s2, i+1, j+1);
            }else {
                int insert = 1 + solve(s1 , s2 ,  i , j+1);
                int delete = 1 + solve(s1 , s2 , i+1 , j);
                int replace = 1 + solve(s1,s2 , i+1,  j+1);
                return t[i][j] = Math.min(insert , Math.min(delete , replace));
            }

        }

     public static int editDistanceMemo1(String str1 , String str2){
        int n = str1.length();
        int m = str2.length();
        for(int dp[] : t){
            Arrays.fill(dp , -1);
            
        }
        return solve(str1 , str2 , 0, 0 );
    
    }
    public static int editDistance(String str1 , String str2){
        int n = str1.length();
        int m = str2.length();
        int dp [][] = new int[n+1][m+1];
        //initialize
        for(int i = 0;i<n+1;i++){
            for(int j = 0;j<m+1;j++){
                if(i==0){
                    dp[i][j] = j;
                }
                if(j==0){
                    dp[i][j] =i;
                }
            }
        }
        //botton up 
        for(int i = 1;i<n+1;i++){
            for(int j = 1;j<m+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {//diff
                    // add
                    int add = dp[i][j-1] + 1;
                    //delete
                    int del = dp[i-1][j] + 1;
                    //replace
                    int rep = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(add , Math.min(del ,rep));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "pear";
        String word2 = "sea";
        System.out.println(editDistance(word1 , word2));
    }
}
