package MidTerm;

public class Merge {

    Node node1;
    Node node2;

    public void createTree() {
        node1 = new Node(1);
        node1.left = new Node(3);
        node1.right = new Node(2);
        node1.left.left = new Node(5);

        node2 = new Node(2);
        node2.left = new Node(1);
        node2.right = new Node(3);
        node2.left.right = new Node(4);
        node2.right.right = new Node(7);
    }

    public void merge1() {
        merge(node1, node2);
        System.out.println("Merging 2 given tree: ");
        preOrder(node2);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public Node merge(Node node1, Node node2) {
        if (node1 == null && node2 != null) {
            return node2;
        }
        if (node1 != null && node2 == null) {
            return node1;
        }
        if (node1 == null && node2 == null) {
            return null;
        }
        merge(node1.left, node2.left);
        if (node2.left == null) {
            node2.left = node1.left;
        }
        merge(node1.right, node2.right);
        if (node2.right == null) {
            node2.right = node1.right;
        }
        if (node1 != null && node2 != null) {
            node2.data = node1.data + node2.data;
        }
        return node2;
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        merge.createTree();
        merge.merge1();
    }
}
