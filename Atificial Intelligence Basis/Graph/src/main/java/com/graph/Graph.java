package main.java.com.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/**
 * Graph
 */
public class Graph {
    int V;
    LinkedList<Integer>[] adj;

    Graph(int V) {
        this.V = V;
        adj = new LinkedList[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void print() {
        for (int i = 0; i < adj.length; i++) {
            System.out.println("\nAdjacency list of vertex:" + i);
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.println(adj[i].get(j));
            }
        }
    }

    void DFSUtil(int s, Vector<Boolean> visited) {
        Stack<Integer> stack = new Stack<>();

        stack.push(s);

        while (!stack.empty()) {

            s = stack.peek();
            stack.pop();

            if (!visited.get(s)) {
                visited.set(s, true);
                System.out.println(s);
            }

            Iterator<Integer> itr = adj[s].iterator();
            while (itr.hasNext()) {
                int v = itr.next();
                if (!visited.get(v))
                    stack.push(v);
            }
        }
    }

    void DFS() {
        Vector<Boolean> visited = new Vector<Boolean>(V);

        for (int i = 0; i < V; i++)
            visited.add(false);

        for (int i = 0; i < V; i++) {
            if (!visited.get(i))
                DFSUtil(i, visited);
        }
    }

    void BFS(int s) {
        boolean[] visited = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(s);
        visited[s] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println(v);

            Iterator<Integer> itr = adj[v].iterator();
            while (itr.hasNext()) {
                int i = itr.next();
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        g.BFS(2);
        g.print();
    }
}
