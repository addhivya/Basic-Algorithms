package Graph2;
import java.util.*;

public class Vector {

   public String name;
   List<Edge> listedges =new ArrayList<>();
   Boolean IsVisited;

   public Vector(String name)
   {
       this.name=name;
       this.IsVisited=false;
   }

    public void addEdge(Vector startvector, Vector endvector,int weight)
    {
        Edge edge=new Edge(startvector,endvector,weight);
        startvector.listedges.add(edge);
    }

}
