package MidTerm;

public class Identical {

    Node node1;
    Node node2;
    public void createTree()
    {
        node1=new Node(1);
        node1.left=new Node(3);
        node1.right=new Node(2);
        node1.left.left=new Node(5);


        node2=new Node(1);
        node2.left=new Node(3);
        node2.right=new Node(2);
        node2.left.left=new Node(5);
    }

    public void identical1()
    {
        Boolean result=identical(node1,node2);
        System.out.println("The two given trees are Identical - "+result);
    }

    public boolean identical(Node node1,Node node2)
    {
     if((node1!=null && node2==null)||(node2!=null && node1==null))
     {
         return false;
     }
     if(node1==null && node2==null)
     {
         return true;
     }
     Boolean res=identical(node1.left,node2.left);
     if(res) {
         if(node1.data==node2.data) {
             res = identical(node1.right, node2.right);
             if (res == false)
                 return res;
         }else return false;
     }
     else return res;
     return res;
    }

    public static void main(String[] args) {
        Identical iden=new Identical();
        iden.createTree();
        iden.identical1();
    }
}
