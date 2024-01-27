package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Is_Graph_Bipartite {

    public boolean checkBFS(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for (int node = 0; node < n; node++) {
            if (color[node] != 0)
                continue;
            Queue<Integer> q = new LinkedList<>();
            q.offer(node);
            color[node] = 1;
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int temp : graph[cur]) {
                    if (color[temp] == 0) {
                        color[temp] = -color[cur];
                        q.offer(temp);
                    } else if (color[temp] == color[cur])
                        return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Is_Graph_Bipartite ob = new Is_Graph_Bipartite();
        // int[][] graph = { { 2 }, { 3, 6 }, { 2, 4 }, { 3, 5, 7 }, { 6, 4 }, { 2, 5 }, { 4, 8 }, { 7 } };
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println(ob.checkBFS(graph));
    }
}
