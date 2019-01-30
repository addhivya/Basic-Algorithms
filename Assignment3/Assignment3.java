package Assignment3;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Assignment3 {

    public Node root;

    public void createTree() {
        this.root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        root.left.right.right.right.right = new Node(7);
        root.right.left = new Node(8);
        root.right.right = new Node(9);
        root.right.right.left = new Node(10);
    }

    public void bottomView() {
        System.out.println("**Bottom View of Tree**");
        TreeMap<Integer, Node> tm = new TreeMap<>();
        bView(root, 0, tm, 0);
        for (Integer key : tm.keySet()) {
            System.out.println("Key" + key + " Value" + tm.get(key).data);
        }
    }

    public void bView(Node node, int cursor, TreeMap<Integer, Node> tm, int level) {
        if (node == null)
            return;
        node.level = level;
        if (tm.containsKey(cursor)) {
            Node element = tm.get(cursor);
            if (element.level <= node.level)
                tm.put(cursor, node);  //If key value is already present and its level is lesser then it will replace
        } else
            tm.put(cursor, node);
        bView(node.left, cursor - 1, tm, level + 1);
        bView(node.right, cursor + 1, tm, level + 1);
    }


    public void topView() {
        System.out.println("**Top View of Tree**");
        TreeMap<Integer, Node> tm = new TreeMap<>();
        tView(root, 0, tm, 0);
        for (Integer key : tm.keySet()) {
            System.out.println("Key " + key + " Value " + tm.get(key).data);
        }
    }

    public void tView(Node node, int cursor, TreeMap<Integer, Node> tm, int level) {
        if (node == null)
            return;
        node.level = level;
        if (tm.containsKey(cursor)) {
            Node element = tm.get(cursor);
            if (element.level > node.level) {
                tm.put(cursor, node);  //Replacing data when level value is lesser for the element to be inserted
            }
        } else
            tm.put(cursor, node);

        tView(node.left, cursor - 1, tm, level + 1);
        tView(node.right, cursor + 1, tm, level + 1);
    }

    public void widthTree() {
        width(root);
    }

    public void width(Node node) {
        Queue<Node> q = new ConcurrentLinkedQueue<>();
        if (node == null)
            return;
        Node zero = new Node(0);
        q.add(root);
        q.add(zero);
        int width = 0;
        int maxwidth = 0;
        while (!q.isEmpty()) {
            node = q.element();
            if (node != zero) {
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                q.remove();
                width++;
            } else {
                q.remove();
                if (q.isEmpty()) {
                    System.out.println("Maximum Width of tree: " + maxwidth);
                    break;
                }
                q.add(zero);
                if (width > maxwidth)
                    maxwidth = width;
                width = 0;
            }
        }
    }

    public static void main(String[] args) {
        Assignment3 trees = new Assignment3();
        trees.createTree();
        trees.bottomView();
        trees.topView();
        trees.widthTree();
    }
}
