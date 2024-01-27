package Graph;

public class Count_Sub_Islands {

    int[] dir = { 0, 1, 0, -1, 0 };

    private int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int subIslands = 0;
        boolean[] flag = { true };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    dfs(i, j, n, m, flag,grid1,grid2);
                    if (flag[0])
                        subIslands++;
                    flag[0] = true;
                }
            }
        }
        return subIslands;
    }

    private void dfs(int i, int j, int n, int m, boolean[] flag,int[][] grid1,int[][] grid2) {
        if (grid1[i][j] == 0) {
            flag[0] = false;
            return;
        }
        grid2[i][j] = -1;
        for (int k = 0; k < 4; k++) {
            int nr = i + dir[k];
            int nc = j + dir[k + 1];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid2[nr][nc] == 1) {
                dfs(nr, nc, n, m, flag, grid1, grid2);
            }
        }
    }

    public static void main(String[] args) {
        Count_Sub_Islands ob = new Count_Sub_Islands();
        int[][] grid1 = { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 1, 1 } };
        int[][] grid2 = { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 },
                { 0, 1, 0, 1, 0 } };
        System.out.println(ob.countSubIslands(grid1, grid2));
    }
}
