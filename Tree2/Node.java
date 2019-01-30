package Tree2;

public class Node {

    Node node;
    Node left;
    Node right;
    Node parent;
    int data;
    public Node(int data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
        this.parent=null;

    }
}
