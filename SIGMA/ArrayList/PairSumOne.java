import java.util.ArrayList;

public class PairSumOne {
    // brute force => o(n^2)
    public static boolean pairSum(ArrayList<Integer>nums , int target){
        for(int i = 0;i<nums.size();i++){
            for(int j = i+1;j<nums.size();j++){
                if(nums.get(i) + nums.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }

    // optimal approach => 2 pointer  => o(n)
    public static boolean pair(ArrayList<Integer>nums , int target){
        int n = nums.size();
        int lp = 0;
        int rp = n-1;
        while (lp < rp) {
            if(nums.get(lp) + nums.get(rp) == target){
                return true;
            }
            // becausepar its a sorted array thats why this conditions for updation
            if(nums.get(lp) + nums.get(rp)  > target){
                rp--;
            }else {
                lp++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums= new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        System.out.println(pair(nums, 5));

    }
}
