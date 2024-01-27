package Dynamic_Programming;

import java.util.Arrays;

public class Rod_Cutting {

    // Recursive approach
    private int cutRod(int idx, int n, int[] price) {
        if (idx == 0)
            return price[0] * n;

        int notCut = 0 + cutRod(idx - 1, n, price);
        int cut = -1;
        int cutlength = idx + 1;
        if (cutlength <= n)
            cut = price[idx] + cutRod(idx, n - cutlength, price);

        return Math.max(cut, notCut);
    }

    // Now Memotization approach

    private int cutRod(int idx, int n, int[] price, int[][] t) {
        if (idx == 0)
            return price[0] * n;

        if (t[idx][n] != -1)
            return t[idx][n];

        int notCut = 0 + cutRod(idx - 1, n, price, t);
        int cut = -1;
        int cutlength = idx + 1;
        if (cutlength <= n)
            cut = price[idx] + cutRod(idx, n - cutlength, price, t);

        return t[idx][n] = Math.max(cut, notCut);
    }

    // Now the tabulation approach

    private int cutRod(int n, int[] price) {
        int[][] t = new int[n + 1][n + 1];

        // Base case when idx==0

        for (int i = 0; i <= n; i++) {
            t[0][i] = price[0] * i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int notcut = t[i - 1][j];
                int cut = -1;
                int rodlength = i + 1;
                if (rodlength <= j)
                    cut = price[i] + t[i][j - rodlength];
                t[i][j] = Math.max(cut, notcut);
            }
        }
        return t[n][n];
    }

    public static void main(String[] args) {
        Rod_Cutting ob = new Rod_Cutting();
        int n = 8;
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        System.out.println(ob.cutRod(price.length - 1, n, price));
        // Memotization
        int[][] t = new int[price.length + 1][n + 1];
        for (int[] it : t)
            Arrays.fill(it, -1);
        System.out.println(ob.cutRod(price.length - 1, n, price, t));
        //Tabulation
        System.out.println(ob.cutRod(n, price));
    }
}
