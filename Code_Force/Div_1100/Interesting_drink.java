package Code_Force.Div_1100;

import java.util.Arrays;
import java.util.Scanner;

public class Interesting_drink {
    static int findFloor(int[] nums, int x) {
        int n = nums.length;
        if (x < nums[0])
            return 0;
        else if (x > nums[n - 1])
            return n;
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            // maybe an answer
            if (nums[mid] <= x) {
                ans = mid;
                // look for smaller index on the left
                low = mid + 1;
            } else {
                high = mid - 1; // look on the right
            }
        }
        return ans+1;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = cin.nextInt();
        }
        Arrays.sort(cost);
        int m = cin.nextInt();
        int[] days = new int[m];
        for (int i = 0; i < m; i++) {
            days[i] = cin.nextInt();
        }
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = findFloor(cost, days[i]);
        }
        // System.out.println("*******************");
        for (int i = 0; i < m; i++)
            System.out.println(res[i]);
        cin.close();

    }
}
