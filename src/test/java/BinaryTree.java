import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
//    Node root;
//
//    /* Compute the "maxDepth" of a tree -- the number of
//       nodes along the longest path from the root node
//       down to the farthest leaf node.*/
//    int maxDepth(Node node) {
//        if (node == null)
//            return 0;
//        else {
//            /* compute the depth of each subtree */
//            int lDepth = maxDepth(node.left);
//            int rDepth = maxDepth(node.right);
//
//            /* use the larger one */
//            if (lDepth > rDepth)
//                return (lDepth + 1);
//            else
//                return (rDepth + 1);
//        }
//    }

    int height(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        // Initialising a variable to count the height of tree
        int height = 0;

        while (!q.isEmpty()) {
           int size = q.size();
           for(int i=0;i<size;i++) {
               Node temp =  q.poll();
               if(temp.left != null)
                   q.add(temp.left);
               if(temp.right != null)
                   q.add(temp.right);
           }
            height++;
        }
        return height;
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
//        tree.root.left.right = new Node(5);
//        tree.root.left.right.left = new Node(6);

//        System.out.println("Height of tree is " + tree.maxDepth(tree.root));
        System.out.println("Height of tree is " + tree.height(root));

    }
}
    // A binary tree node
    class Node {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
}
