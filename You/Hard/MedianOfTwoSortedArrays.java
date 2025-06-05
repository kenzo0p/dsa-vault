public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;
        int temp[] = new int[size];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }

            k++;
        }

        while (i < m) {
            temp[k++] = nums1[i++];
        }
        while (j < n) {
            temp[k++] = nums2[j++];
        }

        if (size % 2 == 1) {
            return (double) temp[size / 2];
        }

        return (double) (temp[size / 2] + temp[(size / 2) - 1]) / 2.0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int size = m + n;
        int idx1 = size / 2;
        int elem1 = -1;
        int idx2 = (size / 2) - 1;
        int elem2 = -1;
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                if (k == idx1) {
                    elem1 = nums1[i];
                }

                if (k == idx2) {
                    elem2 = nums1[i];
                }
                i++;
            } else {
                if (k == idx1) {
                    elem1 = nums1[j];
                }

                if (k == idx2) {
                    elem2 = nums1[j];
                }

                j++;
            }

            k++;
        }

        while (i < m) {
            if (k == idx1) {
                elem1 = nums1[i];
            }

            if (k == idx2) {
                elem2 = nums1[i];
            }
            i++;
            k++;
        }
        while (j < n) {
            if (k == idx1) {
                elem1 = nums1[j];
            }

            if (k == idx2) {
                elem2 = nums1[j];
            }

            j++;
            k++;
        }

        if (size % 2 == 1) {
            return (double) elem1;
        }

        return (double) (elem1 + elem2) / 2.0;
    }

    // using binary search
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int r = m;
        while (l <= r) {
            int px = l + (r - l) / 2;// from nums1
            int py = (m + n + 1) / 2 - px;// from nums2

            // left half
            int x1 = (px == 0) ? Integer.MIN_VALUE : nums1[px - 1];
            int x2 = (py == 0) ? Integer.MIN_VALUE : nums2[py - 1];

            // right half
            int x3 = (px == m) ? Integer.MAX_VALUE : nums1[px];
            int x4 = (py == n) ? Integer.MAX_VALUE : nums2[py];

            if (x1 <= x4 && x2 <= x3) {
                if ((m + n) % 2 == 1) {
                    return Math.max(x1, x2);
                }

                return (Math.max(x1, x2) + Math.min(x3, x4)) / 2.0;
            }

            if (x1 > x4) {
                r = px - 1;
            } else {
                l = px + 1;
            }
        }

        return -1;

    }
}