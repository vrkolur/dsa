package Dynamic_Programming;

import java.util.Arrays;

public class Maximun_Falling_Path_Sum {

    private int maxPathSum(int i, int j, int[][] matrix) {
        if (j < 0 || j >= matrix[0].length)
            return Integer.MIN_VALUE;
        if (i == 0)
            return matrix[0][j];

        // Here we will do the top down approach
        int up = matrix[i][j] + maxPathSum(i - 1, j, matrix);
        int upLeft = matrix[i][j] + maxPathSum(i - 1, j - 1, matrix);
        int upRight = matrix[i][j] + maxPathSum(i - 1, j + 1, matrix);
        // return the max of all the three.
        return Math.max(up, Math.max(upLeft, upRight));
    }

    private int maxPathSum(int i, int j, int[][] matrix, int[][] t) {
        if (j < 0 || j >= matrix[0].length)
            return Integer.MIN_VALUE;
        if (i == 0)
            return matrix[0][j];

        if (t[i][j] != -1)
            return t[i][j];
        // Here we will do the top down approach
        int up = matrix[i][j] + maxPathSum(i - 1, j, matrix);
        int upLeft = matrix[i][j] + maxPathSum(i - 1, j - 1, matrix);
        int upRight = matrix[i][j] + maxPathSum(i - 1, j + 1, matrix);
        // return the max of all the three.
        return t[i][j] = Math.max(up, Math.max(upLeft, upRight));
    }

    // Now the tabulation Approach

    private int maxPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] t = new int[m][n];

        // Base case if i==0
        for (int j = 0; j < n; j++) {
            t[0][j] = matrix[0][j];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + t[i - 1][j];
                int upLeft = Integer.MIN_VALUE;
                if (j - i >= 0) {
                    upLeft = matrix[i][j] + t[i - 1][j - 1];
                }
                int upRight = Integer.MIN_VALUE;
                if (j + 1 < n) {
                    upRight = matrix[i][j] + t[i - 1][j + 1];
                }
                t[i][j] = Math.max(up, Math.max(upLeft, upRight));
            }
        }
        int tempres = Integer.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            tempres = Math.max(tempres, t[m - 1][j]);
        }
        return tempres;
    }

    public static void main(String[] args) {
        Maximun_Falling_Path_Sum ob = new Maximun_Falling_Path_Sum();
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            res = Math.max(res, ob.maxPathSum(matrix.length - 1, j, matrix));
        }
        System.out.println(res);
        // Memotization
        int[][] t = new int[matrix.length][matrix[0].length];
        for (int[] it : t)
            Arrays.fill(it, -1);
        int res1 = Integer.MIN_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            res1 = Math.max(res, ob.maxPathSum(matrix.length-1, j, matrix, t));
        }
        System.out.println(res1);
        //Tabulation
        System.out.println(ob.maxPathSum(matrix));
    }
}
