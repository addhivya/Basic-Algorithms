package Assignment4;

import java.util.ArrayList;

public class BinaryTree {

    Node root;
    int maxlevel = -1;

    public void createTree() {
        Node node = new Node(1);

        node.left = new Node(2);
        node.right = new Node(3);

        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        node.left.left.left = new Node(8);
        node.left.left.right = new Node(9);
        node.left.right.left = new Node(10);
        node.left.right.right = new Node(11);
        node.right.left.left = new Node(12);
        node.right.left.right = new Node(13);
        node.right.right.left = new Node(14);
        node.right.right.right = new Node(15);

        root = node;
    }

    public void fullNode() {
        ArrayList<Integer> list = new ArrayList<>();
        fullNodes(list, root);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public ArrayList<Integer> fullNodes(ArrayList<Integer> list, Node node) {
        if (node == null) {
            return list;
        }
        if (node.left != null && node.right != null) {
            list.add(node.data);
        }
        fullNodes(list, node.left);
        fullNodes(list, node.right);
        return list;
    }

    public void middleLevel() {
        ArrayList<Integer> list = new ArrayList<>();
        mid(root, root, list);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public void mid(Node node1, Node node2, ArrayList list) {
        if (node2 == null || node2.left == null || node2.right == null) {
            if (node1 != null) {
                list.add(node1.data);
            }
            return;
        }
        mid(node1.right, node2.left.left, list);
        mid(node1.left, node2.left.left, list);
    }

    public boolean leaflevel1() {
        boolean res = leaflevel(root, 0);
        return res;
    }

    public boolean leaflevel(Node node, int level) {
        if (node == null)
            return false;
        if (node.left == null && node.right == null) {
            {
                if (maxlevel == -1) {
                    maxlevel = level;
                    return true;
                } else if (maxlevel == level) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return leaflevel(node.left, level + 1) && leaflevel(node.right, level + 1);
    }

    public static void main(String[] args) {
        BinaryTree btree = new BinaryTree();
        btree.createTree();
        System.out.println("Full Nodes in Binary Tree");
        btree.fullNode();
        System.out.println("Middle Level of perfect tree");
        btree.middleLevel();
        System.out.println("All leaf nodes at same level?");
        boolean Status = btree.leaflevel1();
        System.out.println(Status);
    }
}
