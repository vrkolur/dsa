package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Eventual_Safe_States {

    public void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean vis[], boolean[] path, boolean[] safe) {
        vis[node] = true;
        path[node] = true;
        safe[node] = false;
        for (int temp : adj.get(node)) {
            if (!vis[temp]) {
                if (dfs(adj, temp, vis, path, safe)) {
                    safe[temp] = false;
                    return true;
                }
            } else if (path[temp]) {
                safe[temp] = false;
                return true;
            }
        }
        safe[node] = true;
        path[node] = false;
        return false;
    }

    public List<Integer> safeNodes(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean[] vis = new boolean[v];
        boolean[] path = new boolean[v];
        boolean[] safe = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, path, safe);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int k = 0; k < v; k++) {
            if (safe[k])
                res.add(k);
        }
        return res;
    }

    public List<Integer> findSafeNodesTopoSort(ArrayList<ArrayList<Integer>> adj, int v) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adjRev.add(new ArrayList<Integer>());

        int indegree[] = new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.offer(it);
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Find_Eventual_Safe_States ob = new Find_Eventual_Safe_States();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v = 12;
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<Integer>());
        ob.addEdge(adj, 0, 1);
        ob.addEdge(adj, 1, 2);
        ob.addEdge(adj, 2, 3);
        ob.addEdge(adj, 3, 4);
        ob.addEdge(adj, 3, 5);
        ob.addEdge(adj, 4, 6);
        ob.addEdge(adj, 5, 6);
        ob.addEdge(adj, 6, 7);
        ob.addEdge(adj, 8, 1);
        ob.addEdge(adj, 8, 9);
        ob.addEdge(adj, 9, 10);
        ob.addEdge(adj, 10, 8);
        ob.addEdge(adj, 11, 9);
        System.out.println(ob.safeNodes(adj, v));
        System.out.println(ob.findSafeNodesTopoSort(adj, v));
    }
}
