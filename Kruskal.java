import java.util.*;

class DSU{
    private int[] parent, rank;
    public DSU(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int find(int i){
        if(parent[i]!=i){
            parent[i]=find(parent[i]);
        }
        return parent[i];
    }
    public void union(int x,int y){
        int s1=find(x);
        int s2=find(y);
        if(s1!=s2){
            if(rank[s1]<rank[s2]){
                parent[s1]=s2;
            } else if(rank[s1]>rank[s2]){
                parent[s2]=s1;
            } else{
                parent[s2]=s1;
                rank[s1]++;
            }
        }
    }
}
public class Kruskal {
    public static int kruskalMST(int V, int[][] edges){
        Arrays.sort(edges, Comparator.comparingInt(e->e[2]));
        DSU dsu=new DSU(V);
        int cost=0,count=0;
        for(int[] e:edges){
            int x=e[0], y=e[1], w=e[2];
            if(dsu.find(x)!=dsu.find(y)){
                dsu.union(x,y);
                cost+=w;
                if(++count==V-1) break;
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        int[][] edges = {
            {0, 1, 10},
            {0, 2, 6},
            {0, 3, 5},
            {1, 3, 15},
            {2, 3, 4}
        };
        System.out.println("Minimum Cost of Spanning Tree: " + kruskalMST(4, edges));
    }

}