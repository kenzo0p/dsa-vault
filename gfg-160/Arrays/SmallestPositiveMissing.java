package Arrays;
public class SmallestPositiveMissing {
    // TODO:Look this question again specifically index logic 6 and 15 number line
    static int smallestPosMis(int nums[]) {
        int n = nums.length;
        for (int i = 0; i < n; i++) { // using cycling sort
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) { // nums[i] != nums[nums[i]-1]) for
                                                                                  // finding 1 should be on 0 2 on 1
                int corIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[corIndex];
                nums[corIndex] = temp;

            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) { // like 1,2,3,4 => 1 is at 0 and 0+1 => 1 if it's not then return i+1
                return i + 1;
            }
        }
        return n + 1; // if everyone is there then n+1
    }

    public static void main(String[] args) {    
        
    }
}
