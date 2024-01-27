package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Course_Schedule {

    private boolean canFinish(int n, int[][] nodes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] it : nodes) {
            adj.get(it[0]).add(it[1]);
        }
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.offer(it);
            }
        }

        if (count == n)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Course_Schedule ob = new Course_Schedule();
        int nodes[][] = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } };
        int n = 5;
        System.out.println(ob.canFinish(n, nodes));
    }
}
