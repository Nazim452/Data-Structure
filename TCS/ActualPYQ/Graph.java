package TCS.ActualPYQ;

import java.util.*;


    // Problem Statement
    // You are given a Directed Acyclic Graph (DAG) with N vertices and M edges. Each edge has a
    // weight associated with it. Your task is to find the shortest path from a given source node (SRC)
    // to a destination node (DES) using the provided graph data.
    // Input Format
    // N M — Two integers representing the number of vertices (N) and the number of edges (M). 1.
    // X Y W — Three integers for each edge representing an edge from vertex X to vertex Y with
    // weight W.
    // 2.
    // SRC DES — Two integers representing the source node (SRC) and the destination node
    // (DES).
    // 3.
    // Output Format
    // Print the shortest path from SRC to DES.
    // Display the total weight of this path.
    // Example Input
    // 3 3
    // 0 1 5
    // 1 2 3
    // 0 2 10
    // 0 2
    // Example Output
    // Path: 0 -> 1 -> 2, Total Weight: 8
    

class Pair {
    int node;
    int distance;
    
    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}

public class Graph {
    public static void dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int src, int dest) {
        int[] dist = new int[V];
        int[] parent = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        
        dist[src] = 0;
        pq.add(new Pair(0, src));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            int weight = current.distance;

            if (node == dest) break;

            for (int[] edge : adj.get(node)) {
                int neighbor = edge[0];
                int edgeWeight = edge[1];

                if (dist[node] + edgeWeight < dist[neighbor]) {
                    dist[neighbor] = dist[node] + edgeWeight;
                    parent[neighbor] = node;
                    pq.add(new Pair(dist[neighbor], neighbor));
                }
            }
        }

        printPath(parent, src, dest);
        System.out.println(", Total Weight: " + dist[dest]);
    }

    public static void printPath(int[] parent, int src, int dest) {
        List<Integer> path = new ArrayList<>();
        for (int at = dest; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        
        System.out.print("Path: ");
        for (int i = 0; i < path.size(); i++) {
            if (i > 0) System.out.print(" -> ");
            System.out.print(path.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj.get(u).add(new int[]{v, w});
        }

        int src = sc.nextInt();
        int dest = sc.nextInt();

        dijkstra(V, adj, src, dest);
    }
}
