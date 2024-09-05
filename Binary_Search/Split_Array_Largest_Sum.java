package Binary_Search;

import java.util.Arrays;

public class Split_Array_Largest_Sum {

    //This is the solution with O(nlogn) time complexity
    // I have written the solution w.r.t Allocate Books Problem
    private int splitArray(int[] arr, int k) {
        int l = Arrays.stream(arr).max().getAsInt();
        int r= Arrays.stream(arr).sum();
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            int countStudents = countStudents(arr, mid);
            if (countStudents <= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int countStudents(int[] arr, int max) {
        int count = 1;
        int pages = 0;
        for (int j : arr) {
            if (pages + j <= max) {
                pages += j;
            } else {
                count++;
                pages = j;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        Split_Array_Largest_Sum ob = new Split_Array_Largest_Sum();
        int[] arr = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(ob.splitArray(arr, k));
    }
}
