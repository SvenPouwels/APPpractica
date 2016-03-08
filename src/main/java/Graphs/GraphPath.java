package Graphs;

/**
 * Created by sven_ on 08/03/2016.
 */
public class GraphPath implements Comparable<GraphPath> {
    public GraphNode dest;
    public double cost;

    public GraphPath(GraphNode dest, double cost) {
        this.dest = dest;
        this.cost = cost;
    }

    public int compareTo(GraphPath path){
        double otherCost = path.cost;

        return cost < otherCost ? -1 : cost > otherCost ? 1 : 0;
    }
}
