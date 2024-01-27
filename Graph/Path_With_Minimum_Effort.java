package Graph;

import java.util.PriorityQueue;

public class Path_With_Minimum_Effort {

    class Tuple {
        int distance, row, column;

        Tuple(int x, int y, int z) {
            this.distance = x;
            this.row = y;
            this.column = z;
        }
    }

    public int minimumEffort(int[][] grid) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        int n = grid.length, m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        pq.offer(new Tuple(0, 0, 0));
        int[] dir = { 0, 1, 0, -1, 0 };
        while (!pq.isEmpty()) {
            Tuple it = pq.poll();
            int diff = it.distance;
            int r = it.row;
            int c = it.column;
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i], nc = c + dir[i + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newDiff = Math.max(Math.abs(grid[r][c] - grid[nr][nc]), diff);
                    if (newDiff < dist[nr][nc]) {
                        dist[nr][nc] = newDiff;
                        pq.add(new Tuple(newDiff, nr, nc));
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }
    
    public static void main(String[] args) {
        Path_With_Minimum_Effort ob = new Path_With_Minimum_Effort();
        int[][] grid = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        System.out.println(ob.minimumEffort(grid));
    }
}
