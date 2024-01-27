package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Find_whether_path_exist {

    class Pair {
        int row, column;

        Pair(int x, int y) {
            this.row = x;
            this.column = y;
        }
    }
    
    public boolean isPossible(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[] src = new int[2];
        int[] dest = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    src[0] = i;
                    src[1] = j;
                }
                if (grid[i][j] == 2) {
                    dest[0] = i;
                    dest[1] = j;
                }
            }
        }
        System.out.println(src[0]+" "+src[1]);
        q.offer(new Pair(src[0], src[1]));
        int dir[] = { 0, 1, 0, -1, 0 };
        while(!q.isEmpty()){
            Pair it = q.poll();
            int r = it.row;
            int c = it.column;
            for(int i=0;i<4;i++){
                int nr = r + dir[i], nc = c+dir[i + 1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && (grid[nr][nc] == 3 || grid[nr][nc]==2)) {
                    if (grid[nr][nc] == 2)
                        return true;
                    else
                        q.offer(new Pair(nr, nc));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Find_whether_path_exist ob = new Find_whether_path_exist();
        int[][] grid = { { 3, 0, 3, 0, 0 }, { 3, 0, 0, 0, 3 }, { 3, 3, 3, 3, 3 }, { 0, 3, 3, 2, 0 },
                { 3, 0, 0, 1, 3 } };
        System.out.println(ob.isPossible(grid));
        System.gc();
    }
}
