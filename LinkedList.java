public class LinkedList {
    public Node head;
    public Node node;
    public LinkedList()
    {
        head=null;
    }

    public Node addNode(int data)
    {
        Node newNode=new Node(data);
        if(head==null)
        { head=newNode;
        return head;
        }else
        {
            Node temp=head;
            while(temp.next()!=null)
            {
                temp=temp.next();
            }
             return temp.add(newNode);

        }
    }

    public boolean deleteNode(int data)
    { Node back=null;
      Node temp=head;

            if(temp!=null && temp.data==data)
            {
                head=temp.next();
                temp.ptr=null;
                return true;
            }
            while ((temp.data != data) && (temp != null))
            {
                   back=temp;
                   temp = temp.next();

            }
            if(temp==null)
            {
                return false;
            }
            if (temp.data == data)
            {
                    back.delete(temp);
            }
            return true;
        }

        public Node reverse(Node node)
    {
        System.out.println("Reverse");
        Node prev=null;
        if(head==null) {
            return node;
        }
        Node temp=null;
       Node first=node;
        while(first!=null)
        {
            temp=first;
            first=first.next();
           temp.ptr=prev;
            prev=temp;

        }
       head=temp;
        return head;
    }

    public int findn(int n){

        Node temp=head;Node front=head;

        int i=1;
        while(i<n && front!=null)
        {
            front=front.next();
            i++;
        }
        while(front.next()!=null)
        {
            temp=temp.next();
            front=front.next();
        }
        if(front==null)
        {
            return -1;
        }
        return temp.data;

    }

    public Node middle()
    {
        Node temp=head;
        Node front=head;
        if(head==null)
        {
            return head;
        }
        int i=0;
        while(i<2 && front.next()!=null)
        {
            front=front.next();
            i++;
        }
        while(front!=null && front.next()!=null)
        {
            front=front.next();
            front=front.next();
            temp=temp.next();
        }
        return temp;
    }

    public int midReverse()
    {
        Node temp=head;
        Node front=head;
        if(head==null)
        {
            return -1;
        }
        while(front!=null && front.next()!=null)
        {
            front=front.next();
            front=front.next();
            temp=temp.next();
        }
        Node mid=temp;
        Node p=mid.next();
        Node f=p.next();
        Node c=null;

        while(f!=null)
        {
            p.ptr=null;
            p.ptr=c;
            c=p;
            p=f;
            f=f.next();

        }
        p.ptr=c;
        mid.ptr=p;
return 1;
    }

    public void palindrome()
    {
        Node firstpart=head;
        Node second=breaklist();
        System.out.println("data in second before reverse"+ second.data);
        Node secondpart=reverse(second);
        System.out.println(secondpart.data);

        while(firstpart!=null && secondpart!=null)
        {
            if (firstpart.data == secondpart.data)
            {
                System.out.println("first data "+firstpart.data+"second data"+secondpart.data );
                firstpart = firstpart.next();
                secondpart = secondpart.next();
            }
            else
            {
                System.out.println("Not a palindrome");
                break;
            }

        }
        if (firstpart==null || secondpart==null)
        {
        System.out.println("Is a palindrome");}
    }

    public Node breaklist()
    {
        Node front=head;
        Node temp=head;
        if(head!=null)
        {
            front=head;
        }
        while(front!=null && front.next()!=null)
        {
            front=front.next();
            if(front.next()!=null) {
                front = front.next();
                temp = temp.next();
            }
        }
        Node second=temp.ptr;
        temp.ptr=null;
        return second;

    }


    public void print()
    {
        Node temp=head;
        while(temp!=null)
        {

            System.out.println("Data in LinkedList:" +temp.data);
            temp=temp.next();
        }
    }


    public void createCycle()
    {
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);
        Node mid= middle();
        addNode(6);
        addNode(7);
        addNode(8);
        Node temp=head;
        while (temp.next()!=null)
        {
            temp=temp.next();
        }
       temp.ptr=mid;
        System.out.println("Cycle is created");
        cycle();
    }

    public void cycle()
    {
        if((head==null) || (head.next()==null))
        {
            System.out.println("Not a cycle");
        }
        Node front=head;
        Node back=head;
        while ((front!=null))
        {
            front=front.next();
            if(front!=null) {
                front = front.next();
                back = back.next();
            }
            if(front==back)
            {
                break;
            }
        }
        if(front==null)
        {
            System.out.println("Not a cycle");
        }
        if(front==back)
        {
            System.out.println("Is a cycle");
        }

      }

    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
       /* for(int i=1;i<6;i++)
        {
            ll.addNode(i);
        }*/

     /* ll.addNode(2);
        ll.addNode(3);
        ll.addNode(5);
        ll.addNode(4);
        ll.addNode(3);
        ll.addNode(2);
        ll.palindrome();
       */
       /* ll.deleteNode(1);
        ll.print();*/

      /*  ll.reverse();
        ll.print();*/

       /* int element=ll.findn(3);
        System.out.println("Element in position is : " +element);*/

//       int middle=ll.middle();
//        System.out.println("Element is : " +middle);

        //ll.midReverse();
       // ll.print();

        ll.createCycle();

    }

}
