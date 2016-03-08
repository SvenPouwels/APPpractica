package Graphs;


import java.util.LinkedList;
import java.util.List;

/**
 * Created by sven_ on 08/03/2016.
 */
public class GraphNode implements Comparable<GraphNode>{
    public List<GraphEdge> edges;
    public String name;
    public GraphNode previousNode;
    public double dist;
    public int scratch;

    public GraphNode(String name){
        this.name = name;
        edges = new LinkedList<GraphEdge>();
        reset();
    }

    public void reset(){
        dist = Double.MAX_VALUE;
        previousNode = null;
        scratch = 0;
    }

    public int compareTo(GraphNode o) {
        if(o.name.compareTo(this.name) == 0) return 0;
        else if(o.name.compareTo(this.name) > 0) return -1;
        else return 1;
    }
}
