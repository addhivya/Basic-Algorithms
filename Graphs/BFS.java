package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BFS {

    public int getShortestDistance(Vector v1, Vector v2) {
        Queue<Edge> queue = new LinkedList<>();
        for(Edge edge : v1.edgeList) {
             queue.add(edge);
        }
        Set<Vector> seenVector = new HashSet<>();
        seenVector.add(v1);
        queue.add(null);
        int currentLevel = 0;
        while(!queue.isEmpty()) {
            Edge currentEdge =  queue.remove();
            if(currentEdge == null) {
                currentLevel++;
                queue.add(null);
                continue;
            }
            Vector toVector = currentEdge.to;
            if(seenVector.contains(toVector)) {
                continue;
            }
            seenVector.add(toVector);
            if(toVector.number == v2.number) {
                break;
            }
            for(Edge e : toVector.edgeList) {
                 queue.add(e);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        GraphBuilder g = new GraphBuilder();
        Graph graph = g.getGraph();
        BFS bfs = new BFS();
        bfs.getShortestDistance(graph.vectorList.get(0), graph.vectorList.get(4));
    }
}
