package Graph2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Graph {

    List<Vector> vectors=new ArrayList<>();

    public Graph() {

        Vector vector1 = new Vector("A");
        Vector vector2 = new Vector("B");
        Vector vector3 = new Vector("C");
        Vector vector4 = new Vector("D");
        Vector vector5 = new Vector("E");
        Vector vector6 = new Vector("F");

        vector1.addEdge(vector1,vector2,3);
        vector1.addEdge(vector2,vector1,3);

        vector1.addEdge(vector1,vector3,4);
        vector1.addEdge(vector3,vector1,4);

        vector2.addEdge(vector2,vector4,3);
        vector2.addEdge(vector4,vector2,3);

        vector2.addEdge(vector2,vector5,3);
        vector2.addEdge(vector5,vector2,3);

        vector3.addEdge(vector3,vector4,2);
        vector3.addEdge(vector4,vector3,2);

        vector3.addEdge(vector3,vector5,2);
        vector3.addEdge(vector5,vector3,2);

        vector4.addEdge(vector4,vector5,1);
        vector4.addEdge(vector5,vector4,1);

        vector4.addEdge(vector4,vector6,1);
        vector4.addEdge(vector6,vector4,1);

        vector5.addEdge(vector5,vector6,3);
        vector5.addEdge(vector6,vector5,3);

        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector4);
        vectors.add(vector5);
        vectors.add(vector6);

        //DFSRec(vector1);
        //DFS(vector1);
/*
        List<String> list=new ArrayList<>();
        boolean result = Hamiltonian(vector1,list, vector1,vectors.size());
        System.out.println(result);*/
int[] a= {2,5};
List<List<String>> list=new ArrayList<>();
SumComb(0,50,0,a,list, new ArrayList<String>());
for(List<String> temp : list) {
    for(String s: temp) {
        System.out.print(s);
    }
    System.out.println();
}
    }


    public void DFS(Vector first)
    {
        Stack<Vector> stack=new Stack<>();
        stack.push(first);
        while(!stack.isEmpty()) {
            Vector element = stack.pop();
            if(element.IsVisited) {
             //   System.out.println("Already visited"+ element.name);
                continue;
            }
            System.out.println(element.name);
            element.IsVisited = true;
            for(Edge e : element.listedges) {
                stack.push(e.endvector);
            }
        }
    }

    public void DFSRec(Vector first)
    {

        if(first.IsVisited==true)
        {
            return;
        }
        if(first.IsVisited==false) {
            System.out.println(first.name);
            first.IsVisited = true;
        }
        if(first.listedges.size()==0)
            return;
        for(Edge e:first.listedges)
        {
           DFSRec(e.endvector);
        }
    }

    public Boolean Hamiltonian(Vector start,List<String> list, Vector toCheck, int numToCheck)
    {
        if(start.name.equals(toCheck.name) && list.size() ==numToCheck ) {
           System.out.println("Returning true");
           return true;
        }
        if(start.IsVisited==true) {
            return false;
        }
        start.IsVisited = true;
        list.add(start.name);
        for (Edge e : start.listedges) {
            Vector from = e.startvector;
            Vector to = e.endvector;
            boolean result = Hamiltonian(from == start ? to : from,list,toCheck,numToCheck);
            if(result)
                return result;
        }
        list.remove(list.size()-1);
        start.IsVisited=false;
        return false;
    }

    public void SumComb(int currsum, int sum, int index, int a[], List<List<String>> list, List<String> temp)
    {
        if(currsum==sum)
        {
            List<String> toCopy = new ArrayList<>(temp);
            list.add(toCopy);

        }
        if(currsum>sum)
            return;

        if(index>a.length-1)
        {
            return ;
        }

        if(sum == currsum) {
            System.out.println("GOT SUM");
        }

        for(int i=0;i<=(sum/a[index]);i++) {
            int sumNow = currsum + (a[index] * i);
            if (sumNow > sum) break;
            temp.add("" + a[index] + "X" + "" + i + " ");
            SumComb(sumNow, sum, index + 1, a, list, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Graph graph=new Graph();

    }
}
