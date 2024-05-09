package Graph;

import java.util.ArrayList;

public class CycleDirectedGP {
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

        graph[0].add(new edge(0, 1));
        graph[0].add(new edge(0, 4));

        graph[1].add(new edge(1, 0));
        graph[1].add(new edge(1, 2));
        // graph[1].add(new edge(1, 4));// False condition

        graph[2].add(new edge(2, 3));
        graph[2].add(new edge(2, 1));

        graph[3].add(new edge(3, 2));

        graph[4].add(new edge(4, 0));
        // graph[4].add(new edge(4, 1));  // False condition
        graph[4].add(new edge(4, 5));

        graph[5].add(new edge(5, 4));
       
    }

    public static boolean isCycle(ArrayList<edge>[] graph, int curr, int par, boolean[] isVisited) {
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (isVisited[e.dest] && e.dest != par)
                return true;

            else if (!isVisited[e.dest]) {
                if (isCycle(graph, e.dest, curr, isVisited))
                    return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<edge>[] graph = new ArrayList[v];
        createGraph(graph);
        boolean[] isVisited = new boolean[v];
        System.out.println(isCycle(graph, 0, -1, isVisited));

    }
}
