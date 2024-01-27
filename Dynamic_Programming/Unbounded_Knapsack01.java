package Dynamic_Programming;

import java.util.Arrays;

public class Unbounded_Knapsack01 {

    // This is the recursive approach
    private int unbounded_Knapsack01(int idx, int w, int[] wt, int[] val) {
        if (idx == 0 || w == 0)
            return 0;

        if (wt[idx - 1] <= w)
            return Math.max(val[idx - 1] + unbounded_Knapsack01(idx, w - wt[idx - 1], wt, val), // Here we will not say
                                                                                                // idx-1 because of
                                                                                                // unbounded shit
                    unbounded_Knapsack01(idx - 1, w, wt, val));
        else
            return unbounded_Knapsack01(idx - 1, w, wt, val);
    }

    private int unbounded_Knapsack01(int idx, int w, int[] wt, int[] val, int[][] t) {
        if (idx == 0 || w == 0)
            return 0;
        if (t[idx][w] != -1)
            return t[idx][w];
        if (wt[idx - 1] <= w)
            return t[idx][w] = Math.max(val[idx - 1] + unbounded_Knapsack01(idx, w - wt[idx - 1], wt, val), // Here we
                                                                                                            // will not
                                                                                                            // say
                    // idx-1 because of
                    // unbounded shit
                    unbounded_Knapsack01(idx - 1, w, wt, val));
        else
            return t[idx][w] = unbounded_Knapsack01(idx - 1, w, wt, val);
    }

    // Tabulation Approach

    private int unbounded_Knapsack01(int w, int[] wt, int[] val) {
        int n=wt.length;
        int[][] t=new int[n+1][w+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1]<=j)
                    t[i][j]=Math.max(val[i-1]+t[i][j-wt[i-1]], t[i-1][j]);
                else 
                    t[i][j]=t[i-1][j];
            }
        }
        return t[n][w];
    }

    public static void main(String[] args) {
        Unbounded_Knapsack01 ob = new Unbounded_Knapsack01();
        int[] wt = { 2, 4, 6 };
        int[] val = { 5, 11, 13 };
        int w = 10;
        System.out.println(ob.unbounded_Knapsack01(wt.length - 1, w, wt, val));
        // Memotization
        int[][] t = new int[wt.length + 1][w + 1];
        for (int[] it : t)
            Arrays.fill(it, -1);
        System.out.println(ob.unbounded_Knapsack01(wt.length - 1, w, wt, val, t));
        //Tabulation approach
        System.out.println(ob.unbounded_Knapsack01(w, wt, val));
    }
}
