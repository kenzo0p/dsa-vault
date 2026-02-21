package premium.binary_search;

public class FindTheIndexOfLargeInteger {
    /**
     * // This is ArrayReader's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface ArrayReader {
     * // Compares the sum of arr[l..r] with the sum of arr[x..y]
     * // return 1 if sum(arr[l..r]) > sum(arr[x..y])
     * // return 0 if sum(arr[l..r]) == sum(arr[x..y])
     * // return -1 if sum(arr[l..r]) < sum(arr[x..y])
     * public int compareSub(int l, int r, int x, int y) {}
     *
     * // Returns the length of the array
     * public int length() {}
     * }
     */
    /*
     * PROBLEM INTUITION (MUST READ BEFORE CODING):
     * 
     * - All elements in the array are equal EXCEPT ONE element which is strictly
     * larger.
     * - We cannot access array values directly.
     * - We can ONLY compare SUMS of two subarrays using compareSub().
     * - Goal: find the index of the unique largest element in ≤ 20 calls.
     * 
     * KEY OBSERVATION:
     * - If two subarrays have the SAME LENGTH:
     * → the subarray containing the large element will have a larger sum.
     * - Therefore, always compare EQUAL-SIZED subarrays.
     * - This allows us to do Binary Search on indices.
     * 
     * BINARY SEARCH STRATEGY:
     * 
     * Maintain search range:
     * [left ... right]
     * 
     * At each step:
     * 1. Compute:
     * len = right - left + 1
     * mid = left + len / 2
     * 
     * 2. CASE 1: len is EVEN
     * Split into two equal halves:
     * left half = [left ... mid-1]
     * right half = [mid ... right]
     * 
     * compareSub(left, mid-1, mid, right)
     * 
     * - If left sum > right sum:
     * → large element is in left half
     * → right = mid - 1
     * - Else:
     * → large element is in right half
     * → left = mid
     * 
     * 3. CASE 2: len is ODD
     * There is ONE extra element at index mid.
     * Exclude it and compare equal halves:
     * left half = [left ... mid-1]
     * right half = [mid+1 ... right]¯¸¸¯
     * 
     * compareSub(left, mid-1, mid+1, right)
     * 
     * - If sums are equal:
     * → mid itself is the largest element (ANSWER)
     * - If left sum > right sum:
     * → large element is in left half
     * → right = mid - 1
     * - Else:
     * → large element is in right half
     * → left = mid + 1
     * 
     * STOP CONDITION:
     * - When left == right, that index is the answer.
     * 
     * IMPORTANT RULE (REMEMBER THIS):
     * - Always compare equal-sized subarrays.
     * - If length is odd, exclude the middle element.
     * 
     * Time Complexity:
     * - O(log n) API calls
     * - Always within 20 calls (constraint satisfied)
     */
    class Solution {
        public int getIndex(ArrayReader reader) {
            int left = 0;
            int right = reader.length() - 1;
            while (left < right) {
                int len = right - left + 1;
                int mid = left + len / 2;
                if (len % 2 == 0) {
                    int res = reader.compareSub(left, mid - 1, mid, right);
                    if (res > 0) {
                        right = mid - 1;

                    } else {
                        left = mid;
                    }
                } else {
                    int res = reader.compareSub(left, mid - 1, mid + 1, right);
                    if (res == 0) {
                        return mid;
                    } else if (res > 0) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }

            return left;

        }
    }

    public static void main(String[] args) {

    }
}