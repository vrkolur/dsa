package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Alien_Dictonary {

    private List<Integer> topoSort(int v, List<List<Integer>> adj) {
        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i))
                indegree[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++)
            if (indegree[i] == 0)
                q.offer(i);

        List<Integer> res = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0)
                    q.offer(adjNode);
            }
        }
        return res;
    }

    private String findOrder(String[] dict, int n, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(k, adj);
        String ans = "";
        for (int it : topo) {
            ans += (char) (it + (int) ('a'));
        }
        return ans;
    }

    public static void main(String[] args) {
        Alien_Dictonary ob = new Alien_Dictonary();
        int n = 5, k = 4;
        String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
        System.out.println(ob.findOrder(dict, n, k));
    }
}

// private Map<Character, Set<Character>> adj;
// private Map<Character, Boolean> visited;
// private List<Character> result;

// public String foreignDictionary(String[] words) {
// adj = new HashMap<>();
// for (String word : words) {
// for (char c : word.toCharArray()) {
// adj.putIfAbsent(c, new HashSet<>());
// }
// }

// for (int i = 0; i < words.length - 1; i++) {
// String w1 = words[i], w2 = words[i + 1];
// int minLen = Math.min(w1.length(), w2.length());
// if (w1.length() > w2.length() && w1.substring(0,
// minLen).equals(w2.substring(0, minLen))) {
// return "";
// }
// for (int j = 0; j < minLen; j++) {
// if (w1.charAt(j) != w2.charAt(j)) {
// adj.get(w1.charAt(j)).add(w2.charAt(j));
// break;
// }
// }
// }

// visited = new HashMap<>();
// result = new ArrayList<>();
// for (char c : adj.keySet()) {
// if (dfs(c)) {
// return "";
// }
// }

// Collections.reverse(result);
// StringBuilder sb = new StringBuilder();
// for (char c : result) {
// sb.append(c);
// }
// return sb.toString();
// }

// private boolean dfs(char ch) {
// if (visited.containsKey(ch)) {
// return visited.get(ch);
// }

// visited.put(ch, true);
// for (char next : adj.get(ch)) {
// if (dfs(next)) {
// return true;
// }
// }
// visited.put(ch, false);
// result.add(ch);
// return false;
// }
