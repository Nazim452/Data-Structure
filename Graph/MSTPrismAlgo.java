// package Graph;

// import java.util.ArrayList;
// import java.util.PriorityQueue;





// // // Error_______________________________________________________________________________









// public class MSTPrismAlgo {

//     static class edge {
//         int src;
//         int dest;
//         int wt;

//         public edge(int src, int dest, int wt) {
//             this.src = src;
//             this.dest = dest;
//             this.wt = wt;

//         }
//     }

//     public static void createGraph(ArrayList<edge>[] graph) {
//         for (int i = 0; i < graph.length; i++) {
//             graph[i] = new ArrayList<>();
//         }

//         graph[0].add(new edge(0, 1, 10));
//         graph[0].add(new edge(0, 2, 15));
//         graph[0].add(new edge(0, 3, 30));

//         graph[1].add(new edge(1, 0, 10));
//         graph[1].add(new edge(1, 3, 0));

//         graph[2].add(new edge(2, 0, 15));
//         graph[2].add(new edge(2, 3, 50));

//         graph[3].add(new edge(3, 1, 40));
//         graph[3].add(new edge(3, 2, 50));

//     }

//     public class pair implements Comparable<pair> {
//         int node;
//         int cost;

//         public pair(int node, int cost) {
//             this.node = node;
//             this.cost = cost;
//         }

//         @Override

//         public int compareTo(pair p2) {
//             return this.cost - p2.cost;
//         }

//         public static void primsAlgo(ArrayList<edge>[] graph, int V) {
//             PriorityQueue<pair> pq = new PriorityQueue<>(); // NON -MST
//             boolean[] isVisited = new boolean[V]; // MST

//             pq.add(new pair(0, 0));

//             int cost = 0;

//             while (!pq.isEmpty()) {
//                 pair curr = pq.remove();

//                 if (!isVisited[curr.node]) {
//                     isVisited[curr.node] = true;
//                     cost += curr.cost;

//                     for (int i = 0; i < graph[curr.node].size(); i++) {
//                         edge e = graph[curr.node].get(i);

//                         if (!isVisited[e.dest]) {
//                             pq.add(new pair(e.dest, e.wt));
//                         }
//                     }
//                 }
//             }
//             System.out.println("MIN Cost" + cost);
    
//         }

//         public static void main(String[] args) {
//             int V = 4;
//             ArrayList<edge>[] graph = new ArrayList[V];
//             createGraph(graph);

//         }
//     }
// }
