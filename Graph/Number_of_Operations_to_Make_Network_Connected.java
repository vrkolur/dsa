package Graph;

public class Number_of_Operations_to_Make_Network_Connected {
    
    // public int makeConnected(int n, int[][] connections) {
    //     DisjointSets ds = new DisjointSets(n);

    //     int extra = 0;
    //     for (int[] it : connections) {
    //         if (ds.findUltiParent(it[0]) == ds.findUltiParent(it[1]))
    //             extra++;
    //         else
    //             ds.unionbyRank(it[0], it[1]);
    //     }
    //     // System.out.println(extra);
    //     int count = 0;
    //     for (int i = 0; i < n; i++) {
    //         if (ds.parent.get(i) == i)
    //             count++;

    //     }
    //     // System.out.println(count);
    //     if (extra >= count - 1)
    //         return count - 1;
    //     return -1;
    // }

    // Alter Solution with better time and space utilisation
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        int components = n;

        for (int[] c : connections) {
            int p1 = findParent(parent, c[0]);
            int p2 = findParent(parent, c[1]);

            if (p1 != p2) {
                parent[p1] = p2;
                components--;
            }
        }
        return components - 1;
    }

    private int findParent(int[] parent, int i) {
        if (i == parent[i])
            return i;
        return parent[i] = findParent(parent, parent[i]);
    }


    public static void main(String[] args) {
        Number_of_Operations_to_Make_Network_Connected ob = new Number_of_Operations_to_Make_Network_Connected();
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 },{1,3} };
        System.out.println(ob.makeConnected(6, edges));
    }
}
