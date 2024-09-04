package Binary_Search;

public class Split_Array_Largest_Sum {

    private int splitArray(int[] arr, int k) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for (int x : arr) {
            if (x > l) l = x;
            r += x;
        }
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