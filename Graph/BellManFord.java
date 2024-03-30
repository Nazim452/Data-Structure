package Graph;

import java.util.ArrayList;

public class BellManFord {
    static class edge {
            int src;
            int dest;
            int wt;

            public edge(int src, int dest, int wt) {
                    this.src = src;
                    this.dest = dest;
                    this.wt = wt;

            }
    }

    public static void createGraph(ArrayList<edge>[] graph) {
            for (int i = 0; i < graph.length; i++) {
                    graph[i] = new ArrayList<>();
            }

            graph[0].add(new edge(0, 1, 2));
            graph[0].add(new edge(0, 2, 4));

            graph[1].add(new edge(1, 2, -4));

            graph[2].add(new edge(2, 3, 2));

            graph[3].add(new edge(3, 4, 4));

            graph[4].add(new edge(4,1,-1));
            // graph[4].add(new edge(4, 1, -10));

            // graph[4].add(new edge(4, 5,5));

    }

    public static void BellmanFOrd(ArrayList<edge>[] graph, int src, int V) {
            int[] dis = new int[V];

            for (int i = 0; i < V; i++) {
                    if (i != src)
                            dis[i] = Integer.MAX_VALUE;

            }

            for (int k = 0; k < V - 1; k++) {

                    for (int i = 0; i < V; i++) {
                            for (int j = 0; j < graph[i].size(); j++) {
                                    edge e = graph[i].get(j);

                                    int u = e.src;
                                    int v = e.dest;

                                    if (u != Integer.MAX_VALUE && dis[u] + e.wt < dis[v])
                                            dis[v] = dis[u] + e.wt;
                            }
                    }

            }
            // detect -ve wt cycles---->> UNcomment 640

            for (int i = 0; i < V; i++) {
                    for (int j = 0; j < graph[i].size(); j++) {
                            edge e = graph[i].get(j);

                            int u = e.src;
                            int v = e.dest;

                            if (u != Integer.MAX_VALUE && dis[u] + e.wt < dis[v])
                                   System.out.println("-ve Cycle detedted");
                    }
            }
            for (int i = 0; i < dis.length; i++) {
                    System.out.print(dis[i] + " ");
            }
    }

    public static void main(String[] args) {
            int V = 5;
            ArrayList<edge>[] graph = new ArrayList[V];
            createGraph(graph);
            BellmanFOrd(graph, 0, V);
    }
}
