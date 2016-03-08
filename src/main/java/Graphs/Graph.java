package Graphs;

import DataTypes.QueueArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by sven_ on 08/03/2016.
 */
public class Graph {
    private HashMap<String, GraphNode> nodeMap = new HashMap();

    public void addEdge(String sourceName, String destName, double cost){
        GraphNode source = getNode(sourceName);
        GraphNode destination = getNode(destName);

        source.edges.add(new GraphEdge(destination, cost));
    }

    public void unweighted(String startName){
        GraphNode startNode = getNode(startName);

        if(startNode == null)
            throw new IllegalArgumentException("Start node not found");

        QueueArrayList<GraphNode> queue = new QueueArrayList();
        queue.enqueue(startNode);
        startNode.dist = 0;

        while(!queue.isEmpty()){
            GraphNode node = queue.dequeue();

            for(GraphEdge e: node.edges){
                GraphNode to = e.otherNode;

                if(to.dist == Double.MAX_VALUE){
                    to.dist = node.dist + 1;
                    to.previousNode = node;
                    queue.enqueue(to);
                }
            }
        }
    }

    public void dijkstra(String startName){
        PriorityQueue<GraphPath> pq = new PriorityQueue();

        GraphNode startNode = getNode(startName);

        if(startNode == null)
            throw new IllegalArgumentException("Start node not found");

        clearAll();
        pq.add(new GraphPath(startNode, 0));
        startNode.dist = 0;

        int nodesSeen = 0;

        while(!pq.isEmpty() && nodesSeen < nodeMap.size()){
            GraphPath path = pq.remove();
            GraphNode node = path.dest;

            if(node.scratch != 0)
                continue;

            node.scratch = 1;
            nodesSeen++;

            for(GraphEdge e: node.edges){
                GraphNode to = e.otherNode;
                double cost = e.cost;

                if(cost < 0)
                    throw new IllegalStateException("Graph has negative edges");

                if(to.dist > startNode.dist + cost)
                {
                    to.dist = node.dist + cost;
                    to.previousNode = node;
                    pq.add(new GraphPath(to, to.dist));
                }
            }
        }
    }

    public Boolean isConnected() {
        ArrayList<GraphNode> nodes = new ArrayList();
        nodes.addAll(nodeMap.values());

        if(nodes.size() > 0)
            unweighted(nodes.get(0).name);

        for (GraphNode node : nodes) {
            if (node.dist == Double.MAX_VALUE)
                return false;
        }

        return true;
    }

    public void printPath(String destName){
        GraphNode n = nodeMap.get(destName);

        if(n == null)
            throw new IllegalArgumentException();
        else if(n.dist == Double.MAX_VALUE)
            System.out.println(destName + " is unreachable");
        else{
            printPath(n);
            System.out.println(" -> cost is: " + n.dist);
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("[");

        for (Map.Entry<String, GraphNode> entry : nodeMap.entrySet()) {
            str.append("[From ");
            str.append(entry.getKey());
            str.append(": ");

            for (GraphEdge edge : entry.getValue().edges) {
                str.append(edge.toString());
                str.append(", ");
            }

            str.setLength(str.length() - 2);
            str.append("], ");
        }

        str.setLength(str.length() - 2);
        str.append("]");

        return str.toString();
    }

    private void printPath(GraphNode dest){
        if(dest.previousNode != null)
        {
            printPath(dest.previousNode);
            System.out.print(" to ");
        }
        System.out.print(dest.name);
    }

    private void clearAll(){
        for(GraphNode n: nodeMap.values())
            n.reset();
    }

    private GraphNode getNode(String name){
        GraphNode n = nodeMap.get(name);

        if(n == null){
            n = new GraphNode(name);
            nodeMap.put(name, n);
        }

        return n;
    }
}
