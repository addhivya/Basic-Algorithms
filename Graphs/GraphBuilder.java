package Graphs;

public class GraphBuilder {

    Graph g;

    GraphBuilder(){
        g = new Graph();
        createVectors();
        addEdgesToGraph();
    }

    public Graph getGraph(){
        return this.g;
    }

    private void createVectors() {
        for(int i=0; i<9; i++) {
            g.addVector(new Vector(i));
        }
    }

    private void addEdgesToGraph() {
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(0), g.vectorList.get(1));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(1), g.vectorList.get(2));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(1), g.vectorList.get(7));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(2), g.vectorList.get(8));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(8), g.vectorList.get(6));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(7), g.vectorList.get(8));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(0), g.vectorList.get(7));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(2), g.vectorList.get(3));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(2), g.vectorList.get(5));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(3), g.vectorList.get(5));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(6), g.vectorList.get(5));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(3), g.vectorList.get(4));
        g.addEdgeBetweenVectorsNonCycleic(g.vectorList.get(4), g.vectorList.get(5));
    }
}
