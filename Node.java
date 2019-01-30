public class Node {
    public int data;
    public Node ptr;

    public Node(int data)
    {
      this.data=data;
      this.ptr=null;
    }
    public Node next()
    {
        return this.ptr;
    }
    public Node add(Node node)
    {
     return this.ptr=node;
    }
    public Node delete(Node node)
    {
        this.ptr=node.next();
        return node.ptr=null;
    }


}
