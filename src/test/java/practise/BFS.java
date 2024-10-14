package practise;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.add(0, 1);
        g.add(0, 2);
        g.add(1, 0);
        g.add(1, 2);
        g.add(2, 1);
        g.add(2, 3);
        g.add(3, 2);
        g.add(3, 4);
        g.add(4, 3);

        g.traversBFS(0, 4);
    }
}

class Graph {
    private int vertices;
    private LinkedList<Integer> graphNode[];


    public Graph(int vertices) {
        this.vertices = vertices;
        graphNode = new LinkedList[vertices];

        for (int i = 0; i < vertices; i++) {
            graphNode[i] = new LinkedList<>();
        }
    }

    public void add(int v, int w) {
        graphNode[v].add(w);
    }

    public boolean traversBFS(int root, int dest) {
        boolean visited[] = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[root] = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            System.out.println(cur + " ");
            Iterator<Integer> iterator = graphNode[cur].listIterator();

            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;

                    if (next == dest)
                        return true;
                }
            }

        }
        return false;
    }
}
