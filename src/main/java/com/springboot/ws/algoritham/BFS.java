package com.springboot.ws.algoritham;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        g.traversGraph(0);
    }
}

class Graph {
    private int verticesCount;

    private LinkedList<Integer> graphNode[];

    public Graph(int verticesCount) {
        this.verticesCount=verticesCount;
        graphNode = new LinkedList[verticesCount];

        for (int i=0;i<verticesCount;i++) {
            graphNode[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        graphNode[v].add(w);
    }

    public void traversGraph(int rootNode) {
        // Mark all the vertices as not visited(By default set as false)
        boolean visited [] = new boolean[this.verticesCount];

        // Create a queue for BFS

        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[rootNode] = true;
        queue.add(rootNode);

        while (queue.size() != 0) {

            // Dequeue a vertex from queue and print it
            rootNode = queue.poll();
            System.out.println(rootNode+" ");

            // Get all adjacent vertices of the dequeued vertex rootNode If an adjacent has not been visited,
            // then mark it visited and enqueue it

            Iterator<Integer> iterator = graphNode[rootNode].listIterator();
            while (iterator.hasNext()) {
               int n = iterator.next();
               if(!visited[n]) {
                   visited[n] = true;
                   queue.add(n);
               }
            }
        }
    }

}
