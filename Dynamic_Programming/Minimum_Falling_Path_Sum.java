package Dynamic_Programming;

import java.util.Arrays;

public class Minimum_Falling_Path_Sum {

    // This and Maximum_Falling_Path_Sum are both same.
    // This is the recursive approach

    private int MinPathSum(int i, int j, int[][] matrix) {
        if (j < 0 || j >= matrix[0].length)
            return Integer.MAX_VALUE - 987;

        if (i == 0)
            return matrix[0][j];

        int up = matrix[i][j] + MinPathSum(i - 1, j, matrix);
        int upLeft = matrix[i][j] + MinPathSum(i - 1, j - 1, matrix);
        int upRight = matrix[i][j] + MinPathSum(i - 1, j + 1, matrix);

        return Math.min(up, Math.min(upLeft, upRight));
    }

    // This is memotization approach
    private int MinPathSum(int i, int j, int[][] matrix, int[][] t) {
        if (j < 0 || j >= matrix[0].length)
            return Integer.MAX_VALUE - 987;

        if (i == 0)
            return matrix[0][j];
        if (t[i][j] != -1)
            return t[i][j];
        int up = matrix[i][j] + MinPathSum(i - 1, j, matrix);
        int upLeft = matrix[i][j] + MinPathSum(i - 1, j - 1, matrix);
        int upRight = matrix[i][j] + MinPathSum(i - 1, j + 1, matrix);

        return t[i][j] = Math.min(up, Math.min(upLeft, upRight));
    }

    // This is the tabulation best in time complexity even memotizaion will give you
    // TLE
    private int MinPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] t = new int[n][m];
        for (int j = 0; j < m; j++)
            t[0][j] = matrix[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = matrix[i][j] + t[i - 1][j];
                int ld = Integer.MAX_VALUE - 9876;
                if (j - 1 >= 0)
                    ld = matrix[i][j] + t[i - 1][j - 1];
                int rd = Integer.MAX_VALUE - 9876;
                if (j + 1 < m)
                    rd = matrix[i][j] + t[i - 1][j + 1];
                t[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }
        int res = t[n - 1][0];
        for (int j = 0; j < m; j++) {
            res = Math.min(res, t[n - 1][j]);
        }
        return res;
    }

    public static void main(String[] args) {
        Minimum_Falling_Path_Sum ob = new Minimum_Falling_Path_Sum();
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++)
            res = Math.min(res, ob.MinPathSum(matrix.length - 1, j, matrix));
        System.out.println(res);

        // Memotization
        int[][] t = new int[matrix.length][matrix[0].length];
        for (int[] it : t)
            Arrays.fill(it, -1);
        int res1 = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++)
            res1 = Math.min(res1, ob.MinPathSum(matrix.length - 1, j, matrix, t));
        System.out.println(res1);
        //Tablulation.
        System.out.println(ob.MinPathSum(matrix));
    }
}
