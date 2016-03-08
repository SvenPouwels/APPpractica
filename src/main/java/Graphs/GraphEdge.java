package Graphs;

/**
 * Created by sven_ on 08/03/2016.
 */
public class GraphEdge {
    public GraphNode otherNode;
    public double cost;

    public GraphEdge(GraphNode node, double cost){
        otherNode = node;
        this.cost = cost;
    }

    public String toString(){
        return "To " + otherNode.name + " costs " + cost;
    }
}

