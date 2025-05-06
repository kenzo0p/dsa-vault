public class FirstAndLastOccurenceOfGivenNumber {

    private int firstOccurence(int nums[], int n, int target) {
        int low = 0;
        int high = n - 1;
        int first = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return first;
    }

    private int lastOccurence(int nums[], int n, int target) {
        int low = 0;
        int high = n - 1;
        int last = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurence(nums, nums.length, target);
        if (first == -1)
            return new int[] { -1, -1 };
        int last = lastOccurence(nums, nums.length, target);
        return new int[] { first, last };
    }

    // using lower bound and upper bound first find lower bound and then upper bound

    private int lowerBound(int arr[], int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // maybe an answer
            if (arr[mid] >= x) {
                ans = mid;
                // look for small index on left
                high = mid - 1;
            } else {
                // low for small index on right
                low = mid + 1;
            }
        }

        return ans;
    }

    private static int upperBound(int arr[], int n, int x) {
        int low = 0, high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;// because i want smaller index
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int lb = lowerBound(nums, n, target);
        if (lb == n || nums[lb] != target)
            return new int[] { -1, -1 };
        return new int[] { lb, upperBound(nums, n, target) - 1 };
    }

    // number of occurancess of given element in sorted array using binary search

    public static int firstOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int first = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] == k) {
                first = mid;
                // look for smaller index on the left
                high = mid - 1;
            } else if (arr[mid] < k) {
                low = mid + 1; // look on the right
            } else {
                high = mid - 1; // look on the left
            }
        }
        return first;
    }

    public static int lastOccurrence(int[] arr, int n, int k) {
        int low = 0, high = n - 1;
        int last = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (arr[mid] == k) {
                last = mid;
                // look for larger index on the right
                low = mid + 1;
            } else if (arr[mid] < k) {
                low = mid + 1; // look on the right
            } else {
                high = mid - 1; // look on the left
            }
        }
        return last;
    }

    public static int[] firstAndLastPosition(int[] arr, int n, int k) {
        int first = firstOccurrence(arr, n, k);
        if (first == -1)
            return new int[] { -1, -1 };
        int last = lastOccurrence(arr, n, k);
        return new int[] { first, last };
    }

    public static int count(int arr[], int n, int x) {
        int[] ans = firstAndLastPosition(arr, n, x);
        if (ans[0] == -1)
            return 0;
        return (ans[1] - ans[0] + 1);
    }

    public static void main(String[] args) {

    }

}
