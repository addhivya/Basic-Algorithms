package Tree2;

import java.util.ArrayList;

public class MinHeap {

    Node node;
    Node root;
    int heapsize;
    public int[] heaparr;
    public Node a;
    public  Node b;

    public void maxheapSize(int num)
    {
        heaparr=new int[num];
        heapsize=0;
    }

    public void  createTree() {

        Node node = new Node(1);
        node.left=new Node(2);
        node.left.parent=node;
        node.right=new Node(3);
        node.right.parent=node;

        node.left.left = new Node(4);
        node.left.left.parent = node.left;
        node.left.right = new Node(5);
        node.left.right.parent = node.left;

        node.right.left = new Node(6);
        node.right.left.parent = node.right;
        node.right.right = new Node(7);
        node.right.right.parent = node.right;
        root=node;
        increHeapsize1();

        a= node.left.left;
        b= node.left.right;
    }

    public void minElement()
    {
        if(root==null)
        {
            System.out.println("Tree is empty");
        }
        else
            System.out.println(""+heaparr[0]);
    }
    public void increHeapsize1() {
        increHeapsize(root,0);
        System.out.println("Current size "+heapsize);
    }

    public int increHeapsize(Node node,int i) {
        if (node == null)
            return 0;

        if(heapsize <= heaparr.length) {
                heaparr[i] = node.data;
                i++;
                heapsize++;
            }
            increHeapsize(node.left,i);
            increHeapsize(node.right,i);
            return heapsize;
        }



    public void insert(int data)
    {
     if(root==null)
     {
        root=new Node(data);
     }
     if(heapsize==heaparr.length)
     {
         System.out.println("Heap is full. Cant insert");
     }
     else
     {
         heaparr[ heapsize+1]=data;
         heapsize=heapsize+1;
         shiftup(heapsize);
         System.out.println("Node is inserted!!");
     }
    }

    private int getparent(int index)
    {

        return (index-1)/2;

    }

    public void shiftup(int index)
    {
        if(index <=0)
    {
        return;
    }
        int parent=getparent(index);
        if(heaparr[parent]<heaparr[index])
        {
            return;
        }
        else
        {
           int temp=heaparr[parent];
           heaparr[parent]=heaparr[index];
           heaparr[index]=temp;
           shiftup(parent);
        }
    }

    public void siblings1()
    {
        boolean sib=siblings(a,b);
        System.out.println(sib);
    }
    public boolean siblings(Node a, Node b)
    {
       return areSib(root,a,b);
    }

    public boolean areSib(Node node,Node a,Node b)
    {
        if(node==null || node.left==null || node.right==null)
        {
            System.out.println("gg");
           return false;
        }
       if((node.left == a && node.right==b) || (node.left==b && node.right==a))
       {
           return true;
       }
       return (areSib(node.left,a,b) || areSib(node.right,a,b));
    }

    public void elementlevel()
    {
        ArrayList<Integer> li=new ArrayList<Integer>();
        ArrayList<Integer> list=elementlevelk( li,root,0,2);
        for(Integer i:list)
        {
            System.out.println(i);
        }
    }

    public ArrayList<Integer> elementlevelk(ArrayList<Integer> li,Node node,int level,int k)
    {
        if(node==null)
            return null;
        if (k==level)
        {
            li.add(node.data);
            return li;
        }
        elementlevelk(li,node.left,level+1,k);
        elementlevelk(li,node.right,level+1,k);
        return li;
    }



    public static void main(String[] args)
    {
        MinHeap minheap=new MinHeap();
        minheap.maxheapSize(10);
        minheap.createTree();
      //  minheap.insert(0);
      //  minheap.minElement();
        //minheap.siblings1();
        minheap.elementlevel();
    }

}
