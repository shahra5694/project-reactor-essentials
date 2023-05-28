package algoritham;

import java.util.LinkedList;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        DFSGraph g = new DFSGraph(6);

//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 0);
//        g.addEdge(1, 3);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 4);
//        g.addEdge(3, 5);
//        g.addEdge(4, 3);
//        g.addEdge(5, 3);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is the Depth First Traversal");
        System.out.println("using recursion");
        g.dfs(0);
        System.out.println("\nusing stack");
        g.stackTravers(0);
    }
}

class DFSGraph {

    private int edges;                          //number of nodes
    private LinkedList<Integer> [] adj;        //adjacency list

    public DFSGraph(int edges) {
        this.edges=edges;
        adj = new LinkedList[edges];
        for(int i=0;i<edges;i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int i,int j) {
        adj[i].add(j);
    }

    void stackTravers(int start) {
        boolean visited[] = new boolean[edges];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);                                    //push root node to the stack

        while (!stack.empty()) {
            int currentNode = stack.pop();                       //extract the top element of the stack

            if (!visited[currentNode]) {
                System.out.print(currentNode + " ");
                visited[currentNode] = true;
            }
            for (int i = 0; i < adj[currentNode].size(); i++) {  //iterate through the linked list and then propagate to the next few nodes
                int a = adj[currentNode].get(i);
                if (!visited[a]) {                                  //only push those nodes to the stack which aren't in it already
                    stack.push(a);                                   //push the top element to the stack
                }
            }
        }
    }

    void dfsRecursive(int vertex, boolean visited[]) {
        visited[vertex] = true;                         //mark the node as explored
        System.out.print(vertex + " ");

        for (int i = 0; i < adj[vertex].size(); i++) { //iterate through the linked list and then propagate to the next few nodes
            int a = adj[vertex].get(i);
            if (!visited[a])  {                  //only propagate to next nodes which haven't been explored
                dfsRecursive(a, visited);
            }
        }
    }

    void dfs(int v) {
        boolean visited[] = new boolean[this.edges];             //initialize a new boolean array to store the details of explored nodes
        dfsRecursive(v, visited);
    }

}
