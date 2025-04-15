package DP.CatalansNumbers;

public class CountingBinaryTrees {
    public static int countBst(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] =1;
        for(int i=2;i<n+1;i++){
            //ci->> BSt (i nodes) -> dp[i]
            for(int j = 0;j<i;j++){
                int leftSubtree = dp[j];
                int rightSubtree = dp[i-j-1];
                dp[i] += leftSubtree * rightSubtree;
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(countBst(n));
    }
}
