package Binary_Search;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
public class Minimum_Number_of_Days_to_Make_m_Bouquets {

    private int minDays(int[] arr, int m, int k) {
        int l = 1, r = -1;
        for (int x : arr) if (x > r) r = x;
        int mid;
        int ans=-1;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int countBouquets = countBouquets(arr, mid, k);
            if (countBouquets >= m) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int countBouquets(int[] arr, int day, int k) {
        int count = 0;
        int j = 0;
        for (int value : arr) {
            if (value <= day) {
                j++;
                if (j == k) {
                    count++;
                    j = 0;
                }
            } else {
                j = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Minimum_Number_of_Days_to_Make_m_Bouquets ob = new Minimum_Number_of_Days_to_Make_m_Bouquets();
        int[] arr = {7, 7, 7, 7, 12, 7, 7};
//        int[] arr = {1, 10, 3, 10, 2};
        int m = 2, k = 3;
        System.out.println(ob.minDays(arr, m, k));
    }
}
