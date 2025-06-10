package You.easy;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // as the array's are sorted then the last index element are bigger
        int i = m-1; // last index of the nums1
        int j = n-1; // last index of the nums1
        int k = m+n-1; // iterating from last index in nums1 to store the array in sorted manner
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){ // we are starting from last index
                nums1[k] = nums1[i];
                i--;
            }else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        //if nums2 has remainih elements
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }
}
