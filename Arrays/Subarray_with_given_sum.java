package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Subarray_with_given_sum {

    private List<Integer> subarraySum(int[] nums, int sum1) {
        final int sum = sum1;
        int l = 0, r = 0, cur = 0;
        List<Integer> res = new ArrayList<>();
        for (r = 0; r < nums.length; r++) {
            cur += nums[r];
            while (cur > sum && l <= r) {
                // System.out.println(sum);
                cur = cur - nums[l];
                l++;
            }
            if (cur == sum) {
                // System.out.println("ghgv");
                res.add(l);
                res.add(r);
                return res;
            }
        }
        res.add(-1);
        return res;
    }

    public static void main(String[] args) {
        Subarray_with_given_sum ob = new Subarray_with_given_sum();
        int[] nums = { 1, 4, 20, 3, 10, 5 };
        System.out.println(ob.subarraySum(nums, 33));
    }
}
