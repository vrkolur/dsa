package Binary_Search;

public class MedianOfTwoSortedArrays {

    private double findMedianSortedArraysBrutForce(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                arr[k++] = nums1[i++];
            } else {
                arr[k++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            arr[k++] = nums1[i++];
        }
        if (arr.length % 2 == 1) return arr[arr.length / 2];
        else return (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
    }

    private double findMedianSortedArraysSpaceOptimized(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        int idx1 = n / 2;
        int idx2 = n / 2 - 1;

        int p = -1, q = -1;

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (a[i] < b[j]) {
                if (k == idx1) p = a[i];
                else if (k == idx2) q = a[i];
                i++;
                k++;
            } else {
                if (k == idx1) p = b[j];
                else if (k == idx2) q = b[j];
                j++;
                k++;
            }
        }

        while (i < n1) {
            if (k == idx1) p = a[i];
            else if (k == idx2) q = a[i];
            i++;
            k++;
        }
        while (j < n2) {
            if (k == idx1) p = b[j];
            else if (k == idx2) q = b[j];
            j++;
            k++;
        }
        if (n % 2 == 1) return p;
        else return (double) (p + q) / 2;
    }

    private double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        if (n1 > n2) return findMedianSortedArrays(b, a);
        int l = 0, r = n1;
        int left = (n1 + n2 + 1) / 2;
        while (l <= r) {
            int mid1 = (l + r) >> 1;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE, r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 < n1) r1 = a[mid1];
            if (mid2 < n2) r2 = b[mid2];
            if (mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = b[mid2 - 1];
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 > r2) {
                r = mid1 - 1;
            } else {
                l = mid1 + 1;
            }

        }
        return 0.0;
    }

    public static void main(String[] args) {

        MedianOfTwoSortedArrays ob = new MedianOfTwoSortedArrays();
        int[] arr = {2, 4, 6, 8, 10};
        int[] arr1 = {1, 3, 5, 7, 9};
        System.out.println(ob.findMedianSortedArraysBrutForce(arr, arr1));
        System.out.println(ob.findMedianSortedArraysSpaceOptimized(arr, arr1));
        System.out.println(ob.findMedianSortedArrays(arr, arr1));
    }
}
