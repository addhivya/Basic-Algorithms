package Assignment2;

public class AddSort extends LinkedList {

    public void addNode(int data) {
        Node newNode=new Node(data);
        if(head==null) {
            head=newNode;
            return;
        }
        if(head.data>data)
        {
            Node temp=head;
            temp.back=newNode;
            newNode.next=temp;
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            if(temp.data<data)
            {
                temp = temp.next;
            }
            else
            {
                Node temp1=temp.back;
                newNode.next=temp;
                temp1.next=newNode;
                newNode.back=temp1;
                temp.back= newNode;
                return;
            }
        }
        temp.next=newNode;
        newNode.back=temp;
    }


    public static void main(String[] args)
    {
        AddSort a=new AddSort();
        a.addNode(2);
        a.addNode(4);
        a.addNode(6);
        a.addNode(8);
        System.out.println("Before Insertion");
        a.print();
        int n=7;
        System.out.println("Number to be inserted :" +n);
        a.addNode(n);
        System.out.println("After Insertion");
        a.print();

    }
}
