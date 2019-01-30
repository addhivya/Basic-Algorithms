package Assignment5;

public class BST {
    Node root;

    class counter {
        int i;
        counter(int i) {
            this.i = i;
        }
    }

    public void createTree() {
        Node node = new Node(8);
        node.left = new Node(4);
        node.right = new Node(10);

        node.left.left = new Node(2);
        node.left.right=new Node(6);
        node.left.right.left=new Node(5);
        root = node;
    }

    public void findKElement() {
        int total = inorder(root);
        Node result = findKSmallest(root, 3, new counter(0), total);
        System.out.println("Smallest: " + result.data);
        Node result1 = findKLargest(root, 3, new counter(0), total);
        System.out.println("Largest: " + result1.data);
    }

    public Node findKSmallest(Node node, int k, counter count, int total) {
        if (total < k) {
            Node empty = new Node(-1);
            return empty;
        }
        if (node == null) {
            return null;
        }
        Node leftReturn = findKSmallest(node.left, k, count, total);
        if (leftReturn != null) return leftReturn;
        count.i = count.i + 1;
        if (count.i == k) {
            return node;
        }
        Node rightReturn = findKSmallest(node.right, k, count, total);
        return rightReturn;
    }


    public Node findKLargest(Node node, int k, counter count, int total) {

        if (total < k) {
            Node empty = new Node(-1);
            return empty;
        }
        if (node == null) {
            return null;
        }
        Node rightReturn = findKLargest(node.right, k, count, total);
        if (rightReturn != null) return rightReturn;
        count.i = count.i + 1;
        if (count.i == k) {
            return node;
        }
        Node leftReturn = findKLargest(node.left, k, count, total);
        return leftReturn;
    }

    public void range() {
        System.out.println("Range");
        range(4, 10, root);

    }

    public void range(int start, int end, Node node) {
        if (node == null)
            return;
        if (node.data == start || node.data == end) {
            System.out.println(node.data);
        }
        if (node.data > start) {
            range(start, end, node.left);
            if (node.data > start && node.data < end)
                System.out.println(node.data);
            range(start, end, node.right);
        } else {
            range(start, end, node.right);
            if (node.data > start && node.data < end)
                System.out.println(node.data);
            range(start, end, node.left);
        }
    }

    public void ceiling() {
        int res = ceiling(root, 5);
        System.out.println("Ceiling: " + res);
    }

    public int ceiling(Node node, int element) {
        int res = -1;
        Node parent;

        if (node == null)
            return 0;
        if (element == node.data) {
            return res = element;
        }
        if (node.data > element) {
            parent = node;
            res = ceiling(node.left, element);
            if (res == 0) {
                res = parent.data;
            }
        } else if (node.data < element) {
            res = ceiling(node.right, element);
            if ((res == 0) && (root.data < element)) {
                System.out.println("No ceiling for the element exists");
                return -1;
            } else
                return res;
        }
        return res;
    }

    public int inorder(Node node) {
        if (node == null)
            return 0;
        int total = 1 + inorder(node.left) + inorder(node.right);
        return total;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.createTree();
        tree.findKElement();
        tree.range();
        tree.ceiling();
    }
}
