package TreeSection3;

import java.util.*;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;

public class BinaryTree {
    public Node root;


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
        node.left.right.right = new Node(10);
       node.right.right.right = new Node(11);


       /* node.right.left.left = new Node(12);
        node.right.left.right = new Node(13);*/

        root = node;
    }

    public void preOrder() {
        System.out.println("PreOrder traversal");
        preOrder(root);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println("" + node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        System.out.println("InOrder traversal");
        inOrder(root);
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println("" + node.data);
        inOrder(node.right);
    }

    public void postOrder() {
        System.out.println("PostOrder traversal");
        inOrder(root);
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println("" + node.data);
    }

    public void size() {
        int count = size(root);
        System.out.println("Total nodes: " + count);
    }

    public int size(Node node) {
        if (node == null) {
            return 0;
        } else {
            int count = 1 + size(node.left) + size(node.right);
            return count;
        }
    }

    public void level() {

        level(root);
    }


    public void level(Node node) {
        Queue<Node> q = new ConcurrentLinkedQueue<Node>();
        Node empty = new Node(0);

        q.add(root);
        q.add(empty);

        while (q.isEmpty() == false) {
            if (q.element() == empty) {
                System.out.println("\n");
                q.remove();
                if (q.isEmpty() == true)
                    break;
                q.add(empty);
                node = q.element();
            }
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
            System.out.print(node.data);
            System.out.print(" ");
            q.remove();
            node = q.element();
        }
    }

    public void zigzag() {
        //zigzag(root);
        levelOrder(root);
    }

    public void zigzag(Node node) {
        Stack<Node> s = new Stack<Node>();
        Queue<Node> q = new ConcurrentLinkedQueue<Node>();

        Boolean flip = false;
        Node newLine = new Node(0);
        q.add(node);
        q.add(newLine);

        while (q != null) {
            node = q.element();

            if (node == newLine) {
                q.add(newLine);
                q.remove();
                node = q.element();
                flip = !flip;
                while (!s.empty()) {
                    System.out.print(s.pop().data);
                }
                System.out.println();
            }
            if (node.left != null)
                q.add(node.left);
            if (node.right != null)
                q.add(node.right);
            if (flip == true) {
                s.push(node);
                q.remove();
            } else {
                q.remove();
                if (q.isEmpty() == true)
                    break;
                System.out.print(node.data);
            }

        }
    }


    public void levelOrder(Node node) {
        List<List<Node>> levelList = new ArrayList<>();
        levelOrder(node, 0, levelList);
        for (int i = 0; i < levelList.size(); i++) {
            List<Node> currentList = levelList.get(i);
            for (Node currentNode : currentList) {
                System.out.print(currentNode.data + " ");
            }
            System.out.println();
        }
    }

    private void levelOrder(Node node, int level, List<List<Node>> levelList) {
        if (node == null) {
            return;
        }
        node.level = level;
        if (levelList.size() < (level + 1)) {
            levelList.add(new ArrayList<>());
        }
        List<Node> currentLevelList = levelList.get(level);
        currentLevelList.add(node);
        levelOrder(node.left, level + 1, levelList);
        levelOrder(node.right, level + 1, levelList);
    }

    public void height() {
        int height = height(root);
        System.out.println(height);
    }

    public int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public void leftNodes()
    {
        leftNodes(root);
    }
    public void leftNodes(Node node)
    {
        if(node==null)
            return;
        System.out.println(node.data);
        leftNodes(node.left);
    }
    public void rightNodes()
    {
        rightNodes(root);
    }

    public void rightNodes(Node node)
    {
        if(node==null)
            return;
        System.out.println(node.data);
        rightNodes(node.right);

    }

    public void childNodes()
    {
        childNodes(root);
    }
    public void childNodes(Node node)
    {
        if(node==null)
            return;
        childNodes(node.left);
        childNodes(node.right);
        if(node.left ==null && node.right == null)
        {
            System.out.println(node.data);
        }

    }

    public void pleftNodes(Node node)
    {
      if(node.left==null)
          return;
      System.out.println(node.data);
      pleftNodes(node.left);

    }

    public void prightNodes(Node node)
    {
        if(node.right==null)
            return;

        prightNodes(node.right);
        if(node!=root)
        {
        System.out.println(node.data);}
    }

    public void innerRightNodes(Node node)
    {
        if(node==null)
            return;
       innerRightNodes(node.right);
       if(node.right==null && node.left!=null)
       {
           innerRightNodes(node.left);
       }
        if(node.right==null && node.left==null || node==root)
        {
            return;
        }
        System.out.println(node.data);
    }


    public void leftView(Node node)
    {
        if(node==null)
        {
            return;
        }
        Queue<Node> q=new ConcurrentLinkedQueue<Node>();
        Node n=new Node(0);
        q.add(root);
        q.add(n);
        boolean print=true;
        while(q!=null)
        {
            node = q.element();
            if(node!=n)
            {if(node.left!=null){
                q.add(node.left);}
                if(node.right!=null){
                q.add(node.right);}
                if(print) {
                    System.out.println(node.data);
                    print=false;
                }
                q.remove();
            }
            else
            {   q.add(n);
                q.remove();
                print=true;

            }
        }
    }

    public void rightView(Node node)
    {
        if(node==null)
            return;
        Queue<Node> q= new ConcurrentLinkedQueue<Node>();
        Node n=new Node(0);
        q.add(root);
        q.add(n);
        //boolean print=true;
        while(q!=null)
        {
            node=q.element();
            if(node!=n) {
                if(node.left!=null)
                {q.add(node.left);}
                if(node.right!=null)
                {
                q.add(node.right);}
                q.remove();
                if (q.element() == n) {
                    System.out.println(node.data);
                }
            }else
            {   q.remove();
                q.add(n);
            }
        }
    }

    public void bottomView() {
        Hashtable<Integer,Integer> h = new Hashtable<Integer,Integer>();
        TreeMap tm=new TreeMap();

        bottomView1(root, 0, tm);
        Set s=tm.entrySet();
        Iterator i=s.iterator();


        while (i.hasNext()) {
             Map.Entry key = (Map.Entry) i.next();
            System.out.println("Key: " + key + " & Value: " +
                    tm.get(key));


           /* Enumeration key = h.keys();
            while (key.hasMoreElements()) {
                int key1 = (int) key.nextElement();
                System.out.println("Key: " + key1 + " & Value: " +
                        h.get(key1));*/

        }
    }




    public void bottomView1(Node node,int cursor,TreeMap tm)
    {
        if(node==null)
            return;
        if(tm.containsKey(cursor))
        {
            tm.replace(cursor,node.data);

        }
        else
            tm.put(cursor,node.data);

        bottomView1(node.left,cursor-1,tm);
        bottomView1(node.right,cursor+1,tm);
       
    }

    public void topView() {
        Hashtable h = new Hashtable();
        topView1(root, 0, h);
        Enumeration key = h.keys();
        while (key.hasMoreElements()) {
            int key1 = (int) key.nextElement();
            System.out.println("Key: " + key1 + " & Value: " +
                    h.get(key1));

        }
    }

        public void topView1 (Node node,int cursor, Hashtable h)
        {
            if (node == null)
                return;
            topView1(node.left, cursor - 1, h);
            topView1(node.right, cursor + 1, h);

            if (h.containsKey(cursor)) {
                h.replace(cursor, node.data);
            } else
                h.put(cursor, node.data);

        }

        public void width(Node node)
        {


        }


    public void perimeter()
    {
       // pleftNodes(root);
       // childNodes();
       // prightNodes(root);
     //   innerRightNodes(root);
        //rightView(root);
      //  bottomView();
        topView();

    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createTree();
        //  bt.preOrder();
        // bt.inOrder();
        // bt.size();
        //bt.level();
        //bt.zigzag();
        //bt.height();
       // bt.leftNodes();
        //bt.childNodes();
       // bt.rightNodes();
        bt.perimeter();


    }
}

