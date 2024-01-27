package Dynamic_Programming;

import java.util.Arrays;

public class Minimum_Cost_For_Tickets {

    private int minCost(int idx, int[] days, int[] cost, int n) {

        // Base Case
        if (idx >= n)
            return 0;
        // 1 day
        int opt1 = cost[0] + minCost(idx + 1, days, cost, n);

        // 7 days
        int i;
        for (i = idx; i < n && days[i] < days[idx] + 7; i++)
            ;

        int opt2 = cost[1] + minCost(i, days, cost, n);

        // 30 days
        for (i = idx; i < n && days[i] < days[idx] + 30; i++)
            ;
        int opt3 = cost[2] + minCost(i, days, cost, n);

        return Math.min(opt1, Math.min(opt2, opt3));
    }

    // Memotization version

    private int minCost(int idx, int[] days, int[] cost, int n, int[] t) {

        // Base Case
        if (idx >= n)
            return 0;

        if (t[idx] != -1)
            return t[idx];
        // 1 day
        int opt1 = cost[0] + minCost(idx + 1, days, cost, n, t);

        // 7 days
        int i;
        for (i = idx; i < n && days[i] < days[idx] + 7; i++)
            ;

        int opt2 = cost[1] + minCost(i, days, cost, n, t);

        // 30 days
        for (i = idx; i < n && days[i] < days[idx] + 30; i++)
            ;
        int opt3 = cost[2] + minCost(i, days, cost, n, t);

        return t[idx] = Math.min(opt1, Math.min(opt2, opt3));
    }

    // Tabulation (Bottom up approach)

    private int minCost(int[] days, int[] cost) {
        int n = days.length;
        int[] t = new int[n + 1];
        Arrays.fill(t,Integer.MAX_VALUE-987);
        t[n] = 0;
        for (int k = n - 1; k >= 0; k--) {
            // 1 day
            int opt1 = cost[0] + t[k + 1];

            // 7 days
            int i;
            for (i = k; i < n && days[i] < days[k] + 7; i++)
                ;
            int opt2 = cost[1] + t[i];

            // 30 days
            for (i = k; i < n && days[i] < days[k] + 30; i++)
                ;
            int opt3 = cost[2] + t[i];

            t[k] = Math.min(opt1, Math.min(opt2, opt3));
        }
        return t[0];
    }

    public static void main(String[] args) {
        Minimum_Cost_For_Tickets ob = new Minimum_Cost_For_Tickets();
        int[] days = { 1, 4, 6, 7, 8, 20 };
        int[] cost = { 2, 7, 15 };
        System.out.println(ob.minCost(0, days, cost, days.length));
        int[] t = new int[days.length];
        Arrays.fill(t, -1);
        System.out.println(ob.minCost(0, days, cost, days.length, t));
        System.out.println(ob.minCost(days, cost));
    }
}
