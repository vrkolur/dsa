package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class sha1 {

    class pair {
        int first, cost;
        pair(int x, int y) {
            first = x;
            cost = y;
        }
    }

    private void dfs(int node,boolean[] vis,ArrayList<ArrayList<pair>> adj,Stack<Integer> s){
        vis[node]=true;
        for(int it=0;it<adj.get(node).size();it++){
            int v=adj.get(node).get(it).first;
            if(!vis[v])
                dfs(v,vis,adj,s);
        }
        s.push(node);
    }

    private int[] shortestPath(int[][] graph,int V){
        int n=graph.length;
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<n;i++){
            int u=graph[i][0],v=graph[i][1],wt=graph[i][2];
            adj.get(u).add(new pair(v, wt));
        }
        boolean[] vis=new boolean[V];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<V;i++)
            if(!vis[i])
                dfs(i,vis,adj,s);
        int[] dist=new int[V];
        Arrays.fill(dist,999999);
        dist[6]=0;
        while(!s.isEmpty()){
            int node=s.pop();
            for(pair it:adj.get(node)){
                int v=it.first,wt=it.cost;
                if(dist[node]+wt<dist[v])
                    dist[v]=dist[node]+wt;
            }            
        }
        return dist;
    }

    public static void main(String[] args) {
        sha1 ob = new sha1();
        int[][] graph = { { 6, 4, 2 }, { 6, 5, 3 }, { 5, 4, 1 }, { 4, 0, 3 }, { 4, 2, 1 }, { 0, 1, 2 }, { 1, 3, 1 },
                { 2, 3, 3 } };
        // here n= vertices, m= no of edges.
        int n = 7;
        int[] res=ob.shortestPath(graph, n);
        for(int num:res) System.out.print(num+" ");
    }
}
