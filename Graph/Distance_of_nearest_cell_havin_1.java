package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Distance_of_nearest_cell_havin_1 {

    class node {
        int first, second, third;

        node(int x, int y, int z) {
            first = x;
            second = y;
            third = z;
        }
    }

    private int[][] nearest(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] dist = new int[m][n];
        Queue<node> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        int[] dir = { 0, 1, 0, -1, 0 };
        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            int steps = q.peek().third;
            q.poll();
            dist[r][c] = steps;
            for (int k = 0; k < 4; k++) {
                int nr = r + dir[k];
                int nc = c + dir[k + 1];
                if (nr >= 0 && nc >= 0 && nr < m && nc < n && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.offer(new node(nr, nc, steps + 1));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Distance_of_nearest_cell_havin_1 ob = new Distance_of_nearest_cell_havin_1();
        // int[][] grid={{0,1,1,0},{1,1,0,0},{0,0,1,1}};
        int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 0, 1 } };
        int[][] res = ob.nearest(grid);
        for (int[] it : res) {
            for (int i : it)
                System.out.print(i + " ");
            System.out.println();
        }

    }
}
