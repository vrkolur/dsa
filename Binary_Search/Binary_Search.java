package Binary_Search;

public class Binary_Search {

    private int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    private int binarySearch1(int[] nums, int target, int l, int r) {
        if (l > r)
            return -1;
        int mid = l + (r - l) / 2;
        if (nums[mid] == target)
            return mid;
        if (nums[mid] > target)
            return binarySearch1(nums, target, l, mid - 1);
        else
            return binarySearch1(nums, target, mid + 1, r);

    }

    public static void main(String[] args) {
        Binary_Search ob = new Binary_Search();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = 6;
        System.out.println(ob.binarySearch(nums, target));
        System.out.println(ob.binarySearch1(nums, target, 0, nums.length - 1));
    }
}
