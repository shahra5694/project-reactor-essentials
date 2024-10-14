public class ReverseSinglyLinkedList {

    public static void main(String ar []) {
        NodeT root = new NodeT(1);
        root.next = new NodeT(2);
        root.next.next = new NodeT(3);
        root.next.next.next = new NodeT(4);
        root.next.next.next.next = new NodeT(5);

        printList(root);
        printList(reversNode(root));
    }

    static void printList(NodeT node)
    {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

   static NodeT reversNode (NodeT root) {
        NodeT current = root;
        NodeT prev = null;
        NodeT next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        root = prev;
        return root;
    }
}

 class NodeT {
    int val;
    NodeT next;
    public NodeT(int val) {
        this.val = val;
    }
}
