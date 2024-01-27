package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Four_Sum {
    // See the brut force will be 4 for loops giving n^4 time which is shit.

    // three and four sum are the same
    private List<List<Integer>> foursum(int[] nums, int target) {
        final int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    final long sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        s.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;
                    } else if (sum > target)
                        r--;
                    else
                        l++;
                }
            }
        }
        res.addAll(s);
        return res;
    }

    public static void main(String[] args) {
        Four_Sum ob = new Four_Sum();
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        System.out.println(ob.foursum(nums, target));
    }
}
