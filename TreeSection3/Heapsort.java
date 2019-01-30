package TreeSection3;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Heapsort {


    public void createTree()
    {
        Node node=new Node(5);

        node.left=new Node(10);
        node.right=new Node(50);

        node.left.left=new Node(11);
        node.left.right=new Node(20);
        node.right.left=new Node(52);
        node.right.right=new Node(55);

        node.left.left.left=new Node(25);
        node.left.left.right=new Node(22);

        Node root=node;

    }

    public void minHeapAdd(Node node)
    {
        Queue q=new ConcurrentLinkedQueue();
        if(node==null)
            return;
        q.add(node);
        while(!q.isEmpty())
        {
           //node=q.element();

        }
    }
}
