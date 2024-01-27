package Graph;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Shortest_Path_in_Weighted_undirected_graph {

    static class pair {
        int first, second;

        pair(int x, int y) {
            first = x;
            second = y;
        }
    }

    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> x.first - y.first);
        int[] dis = new int[n + 1];
        int parent[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        dis[1] = 0;
        pq.add(new pair(0, 1));
        while (!pq.isEmpty()) {
            int node = pq.peek().second;
            int dist = pq.peek().first;
            pq.remove();
            for (pair it : adj.get(node)) {
                int adjNode = it.first;
                int wt = it.second;
                if (dist + wt < dis[adjNode]) {
                    dis[adjNode] = dist + wt;
                    pq.add(new pair(dis[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if (dis[n] == Integer.MAX_VALUE) {
            path.add(-1);
            return path;
        }
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }

    public List<Integer> shortestPath1(int v, ArrayList<ArrayList<pair>> adj) {
        int[] dist = new int[v];
        int parent[] = new int[v];
        for (int i = 0; i < v; i++) {
            dist[i] = 99999;
            parent[i] = i;
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> x.first - y.second);
        pq.offer(new pair(0, 0));
        dist[0] = 0;
        while (!pq.isEmpty()) {
            int cost = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            for (pair it : adj.get(node)) {
                int adjNode = it.first;
                int wt = it.second;
                if (cost + wt < dist[adjNode]) {
                    dist[adjNode] = cost + wt;
                    pq.offer(new pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        int node = v - 1;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(0);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        Shortest_Path_in_Weighted_undirected_graph ob = new Shortest_Path_in_Weighted_undirected_graph();
        int[][] edges = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 },
                { 3, 5, 1 } };
        int n = 5;
        int e = 6;
        System.out.println(ob.shortestPath(n, e, edges));
        // ****************************************************************
        // int v = 9;
        // ArrayList<ArrayList<pair>> graph = new ArrayList<>();
        // for (int i = 0; i < v; i++) {
        //     graph.add(new ArrayList<>());
        // }
        // // int source = 0;
        // // Here x->Node, y-> Weight
        // graph.get(0).add(new pair(1, 4));
        // graph.get(0).add(new pair(7, 8));
        // graph.get(1).add(new pair(2, 8));
        // graph.get(1).add(new pair(7, 11));
        // graph.get(1).add(new pair(0, 7));
        // graph.get(2).add(new pair(1, 8));
        // graph.get(2).add(new pair(3, 7));
        // graph.get(2).add(new pair(8, 2));
        // graph.get(2).add(new pair(5, 4));
        // graph.get(3).add(new pair(2, 7));
        // graph.get(3).add(new pair(4, 9));
        // graph.get(3).add(new pair(5, 14));
        // graph.get(4).add(new pair(3, 9));
        // graph.get(4).add(new pair(5, 10));
        // graph.get(5).add(new pair(4, 10));
        // graph.get(5).add(new pair(6, 2));
        // graph.get(6).add(new pair(5, 2));
        // graph.get(6).add(new pair(7, 1));
        // graph.get(6).add(new pair(8, 6));
        // graph.get(7).add(new pair(0, 8));
        // graph.get(7).add(new pair(1, 11));
        // graph.get(7).add(new pair(6, 1));
        // graph.get(7).add(new pair(8, 7));
        // graph.get(8).add(new pair(2, 2));
        // graph.get(8).add(new pair(6, 6));
        // graph.get(8).add(new pair(7, 1));
        // System.out.println(ob.shortestPath1(v, graph));
    }
}
