package practise;

import java.util.LinkedList;
import java.util.Queue;

public class TestBinary {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right= new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(calculateHeight(root.right.right));

    }

    static int calculateHeight(Node root) {
        if(root == null)
            return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        // initialize a variable to count the height of tree.
        int height = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
               Node temp = queue.poll();
               if(temp.left != null)
                   queue.add(temp.left);
               if (temp.right != null) {
                   queue.add(temp.right);
               }
            }
            height++;
        }
        return height;
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data=data;
        left = right = null;
    }
}
