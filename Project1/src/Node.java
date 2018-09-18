import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Defines what a Node is in a Graph
 * @author Anup Sankarraman
 *
 */
public class Node {
     
    private char name;
     
    private LinkedList<Node> shortestPath = new LinkedList<>();
     
    private Integer distance = Integer.MAX_VALUE;
     
    Map<Node, Integer> adjacentNodes = new HashMap<>();
 
    /**
     * Adds edge weights to adjacent nodes 
     * @param destination Node to be traveled to
     * @param distance edge weight to destination
     */
    public void addDestination(Node destination, int distance) 
    {
        adjacentNodes.put(destination, distance);
    }
  
    /**
     * Constructs a node passing in a given name
     * @param name character in Node
     */
    public Node(char name) {
        this.name = name;
    }
    
    /**
     * Returns name of Node (char)
     * @return character name
     */
    public char getName()
    {
    	return name;
    }
    /**
     * Sets edge weight as distance
     * @param distance edge weight to next node
     */
    public void setDistance(int distance)
    {
    	this.distance = distance;
    }
    /**
     * Returns distance to node (int)
     * @return Integer distance
     */
    public int getDistance()
    {
    	return distance;
    }
    
    /**
     * Sets list of shortest path nodes
     * @param shortestPath list of shortest path nodes
     */
	public void setShortestPath(LinkedList<Node> shortestPath) {
		this.shortestPath = shortestPath;
	}
	
	/**
	 * Getter to return shortest path linked list
	 * @return list of shortest path nodes
	 */
	public LinkedList<Node> getShortestPath() 
	{
		return shortestPath;
	}
	
	public void setAdjacentNodes(Map<Node, Integer> adjacentNodes)
	{
		this.adjacentNodes = adjacentNodes;
	}
	
	/**
	 * Getter to return adjacent nodes Map
	 * @return Map of adjacent nodes
	 */
	public Map<Node, Integer> getAdjacentNodes() 
	{
		return adjacentNodes;
	}
	
     
    
}