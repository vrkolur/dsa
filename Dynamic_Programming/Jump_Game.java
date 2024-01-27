package Dynamic_Programming;

import java.util.Arrays;

public class Jump_Game {

    // iterative approach
    private boolean canJump(int idx, int[] arr) {
        if (idx >= arr.length - 1)
            return true;

        boolean ans = false;

        for (int j = arr[idx]; j > 0; j--) {
            ans = ans || canJump(idx + j, arr);
        }
        return ans;
    }

    // Memotized Approach
    private boolean canJump(int idx, int[] t, int[] nums) {
        if (idx >= nums.length)
            return true;

        if (t[idx] != -1)
            return true;

        boolean ans = false;

        for (int j = nums[idx]; j > 0; j--) {
            ans = ans | canJump(idx + j, t, nums);
            if (ans)
                break;
        }
        if (ans)
            t[idx] = 0;
        return ans;
    }

    private boolean canJump(int[] nums) {
        int max_reachable = 0;
        for (int idx = 0; idx < nums.length; idx++) {
            if (max_reachable < idx)
                return false;
            else{
                max_reachable = Math.max(max_reachable, idx + nums[idx]);
                // System.out.println(max_reachable);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Jump_Game ob = new Jump_Game();
        // int[] nums = { 1, 3, 2, 0, 2, 3 };
        int[] nums = { 3, 2, 1, 0, 4 };
        System.out.println(ob.canJump(0, nums));
        int[] t = new int[nums.length];
        Arrays.fill(t, -1);
        System.out.println(ob.canJump(0, t, nums));
        System.out.println(ob.canJump(nums));
    }
}
