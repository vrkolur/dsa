package Arrays;

public class Next_Permutaion {

    private void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx1 = -1;
        int idx2 = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                idx1 = i;
                break;
            }
        }
        if (idx1 == -1)
            reverse(nums, 0);
        else {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] > nums[idx1]) {
                    idx2 = i;
                    break;
                }
            }
            swap(nums, idx1, idx2);
            reverse(nums, idx1 + 1);
        }
    }

    private void reverse(int[] nums, int l) {
        int r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }


    private void swap(int nums[], int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        Next_Permutaion ob = new Next_Permutaion();
        // int[] nums = { 1, 1, 5 };
        int[] nums = { 2, 1, 5, 4, 3, 0, 0 };
        ob.nextPermutation(nums);
        for (int num : nums)
            System.out.print(num + " ");
    }
}
