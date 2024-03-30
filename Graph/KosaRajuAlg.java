package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosaRajuAlg {
    static class edge {
        int src;
        int dest;

        // public edge(int s, int d) {
        // this.src = s;
        // this.dest = d;
        // }
        public edge(int src, int dest) {
            this.src = src;
            this.dest = dest;

        }
    }

    public static void createGraph(ArrayList<edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<edge>();
        }
        graph[0].add(new edge(0, 2));
        graph[0].add(new edge(0, 3));

        graph[1].add(new edge(1, 0));
        // graph[1].add(new edge(1, 3));

        graph[2].add(new edge(2, 1));
        // graph[2].add(new edge(2, 4));

        // graph[3].add(new edge(3, 1));
        graph[3].add(new edge(3, 4));
        // graph[3].add(new edge(3, 5));

    }

    public static void dfs(ArrayList<edge>[] graph, boolean[] isVisited, int curr) {
        isVisited[curr] = true;
        System.out.print(curr + " ");
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!isVisited[e.dest]) {
                dfs(graph, isVisited, e.dest);
            }
        }

    }

    public static void topological(ArrayList<edge>[] graph, boolean[] isVisited, int curr, Stack<Integer> st) {
        isVisited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);
            if (!isVisited[e.dest]) {
                topological(graph, isVisited, e.dest, st);
            }
        }
        st.push(curr);

    }

    static void kosaraju(ArrayList<edge>[] graph, int v) {
        // Strp-1
        Stack<Integer> st = new Stack<>();
        boolean[] isVisited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                topological(graph, isVisited, i, st);
            }
        }

        // Step-2
        ArrayList<edge> tranpose[] = new ArrayList[v];
        for (int i = 0; i < graph.length; i++) {
            isVisited[i] = false;
            tranpose[i] = new ArrayList<edge>();
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                edge e = graph[i].get(j);
                tranpose[e.dest].add(new edge(e.dest, e.src));
            }
        }

        // step-3

        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!isVisited[curr]) {
                System.out.print("SCC : ");
                dfs(tranpose, isVisited, curr);
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<edge> graph[] = new ArrayList[v];
        createGraph(graph);
        kosaraju(graph, v);

    }

}
