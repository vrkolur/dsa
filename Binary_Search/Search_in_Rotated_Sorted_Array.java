package Binary_Search;

public class Search_in_Rotated_Sorted_Array {

    private int search_sorted_array(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return mid;
            // Chack the Left half
            if (arr[l] <= arr[mid]) {
                if (arr[l] <= target && target <= arr[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            // Check the right half
            if (arr[r] >= arr[mid]) {
                if (arr[mid] <= target && target <= arr[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array ob = new Search_in_Rotated_Sorted_Array();
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(ob.search_sorted_array(arr, target));
    }
}
