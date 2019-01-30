package MidTerm;

public class CLLDelete {
    Node node;
    Node first;
    Node tail;
    Node before;

    Boolean visited=false;
    Boolean Iterate=true;


    public void cLinkedList() {
        node = new Node(5);
        node.right = new Node(7);
        node.right.right = new Node(1);
        node.right.right.right = node;
        first = node;
        delete(7, node);
    }


    public void delete(int data, Node node) {
        if (node == null) {
            return;
        }

        while(node.right!=first && Iterate==true)
        {
            node=node.right;
        }
        if(node.right==first && Iterate==true)
        { before=node;
        tail=node;
        node=node.right;
        Iterate=false;
        }

        if (node.data == data) {
            Node next = node.right;
            before.right = next;
            System.out.println("Deleted node: " + node.data);
            visited=true;
            delete(data, node.right);
        } else {
            if (first.equals(node.right)) {
                if(!visited) {
                    System.out.println("Data doesn't exist!!");
                }
                return;
            }
            if(node==tail)
            {
                return;
            }
            before = node;
            delete(data, node.right);
        }
        return;
    }

    public static void main(String[] args) {
        CLLDelete ll = new CLLDelete();
        ll.cLinkedList();
    }
}
