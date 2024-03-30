package Graph;

import java.util.ArrayList;

public class CycleDetectTion {
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
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new edge(0, 2));

        graph[1].add(new edge(1, 0));
        graph[2].add(new edge(2, 3));
        graph[0].add(new edge(3, 0));

    }

    public static boolean detectCycle(ArrayList<edge>[] graph, int curr, boolean[] isVisited, boolean[] rec) {
        isVisited[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);

            if (rec[e.dest]) {
                return true;
            }

            else if (!isVisited[e.dest]) {
                if (detectCycle(graph, e.dest, isVisited, rec)) {
                    return true;
                }
            }

        }
        rec[curr] = false;
        return false;

    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<edge>[] graph = new ArrayList[v];
        createGraph(graph);
        boolean[] isVisited = new boolean[v];
        boolean[] rec = new boolean[v];

        // for multiplee sub graph

        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                boolean isCycle = detectCycle(graph, 0, isVisited, rec);

                if (isCycle) {
                    System.out.println(isCycle);
                    break;
                }

            }
        }
        // System.out.println(detectCycle(graph, 0, isVisited, rec));

    }
}