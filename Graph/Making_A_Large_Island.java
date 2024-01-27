package Graph;

import java.util.HashSet;

public class Making_A_Large_Island {

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSets ds = new DisjointSets(n * n);
        int[] dir = { 0, 1, 0, -1, 0 };
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0)
                    continue;
                for (int k = 0; k < 4; k++) {
                    int nr = r + dir[k];
                    int nc = c + dir[k + 1];
                    if (isValid(nr, nc, n) && grid[nr][nc]==1) {
                        int node = r * n + c;
                        int adjNode = nr * n + nc;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }
        // This is the max size.
        int mx = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1)
                    continue;
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int nr = r + dir[k];
                    int nc = c + dir[k + 1];
                    if (isValid(nr, nc, n)) {
                        if (grid[nr][nc] == 1) {
                            set.add(ds.findUltiParent(nr * n + nc));
                        }
                    }
                }
                int total = 0;
                for (Integer it : set) {
                    total += ds.size.get(it);
                }
                mx = Math.max(mx, total + 1);
            }
        }
        for (int i = 0; i < n * n; i++) {
            mx = Math.max(mx, ds.size.get(ds.findUltiParent(i)));
        }
        return mx;

        // int n = grid.length;
        // DisjointSets ds = new DisjointSets(n * n);
        // // step - 1
        // for (int row = 0; row < n; row++) {
        //     for (int col = 0; col < n; col++) {
        //         if (grid[row][col] == 0)
        //             continue;
        //         int dr[] = { -1, 0, 1, 0 };
        //         int dc[] = { 0, -1, 0, 1 };
        //         for (int ind = 0; ind < 4; ind++) {
        //             int newr = row + dr[ind];
        //             int newc = col + dc[ind];
        //             if (isValid(newr, newc, n) && grid[newr][newc] == 1) {
        //                 int nodeNo = row * n + col;
        //                 int adjNodeNo = newr * n + newc;
        //                 ds.unionBySize(nodeNo, adjNodeNo);
        //             }
        //         }
        //     }
        // }
        // int mx = 0;
        // for (int row = 0; row < n; row++) {
        //     for (int col = 0; col < n; col++) {
        //         if (grid[row][col] == 1)
        //             continue;
        //         int dr[] = { -1, 0, 1, 0 };
        //         int dc[] = { 0, -1, 0, 1 };
        //         HashSet<Integer> components = new HashSet<>();
        //         for (int ind = 0; ind < 4; ind++) {
        //             int newr = row + dr[ind];
        //             int newc = col + dc[ind];
        //             if (isValid(newr, newc, n)) {
        //                 if (grid[newr][newc] == 1) {
        //                     components.add(ds.findUltiParent(newr * n + newc));
        //                 }
        //             }
        //         }
        //         int sizeTotal = 0;
        //         for (Integer parents : components) {
        //             sizeTotal += ds.size.get(parents);
        //         }
        //         mx = Math.max(mx, sizeTotal + 1);
        //     }
        // }
        // for (int cellNo = 0; cellNo < n * n; cellNo++) {
        //     mx = Math.max(mx, ds.size.get(ds.findUltiParent(cellNo)));
        // }
        // return mx;
    }

    public boolean isValid(int i, int j, int n) {
        return (i >= 0 && i < n && j >= 0 && j < n);
    }

    public static void main(String[] args) {
        Making_A_Large_Island ob = new Making_A_Large_Island();
        // int[][] grid = {
        // { 1, 1, 0, 1, 1, 0 }, { 1, 1, 0, 1, 1, 0 },
        // { 1, 1, 0, 1, 1, 0 }, { 0, 0, 1, 0, 0, 0 },
        // { 0, 0, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 }
        // };
        int[][] grid = { { 1, 0 }, { 0, 1 } };
        System.out.println(ob.largestIsland(grid));
    }
}
