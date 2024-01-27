package Graph;

public class Redundant_Connection {
    

    private int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        DisjointSets ds = new DisjointSets(n + 1);
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            if (ds.findUltiParent(u) == ds.findUltiParent(v))
                return new int[] { u, v };
            ds.unionbyRank(u, v);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        Redundant_Connection ob = new Redundant_Connection();
        int edges[][] = { { 3, 4 }, { 1, 2 }, { 2, 4 }, { 3, 5 }, { 2, 5 } };
        int[] res = ob.findRedundantConnection(edges);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
