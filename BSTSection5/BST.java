package BSTSection5;


import java.util.Arrays;

public class BST {

    Node root;

    class element {
        int i;
        element(int i) {
            this.i = i;
        }
    }

    public void createTree() {
        Node node = new Node(8);
        node.left = new Node(3);
        node.right = new Node(10);

        node.left.left = new Node(1);
        node.left.right = new Node(6);
        root = node;
    }

    public void inOrder() {
        inOrderTraversal(root);
    }

    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.data);
        inOrderTraversal(node.right);
    }

    public void smallestNode() {
        smallest(root);
    }

    public void smallest(Node node) {
        if (node == null)
            return;
        while (node.left != null) {
            node = node.left;
        }
        System.out.println(node.data);
    }

    public void CreatebinaryTree() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);
        root = node;
    }

    public void createBST() {
        CreatebinaryTree();
        int[] a = new int[5];
        preorder(root, a, new element(0));
        Arrays.sort(a);
        Node result = formBST(a, 0, a.length - 1);
        System.out.println(result);

    }

    public void preorder(Node node, int[] a, element arr) {
        if (node == null)
            return;
        a[arr.i] = node.data;
        arr.i++;
        preorder(node.left, a, arr);
        preorder(node.right, a, arr);
    }

    public Node formBST(int a[], int start, int end) {
        if (start < 0 || start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(a[mid]);
        node.left = formBST(a, start, mid - 1);
        node.right = formBST(a, mid + 1, end);
        return node;
    }

    public void insertElement()
    {
        insert(9, root);
    }

    public void insert(int element, Node node) {
        Node parent = null;
        Node child = node;
        if (node == null) {
            root = new Node(element);
        }
        while (child != null) {
            parent = child;
            if (child.data < element) {
                child = parent.right;
            } else
                child = parent.left;
        }

        if (parent.data < element) {
            parent.right = new Node(element);
        } else
            parent.left = new Node(element);
    }

    public void searchelement() {
        int result = search(root, 0);
        System.out.println(result);
    }

    public int search(Node node, int element) {
        if (node == null)
            return -1;
        if (node.data == element) {
            return 1;
        }

        if (node.data < element) {
            return search(node.right, element);
        } else
            return search(node.left, element);

    }

    public static void main(String args[]) {
        BST tree = new BST();
      /* tree.createTree();
        tree.inOrder();*/
        //  tree.smallestNode();
        tree.createBST();
      /*  tree.insertElement();
        tree.inOrder();*/
        //   tree.searchelement();

    }


}
