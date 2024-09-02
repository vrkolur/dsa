package Binary_Search;

public class Floor_Ceil {

    private int floor(int[] arr, int key) {
        int l = 0, r = arr.length - 1;
        int mid;
        int ans = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] >= key) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
//  Return ans or l
        return l;
    }

    // This is the same as of lower bound
    private int ceil(int[] arr, int key) {
        int l = 0, r = arr.length - 1;
        int mid = -1;
        int ans = -1;

        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] <= key) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        // Return ans or r
        return r;
    }

    public static void main(String[] args) {
        Floor_Ceil ob = new Floor_Ceil();
        int[] arr = {10, 20, 30, 40, 50};
        int key = 25;
        System.out.println(ob.floor(arr, key));
        System.out.println(ob.ceil(arr, key));
    }
}