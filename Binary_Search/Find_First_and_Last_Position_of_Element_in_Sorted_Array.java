package Binary_Search;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    private int[] searchRange(int[] arr, int key) {

        int l = upperBound(arr, key);
        if (arr[l] != key || arr[l] == arr.length)
            return new int[] { -1, -1 };
        int r = upperBound(arr, key + 1) -1;
        return new int[] { l, r };
    }

    private int upperBound(int[] arr, int key) {
        int l = 0, r = arr.length;
        int mid = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] >= key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Find_First_and_Last_Position_of_Element_in_Sorted_Array ob = new Find_First_and_Last_Position_of_Element_in_Sorted_Array();
        int arr[] = { 5, 7, 7, 8, 8, 10 };
        int key = 8;
        for(int x:ob.searchRange(arr, key)){
            System.out.println(x);
        }
    }
}
