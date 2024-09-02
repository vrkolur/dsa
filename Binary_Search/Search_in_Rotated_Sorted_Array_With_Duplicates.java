package Binary_Search;

public class Search_in_Rotated_Sorted_Array_With_Duplicates {

    private boolean search(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] == target)
                return true;
            if (arr[l] == arr[mid] && arr[mid] == arr[r] && r!=0) {
                l++;
                r--;
            } else if (arr[l] <= arr[mid]) {
                if (arr[l] <= target && target <= arr[mid])
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            else {
                if (arr[mid] <= target && target <= arr[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array_With_Duplicates ob = new Search_in_Rotated_Sorted_Array_With_Duplicates();
//         int arr[]= {3,1,2,3,3,3,3,3,3};
        int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int target = 2;
        System.out.println(ob.search(arr, target));
    }
}
