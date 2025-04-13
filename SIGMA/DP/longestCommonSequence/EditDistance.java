package SIGMA.DP.longestCommonSequence;

public class EditDistance {
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
