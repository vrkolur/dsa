package Binary_Search;

public class Upper_Lower {

    private int findFloor(int[] nums, int x) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (nums[mid] <= x) {
                ans = nums[mid];
                // look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans;
    }

    private int findCeil(int[] nums, int x) {
        int n = nums.length;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (nums[mid] >= x) {
                ans = nums[mid];
                // look for smaller index on the left
                high = mid - 1;
            } else {
                low = mid + 1; // look on the right
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Upper_Lower ob = new Upper_Lower();
        int[] nums = { 2, 4, 6, 8, 10, 12, 14 };
        int target = 7;
        System.out.println(ob.findFloor(nums, target));
        System.out.println(ob.findCeil(nums, target));
    }
}
