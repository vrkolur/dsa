package Binary_Search;

public class Search_Insert_Position {

    private int searchInsert(int[] arr, int target) {
        int l = 0, r = arr.length - 1, mid, ans = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        Search_Insert_Position ob = new Search_Insert_Position();
        int[] arr = { 1, 3, 5, 6 };
        int target =2;
        System.out.println(ob.searchInsert(arr, target));
    }
}
