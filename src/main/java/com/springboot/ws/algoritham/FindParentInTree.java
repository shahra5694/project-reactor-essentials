package com.springboot.ws.algoritham;

public class FindParentInTree {

//    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        int node = 3;
//
//        findParent(root, node, -1);
//    }

    // Recursive function to find the parent of the given root
    static void findParent(Node node, int val, int parent) {
        if (node == null)
            return;
        // If current root is the required root
        if (node.data == val) {
            // Print its parent
            System.out.print(parent);
        } else {

            // Recursive calls for the children of the current root is now the new parent
            findParent(node.left, val, node.data);
            findParent(node.right, val, node.data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(8);
        int node = 3;

//        findParent(root, node, -1);
        Node parent = getParent(root,8);
        if(parent != null) {
            System.out.println(parent.data);
        } else {
            System.out.println("Parent is null");
        }
    }

    static Node getParent(Node node, int key) {
        if (node == null || node.data == key)
            return null;
        if ((node.left != null && node.left.data == key) || (node.right != null && node.right.data == key)) {
            return node;
        }

        Node l = getParent(node.left,key);
        if(l != null)
            return l;

       return getParent(node.right,key);
    }


    /* A binary tree node has data, pointer to left child and a pointer to right child */
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
