import java.util.*;

public class MinimumAbsDiffPairs {

    public static int minimumAbsDiffPairs(int[] a  ,int b[]){
        Arrays.sort(a);
        Arrays.sort(b);

        int minAbsDiff = 0;
        for(int i = 0;i<a.length;i++){
            minAbsDiff += Math.abs(a[i] - b[i]);
        }
        return minAbsDiff;
    }
    public static void main(String[]args){
        int a[] = {1,2,3};
        int b[] = {2,1,3};
        int ans = minimumAbsDiffPairs(a, b);
        System.out.println(ans);
    }
}