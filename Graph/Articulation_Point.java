package Graph;

import java.util.ArrayList;

public class Articulation_Point {

    private int timer = 1;

    private void dfs(int node, int parent, boolean vis[], int[] tin, int[] low, int[] mark,
            ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        int child = 0;
        for (Integer it : adj.get(node)) {
            if (it == parent)
                continue;
            if (!vis[it]) {
                dfs(it, node, vis, tin, low, mark, adj);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] >= tin[node] && parent != -1)
                    mark[node] = 1;
                child++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if (child > 1 && parent == -1)
            mark[node] = 1;
    }
    
    // private void dfs(int node, int parent, boolean vis[], int[] tin, int[] low, int[] mark,
    //         ArrayList<ArrayList<Integer>> adj) {
    //     vis[node] = true;
    //     tin[node] = low[node] = timer;
    //     timer++;
    //     int child = 0;
    //     for (Integer it : adj.get(node)) {
    //         if (it == parent)
    //             continue;
    //         if (!vis[it]) {
    //             dfs(it, node, vis, tin, low, mark, adj);
    //             low[node] = Math.min(low[node], low[it]);
    //             if (low[it] >= tin[node] && parent != -1)
    //                 mark[node] = 1;
    //             child++;
    //         } else {
    //             low[node] = Math.min(low[node], tin[it]);
    //         }
    //     }
    //     if (child > 1 && parent == -1)
    //         mark[node] = 1;
    // }

    private ArrayList<Integer> articulationPaoints(int nodes[][], int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] it : nodes) {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, tin, low, mark, adj);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i] == 1)
                ans.add(i);
        }
        if (ans.size() == 0)
            ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        Articulation_Point ob = new Articulation_Point();
        // int nodes[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 3 }, { 2, 4 }, { 2, 5 },
        // { 4, 6 }, { 5, 6 } };
        int nodes[][] = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 2, 3 },{2,0},{0,1} };
        System.out.println(ob.articulationPaoints(nodes, 5));
    }
}
