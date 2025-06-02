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
}