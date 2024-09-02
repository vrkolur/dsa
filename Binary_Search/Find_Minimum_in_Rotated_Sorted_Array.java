package Binary_Search;

public class Find_Minimum_in_Rotated_Sorted_Array {

    private int search(int[] arr) {
        int l = 0, r = arr.length - 1;
        int mid = -1;
        int ans = Integer.MAX_VALUE;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[l] <= arr[mid]) {
                ans = Math.min(ans, arr[l]);
                l = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                r = mid - 1;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, -1, 0, 1, 2};
        Find_Minimum_in_Rotated_Sorted_Array ob = new Find_Minimum_in_Rotated_Sorted_Array();
        System.out.println(ob.search(arr));
    }
}
