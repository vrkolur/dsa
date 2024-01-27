package Graph;

public class Surrounded_Regions {
    int dir[] = { 0, 1, 0, -1, 0 };

    public void dfs(int i, int j, char[][] board, boolean[][] vis) {
        vis[i][j] = true;
        int m = board.length, n = board[0].length;
        for (int it = 0; it < 4; it++) {
            int nr = i + dir[it];
            int nc = j + dir[it + 1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && board[nr][nc] == '0')
                dfs(nr, nc, board, vis);
        }
    }

    public void solve(char[][] board, boolean[][] vis) {
        int m = board.length, n = board[0].length;
        // Traverse both border rows
        for (int i = 0; i < n; i++) {
            if (!vis[0][i] && board[0][i] == '0')
                dfs(0, i, board, vis);
            if (!vis[m - 1][i] && board[m - 1][i] == '0')
                dfs(m - 1, i, board, vis);
        }
        // Traverse both the end columns
        for (int j = 0; j < m; j++) {
            if (!vis[j][0] && board[j][0] == '0')
                dfs(j, 0, board, vis);
            if (!vis[j][n - 1] && board[j][n - 1] == '0')
                dfs(j, n - 1, board, vis);
        }
        // after doing change the 0->x
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && board[i][j] == '0')
                    board[i][j] = 'x';
            }
        }
    }

    public static void main(String[] args) {
        Surrounded_Regions ob = new Surrounded_Regions();
        char[][] board = { { 'x', 'x', 'x', 'x' },
                { 'x', '0', '0', 'x', },
                { 'x', 'x', '0', 'x' },
                { 'x', '0', 'x', 'x' }
        };
        boolean[][] vis = new boolean[board.length][board[0].length];
        ob.solve(board, vis);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
                // System.out.print(vis[i][j] + " ");
            }
            System.out.println();
        }
    }
}
