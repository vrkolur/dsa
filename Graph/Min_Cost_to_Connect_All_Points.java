package Graph;

import java.util.PriorityQueue;

public class Min_Cost_to_Connect_All_Points {

    class Tuple {
        int x, y, cost;

        Tuple(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.cost = z;
        }
    }

    private int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int reqEdges = n - 1;
        boolean vis[] = new boolean[n];
        if (n == 0)
            return 0;
        int minCost = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x, y) -> x.cost - y.cost);
        for (int i = 1; i < n; i++) {
            int cost = Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1]);
            pq.add(new Tuple(0, i, cost));
        }
        vis[0] = true;
        while (!pq.isEmpty() && reqEdges > 0) {
            Tuple it = pq.poll();
            // int x = it.x;
            int y = it.y;
            int cost = it.cost;
            if (!vis[y]) {
                minCost += cost;
                vis[y] = true;
                for (int i = 0; i < n; i++) {
                    if (!vis[i]) {
                        int dist = Math.abs(points[y][0] - points[i][0]) + Math.abs(points[y][1] - points[i][1]);
                        pq.add(new Tuple(y, i, dist));
                    }
                }
                reqEdges--;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        Min_Cost_to_Connect_All_Points ob = new Min_Cost_to_Connect_All_Points();
        int points[][] = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        System.out.println(ob.minCostConnectPoints(points));
    }
}
