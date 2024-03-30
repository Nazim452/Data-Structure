package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    
    static class edge {
        int src;
        int dest;

        public edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }
    }

    public static void createGraph(ArrayList<edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<edge>();
        }
        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 2));

        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 3));

        graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 4));

        graph[3].add(new edge(3, 1));
        graph[3].add(new edge(3, 4));
        graph[3].add(new edge(3, 5));

        graph[4].add(new edge(4, 2));
        graph[4].add(new edge(4, 3));
        graph[4].add(new edge(4, 5));

        graph[5].add(new edge(5, 3));
        graph[5].add(new edge(5, 4));
        graph[5].add(new edge(5, 6));

        graph[6].add(new edge(6, 5));

    }


     public static void bfs(ArrayList<edge> graph[], int v, boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while(!q.isEmpty()){
            int curr = q.remove();

            if(vis[curr]==false){
                System.out.print(curr+" ");
                vis[curr]= true;

                for(int i = 0; i<graph[curr].size(); i++){
                    edge e = graph[curr].get(i);
                    q.add(e.dest);
                }

            }
        }

    }
    public static void main(String[] args) {

        int v = 7;
        
        ArrayList<edge>[] graph = new ArrayList[v];
        createGraph(graph);

        boolean []isVisited = new boolean[v];
       
        bfs(graph, v, isVisited);


    }
}
