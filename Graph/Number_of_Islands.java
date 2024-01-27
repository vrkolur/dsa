package Graph;

public class Number_of_Islands {

    private int n;
    private int m;

    private int countIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0)
            return count;
        m = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        // If we want diagonally island also then go diagonally also.
        // dfs(grid, i-1, j+1);
        // dfs(grid, i+1, j+1);
        // dfs(grid, i+1, j-1);
        // dfs(grid, i-1, j-1);
    }

    public static void main(String[] args) {
        Number_of_Islands ob = new Number_of_Islands();
        char[][] grid = { { '1', '1', '0', '0', '1' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '1', '1' },
                { '0', '0', '0', '1', '1' } };
        System.out.println(ob.countIslands(grid));
        System.gc();
    }
}
