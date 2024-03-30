package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Tropoogical {
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

        // graph[0].add(new edge(0, 2));

        // graph[1].add(new edge(1, 0));

        graph[2].add(new edge(2, 3));
        graph[3].add(new edge(3, 1));
        graph[4].add(new edge(4, 0));
        graph[5].add(new edge(5, 0));
        graph[5].add(new edge(5, 2));

    }

    public static void tropoligcalUtil(ArrayList<edge>[] graph, int curr, Stack<Integer> stack, boolean[] isVisited) {
        isVisited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            edge e = graph[curr].get(i);

            if (!isVisited[e.dest]) {
                tropoligcalUtil(graph, e.dest, stack, isVisited);

            }
        }
        stack.push(curr);
    }

    public static void tropoligcal(ArrayList<edge>[] graph, int v) {
        boolean[] isVisited = new boolean[v];
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < v; i++) {
            if (!isVisited[i]) {
                tropoligcalUtil(graph, i, stack, isVisited);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<edge> graph[] = new ArrayList[v];

        createGraph(graph);
        tropoligcal(graph, v);

    }
}
