package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class Walls_and_Gates {

    // not working here but acccepted in LintCode(Chinese)
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        int[] dirs = { 0, 1, 0, -1, 0 };
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (rooms[i][j] == 0)
                    q.offer(new int[] { i, j });

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int i = p[0];
            int j = p[1];
            for (int k = 0; k < 4; ++k) {
                int x = i + dirs[k];
                int y = j + dirs[k + 1];
                if (x < 0 || x == m || y < 0 || y == n)
                    continue;
                if (rooms[x][y] != Integer.MAX_VALUE)
                    continue;
                rooms[x][y] = rooms[i][j] + 1;
                q.offer(new int[] { x, y });
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] rooms = { { 99, -1, 0, 99 }, { 99, 99, 99, -1 }, { 99, -1, 99, -1 }, { 0, -1, 99, 99 } };
        Walls_and_Gates ob = new Walls_and_Gates();
        ob.wallsAndGates(rooms);
    }
}
