package Graph;

import java.util.ArrayList;

public class Bridge {
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
        // graph[4].add(new edge(4, 5));

        // graph[5].add(new edge(5, 3));
        // graph[5].add(new edge(5, 4));

    }

    public static void dfs(ArrayList<edge>[] graph, int curr, boolean[] isVisited, int[] dt, int[] low, int time,
            int par) {

        isVisited[curr] = true;

        dt[curr] = low[curr] = ++time;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);

            if (e.dest == par)
                continue;
            else if (!isVisited[e.dest]) {
                dfs(graph, e.dest, isVisited, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);

                if (dt[curr] < low[e.dest]) {
                    System.out.println("Bridge is:- " + curr + "---" + e.dest);
                    // System.out.println(curr + e.dest);
                }

            } else {
                low[curr] = Math.min(low[curr], dt[e.dest]);

            }
        }

    }

    public static void bridge(ArrayList<edge>[] graph, int v) {
        int[] dt = new int[v];
        int[] low = new int[v];

        int time = 0;
        boolean[] isVisited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                dfs(graph, i, isVisited, dt, low, time, -1);
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<edge>[] graph = new ArrayList[v];
        createGraph(graph);
        bridge(graph, v);

    }
}
