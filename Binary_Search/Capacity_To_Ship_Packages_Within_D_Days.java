package Binary_Search;

import java.util.Arrays;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class Capacity_To_Ship_Packages_Within_D_Days {

    private int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream((weights)).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int mid;

        while (l <= r) {
            mid = l + (r - l) / 2;
            int maxDays = countDays(weights, mid);
            if (maxDays <= days) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // Count the number of days
    private int countDays(int[] arr, int maxCapacity) {
        int days = 1;
        int load = 0;
        for (int i = 0; i < arr.length; i++) {
            if (load + arr[i] > maxCapacity) {
                days += 1;
                load = arr[i];
            } else {
                load += arr[i];
            }
        }
        return days;
    }

    public static void main(String[] args) {
        Capacity_To_Ship_Packages_Within_D_Days ob = new Capacity_To_Ship_Packages_Within_D_Days();
//        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        System.out.println(ob.shipWithinDays(weights, days));
//        System.out.println(ob.countDays(weights, 10));
    }

}
