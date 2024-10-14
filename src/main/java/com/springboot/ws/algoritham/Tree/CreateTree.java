package com.springboot.ws.algoritham.Tree;

import java.util.*;

public class CreateTree {

    static Scanner sc = null;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        Node node = createNode();
//        System.out.println(node);
        inOrder(node);
        System.out.println();
        preOrder(node);
        System.out.println();
        postOrder(node);
        System.out.println();
//        calculate height of tree
        System.out.println("height = " + height(node));
        System.out.println("Maximum node = " + maxNode(node));
        System.out.println("size or node count = " + sizeOfTree(node));
        levelOrderTraversal(node);
        printLeftView(node);
        printAncestors(node, 6);
        kthAncestor(node,5,2);
    }

    static Node createNode() {
        Node root;
        System.out.println("enter data");
        int data = sc.nextInt();
        if (data == -1)
            return null;

        root = new Node(data);
        System.out.println("enter left data for " + data);
        root.left = createNode();

        System.out.println("enter right data for " + data);
        root.right = createNode();

        return root;
    }

    static void inOrder(Node node) {
        if (node == null) return;
        // follow Left, Node, Right strategy

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    static void preOrder(Node node) {
        if (node == null) return;
        // follow Node, Left, Right strategy
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        // follow Left, Right , Node strategy

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    static int height(Node node) {
        if (node == null)
            return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    static int sizeOfTree(Node node) {
        if (node == null)
            return 0;
        return sizeOfTree(node.left) + sizeOfTree(node.right) + 1;
    }

    static int maxNode(Node node) {
        if (node == null)
            return Integer.MIN_VALUE;
        return Math.max(node.data, Math.max(maxNode(node.left), maxNode(node.right)));
    }

    static void printLeftView(Node root) {
        List<Node> list = new ArrayList<>();
        printLeftViewUtil(root, list, 0);
        list.forEach(n -> System.out.print(n.data + " "));
    }

    static void printLeftViewUtil(Node root, List<Node> list, int level) {
        if (root == null)
            return;
        if (list.get(level) == null) {
            list.set(level, root);
        }
        printLeftViewUtil(root.left, list, level++);
        printLeftViewUtil(root.right, list, level++);
    }

    static void printRightView(Node root) {
        List<Node> list = new ArrayList<>();
        printRightViewUtil(root, list, 0);
        list.forEach(n -> System.out.print(n.data + " "));
    }

    static void printRightViewUtil(Node root, List<Node> list, int level) {
        if (root == null)
            return;
        list.set(level, root);
        printLeftViewUtil(root.left, list, level++);
        printLeftViewUtil(root.right, list, level++);
    }

//    another way

//    static void printRightViewUtil(Node root, List<Node> list, int level) {
//        if (root == null)
//            return;
//         if (list.get(level) == null) {
//            list.set(level, root);
//        }
//        printLeftViewUtil(root.right, list, level++);
//        printLeftViewUtil(root.left, list, level++);
//    }

    static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    static boolean printAncestors(Node node, int target) {
        if (node == null)
            return false;
        if (node.data == target)
            return true;

        if (printAncestors(node.left, target) || printAncestors(node.right, target)) {
            System.out.println(node.data + " ");
            return true;
        }
        return false;
    }

    static Node kthAncestor(Node root, int target, int kth) {
        List<Node> list = new ArrayList<>();
        if (findPath(root, target, list)) {
            return list.get(list.size() - 1 - kth);
        }
        return null;
    }

    static boolean findPath(Node root, int target, List<Node> path) {
        if (root == null)
            return false;

        path.add(root);
        if (root.data == target)
            return true;
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
