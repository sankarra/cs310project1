import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

/**
 * This class implements a FlightMap based on an input file
 * @author Anup Sankarraman
 *
 */
public class FlightMap {

	private Graph g;
	
	/**
	 * Default constructor solely used for JUnit test
	 */
	public FlightMap()
	{
		
	}
	/**
	 * This constructs a FlightMap based on a given input file
	 * @param inputBR The input file as BR to be extracted
	 * @throws IOException Exception is thrown in case of wrong input/output file
	 */
	public FlightMap(BufferedReader inputBR, PrintWriter outputPW) throws IOException 
	{
		String line;
		g = new Graph();
		
		char c = inputBR.readLine().charAt(0);
		Node sourceNode = new Node(c);
		
		g.addNode(sourceNode);
		
	    while ((line = inputBR.readLine()) != null) {
	        String [] words = line.split(" ");
	        
	        char source = words[0].charAt(0);
	        char destination = words[1].charAt(0);
	        
	        Node firstNode = g.getNode(source);
	        Node secondNode = g.getNode(destination);
	        
	        
	        if (firstNode == null)
	        {
	        	firstNode = new Node(source);
	        	g.addNode(firstNode);
	        }
	        if (secondNode == null)
	        {
	        	secondNode = new Node(destination);
	        	g.addNode(secondNode);
	        }
	        
	        firstNode.addDestination(secondNode, Integer.parseInt(words[2]));
	        
	    }	
	    g = FlightMap.calculateShortestPathFromSource(g, sourceNode);
	    FlightMap.printShortestPathTable(g, sourceNode, outputPW);
	       
	}
	/**
	 * Prints table of shortest path of starting node to all other nodes
	 * @param g Constructed graph of all nodes based on input file
	 * @param sourceNode Starting/Head node 
	 */
	public static void printShortestPathTable(Graph g, Node sourceNode, PrintWriter pw)
	{
		pw.println("Destination\tFlight Route from " + sourceNode.getName() + "\tTotal Cost");
		
		
		
		for (Node n: g.getNodes())
		{
			if (n == sourceNode || n.getShortestPath().size() == 0)
			{
				continue;
			}
			
			pw.print(n.getName() + "\t\t");
			boolean firstComma = false;
			for (Node m: n.getShortestPath())
			{
				if (firstComma == true)
				{
					pw.print(",");
				}
				pw.print(m.getName());
				firstComma = true;
			}
			pw.print("," + n.getName());
			pw.println("\t\t\t$" + n.getDistance());
			
		}		
	}
	/**
	 * Calculates the shortest path from head node to other nodes
	 * @param graph Constructed graph of all nodes based on input file
	 * @param source Starting/Head node 
	 * @return Graph with calculated shortest path from head node to all other nodes
	 */
	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
	    source.setDistance(0);
	 
	    Set<Node> settledNodes = new HashSet<>();
	    Set<Node> unsettledNodes = new HashSet<>();
	 
	    unsettledNodes.add(source);
	 
	    while (unsettledNodes.size() != 0) {
	        Node currentNode = getLowestDistanceNode(unsettledNodes);
	        unsettledNodes.remove(currentNode);
	        for (Entry<Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()) {
	            Node adjacentNode = adjacencyPair.getKey();
	            Integer edgeWeight = adjacencyPair.getValue();
	            if (!settledNodes.contains(adjacentNode)) {
	                calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
	                unsettledNodes.add(adjacentNode);
	            }
	        }
	        settledNodes.add(currentNode);
	    }
	    return graph;
	}
	/**
	 * Finds the closest node
	 * @param unsettledNodes Set of nodes without known reachable distances
	 * @return Closest node
	 */
	private static Node getLowestDistanceNode(Set < Node > unsettledNodes) {
	    Node lowestDistanceNode = null;
	    int lowestDistance = Integer.MAX_VALUE;
	    for (Node node: unsettledNodes) {
	        int nodeDistance = node.getDistance();
	        if (nodeDistance < lowestDistance) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    return lowestDistanceNode;
	}
	/**
	 * Finds shortest distance from one node to another
	 * @param evaluationNode Node with unknown distances to other nodes
	 * @param edgeWeigh Integer value of edge
	 * @param sourceNode Starting/Head node
	 */
	private static void calculateMinimumDistance(Node evaluationNode,
			  Integer edgeWeigh, Node sourceNode) {
			    Integer sourceDistance = sourceNode.getDistance();
			    if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			        evaluationNode.setDistance(sourceDistance + edgeWeigh);
			        LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			        shortestPath.add(sourceNode);
			        evaluationNode.setShortestPath(shortestPath);
			    }
			}

}
