package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Implementing_Dijkstra_Algorithm {

    static class Pair {
        int distance, node;

        Pair(int x, int y) {
            node = x;
            distance = y;
        }
    }

    // This is a pair for the priority queue,
    // x->distance and y->node
    class pqPair {
        int distance, node;

        pqPair(int x, int y) {
            this.distance = x;
            this.node = y;
        }
    }

    public int[] dijkstraPQ(int v, ArrayList<ArrayList<Pair>> adj, int src) {
        PriorityQueue<pqPair> pq = new PriorityQueue<>((x, y) -> x.node - y.distance);
        int[] dis = new int[v];

        for (int i = 0; i < v; i++)
            dis[i] = Integer.MAX_VALUE;
        dis[src] = 0;
        pq.add(new pqPair(0, src));
        while (!pq.isEmpty()) {
            int dist = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int wt = adj.get(node).get(i).distance;
                int adjNode = adj.get(node).get(i).node;
                if (dist + wt < dis[adjNode]) {
                    dis[adjNode] = dist + wt;
                    pq.add(new pqPair(dis[adjNode], adjNode));
                }
            }
        }
        return dis;
    }

    public static void main(String[] args) {
        Implementing_Dijkstra_Algorithm ob = new Implementing_Dijkstra_Algorithm();
        int v = 9;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        // int source = 0;
        // Here x->Node, y-> Weight
        graph.get(0).add(new Pair(1, 4));
        graph.get(0).add(new Pair(7, 8));
        graph.get(1).add(new Pair(2, 8));
        graph.get(1).add(new Pair(7, 11));
        graph.get(1).add(new Pair(0, 7));
        graph.get(2).add(new Pair(1, 8));
        graph.get(2).add(new Pair(3, 7));
        graph.get(2).add(new Pair(8, 2));
        graph.get(2).add(new Pair(5, 4));
        graph.get(3).add(new Pair(2, 7));
        graph.get(3).add(new Pair(4, 9));
        graph.get(3).add(new Pair(5, 14));
        graph.get(4).add(new Pair(3, 9));
        graph.get(4).add(new Pair(5, 10));
        graph.get(5).add(new Pair(4, 10));
        graph.get(5).add(new Pair(6, 2));
        graph.get(6).add(new Pair(5, 2));
        graph.get(6).add(new Pair(7, 1));
        graph.get(6).add(new Pair(8, 6));
        graph.get(7).add(new Pair(0, 8));
        graph.get(7).add(new Pair(1, 11));
        graph.get(7).add(new Pair(6, 1));
        graph.get(7).add(new Pair(8, 7));
        graph.get(8).add(new Pair(2, 2));
        graph.get(8).add(new Pair(6, 6));
        graph.get(8).add(new Pair(7, 1));
        int[] distance = ob.dijkstraPQ(v, graph, 0);
        for (int i : distance)
            System.out.print(i + " ");
        System.out.println();
    }
}
