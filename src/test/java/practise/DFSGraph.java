package practise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class DFS {
    public static void main(String[] args) {
        DFSGraph g = new DFSGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.traverseNode(0);
    }
}

public class DFSGraph {
    private int vertices;
    private LinkedList<Integer> graphNode[];

    public DFSGraph(int v) {
        vertices = v;
        graphNode = new LinkedList[v];

        for (int i=0;i<v;i++) {
            graphNode[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w) {
        graphNode[v].add(w);
    }

    public void traverseNode(int v) {
        List<Integer> answer = new ArrayList<>();
        boolean[] visited = new boolean[vertices];
        traverse(v,visited,answer);
        System.out.println(answer);
    }

    private void traverse(int v,boolean visited[], List<Integer> ans) {
        visited[v] = true;
        ans.add(v);

        for(Integer i : graphNode[v]) {
            if(!visited[i]) {
                traverse(i,visited,ans);
            }
        }
    }
}