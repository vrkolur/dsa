package Dynamic_Programming;

import java.util.Arrays;

public class Minimum_Path_Sum {

    // Recursion Approach Too time consuming
    private int minPathSum(int i, int j, int[][] grid) {
        // when we reach start we have to include this also to the min path sum.
        if (i == 0 && j == 0)
            return grid[0][0];

        // if out of bound return max (avoid interger overflow)
        if (i < 0 || j < 0)
            return (int) Math.pow(10, 7);

        int up = grid[i][j] + minPathSum(i - 1, j, grid);

        int left = grid[i][j] + minPathSum(i, j - 1, grid);

        // Return the min of both up and left.
        return Math.min(up, left);
    }

    // Recursion with memotisation approach
    private int minPathSum(int i, int j, int[][] grid, int[][] t) {
        if (i == 0 && j == 0)
            return grid[0][0];

        if (i < 0 || j < 0)
            return Integer.MAX_VALUE - 9876;

        if (t[i][j] != -1)
            return t[i][j];

        int up = grid[i][j] + minPathSum(i - 1, j, grid, t);
        int left = grid[i][j] + minPathSum(i, j - 1, grid, t);

        return t[i][j] = Math.min(up, left);
    }

    // Next to eleminate Stack space we use Tabulation

    private int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] t = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    t[i][j] = grid[i][j];
                else {
                    int up = Integer.MAX_VALUE - 9876;
                    int left = up;
                    if (i > 0) {
                        up = grid[i][j] + t[i - 1][j];
                    }
                    if (j > 0) {
                        left = grid[i][j] + t[i][j - 1];
                    }
                    t[i][j] = Math.min(up, left);
                }
            }
        }
        return t[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Minimum_Path_Sum ob = new Minimum_Path_Sum();
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        int m = grid.length, n = grid[0].length;
        System.out.println(ob.minPathSum(m - 1, n - 1, grid));
        int[][] t = new int[m][n];
        for (int[] it : t)
            Arrays.fill(it, -1);
        System.out.println(ob.minPathSum(m - 1, n - 1, grid, t));
        System.out.println(ob.minPathSum(grid));
    }
}
