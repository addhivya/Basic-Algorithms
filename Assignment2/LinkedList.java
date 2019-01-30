package Assignment2;

public class LinkedList {
    Node head=null;

    public void addNode(Node node) {

        if(head==null) {
            head=node;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=node;
    }

    public void print()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp=temp.next;

        }
    }

    public int length()
    {
        int length=0;
        Node temp=head;
        while(temp!=null)
        {
            temp=temp.next;
            length=length+1;

        }  return length;
    }

    public Node getNNode(int n)
    {
        Node temp=head;
        int i=1;
        while(i<n && temp!=null)
        {
            temp=temp.next;
            i++;
        }
        return temp;
    }
}
