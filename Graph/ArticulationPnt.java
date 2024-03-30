package Graph;

import java.util.ArrayList;

public class ArticulationPnt {
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
        graph[0].add(new edge(0, 3));

        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 2));

        graph[2].add(new edge(2, 0));
        graph[2].add(new edge(2, 1));

        graph[3].add(new edge(3, 0));
        graph[3].add(new edge(3, 4));
        // graph[3].add(new edge(3, 5));

        graph[4].add(new edge(4, 3));

    }

    public static void dfs(ArrayList<edge> graph[], int curr, int par,
            boolean vis[], int dt[], int low[], int time,
            boolean isArticulation[]) {
        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int child = 0;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (e.dest == par)
                continue;
            if (vis[e.dest]) {
                low[curr] = Math.min(low[curr], dt[e.dest]);
            } else {
                dfs(graph, e.dest, curr, vis, dt, low, time, isArticulation);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if (dt[curr] <= low[e.dest] && par != -1) {
                    isArticulation[curr] = true;
                }
                child++;
            }
        }
        if (par == -1 && child > 1) {
            isArticulation[curr] = true;
        }
    }

    public static void getArticulation(ArrayList<edge> graph[], int V) {
        int dt[] = new int[V];
        int low[] = new int[V];
        int time = 0;
        boolean vis[] = new boolean[V];
        boolean isArticulation[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, -1, vis, dt, low, time, isArticulation);
            }
        }
        for (int i = 0; i < V; i++) {
            if (isArticulation[i])
                System.out.println(i);

        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<edge>[] graph = new ArrayList[v];
        createGraph(graph);
        getArticulation(graph, v);

    }
}
