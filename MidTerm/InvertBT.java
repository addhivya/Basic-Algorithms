package MidTerm;

public class InvertBT {

    Node root;

    public void createTree()
    {
        Node node=new Node(4);
        node.left=new Node(2);
        node.right=new Node(7);

        node.left.left=new Node(1);
        node.left.right=new Node(3);
        node.right.left=new Node(6);
        node.right.right=new Node(9);
        root=node;
    }
    public void mirror1()
    {
        mirror(root);
        preOrder(root);

    }
    public Node mirror(Node node)
    {
        if(node==null)
        {
            return null;
        }
        Node left=mirror(node.left);
        Node right=mirror(node.right);
        Node temp=left;
        left=right;
        right=temp;
        node.left=left;
        node.right=right;
        return node;
    }
    public void preOrder1()
    {
       preOrder(root);
        System.out.println();
    }

    public void preOrder(Node node)
    {
        if(node==null)
        {
            return;
        }
        System.out.print(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        InvertBT invert=new InvertBT();
        invert.createTree();
        System.out.println("Preorder of given tree:");
        invert.preOrder1();
        System.out.println("Invert : ");
        invert.mirror1();
    }
}

