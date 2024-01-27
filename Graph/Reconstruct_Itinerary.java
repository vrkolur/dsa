package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Reconstruct_Itinerary {
    Map<String, PriorityQueue<String>> flights = new HashMap<>();
    LinkedList<String> path = new LinkedList<>();

    private List<String> findItinerary(String[][] tickets) {

        for (String[] it : tickets) {
            flights.putIfAbsent(it[0], new PriorityQueue<>());
            flights.get(it[0]).offer(it[1]);
        }
        dfs("J");
        return path;
    }

    private void dfs(String dep) {
        PriorityQueue<String> it = flights.get(dep);
        while (!it.isEmpty()) {
            dfs(it.poll());
        }
        path.addFirst(dep);
    }

    public static void main(String[] args) {
        Reconstruct_Itinerary ob = new Reconstruct_Itinerary();
        String[][] tickets = { { "J", "S" }, { "J", "A" }, { "A", "J" }, { "S", "A" }, { "A", "S" } };
        System.out.println(ob.findItinerary(tickets));
    }
}
