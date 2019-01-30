package Graph2;

public class Edge {
    int weight;
    Vector startvector;
    Vector endvector;

    Edge(Vector startvector,Vector endvector, int weight )
    {
        this.startvector=startvector;
        this.endvector=endvector;
        this.weight=weight;
    }

}
