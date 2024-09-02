package Binary_Search;

public class Single_Element_in_a_Sorted_Array {

    private int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if (n == 1) return arr[0];
        if (arr[0] != arr[1]) return arr[0];
        if (arr[n - 1] != arr[n - 2]) return arr[n - 1];
        int l = 1, r = n - 2;
        int mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) return arr[mid];
            // For the left Half
            if (mid % 2 == 1 && arr[mid - 1] == arr[mid] || (mid % 2 == 0 && arr[mid + 1] == arr[mid])) l = mid + 1;
            else r = mid - 1;
        }
        //Dummy statement.
        return -1;

    }

    public static void main(String[] args) {
        Single_Element_in_a_Sorted_Array ob = new Single_Element_in_a_Sorted_Array();
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        System.out.println(ob.singleNonDuplicate(arr));
    }
}
