import java.util.HashSet;
import java.util.Set;

/**
 * Can add nodes, get nodes, and store set of all nodes in graph
 * @author Anup Sankarraman
 *
 */
public class Graph {
 
    private Set<Node> nodes = new HashSet<>();
    
    /**
     * Add node to graph
     * @param nodeA Node to be added to graph
     */
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
    
    /**
     * 
     * @param name Letter of node to be returned
     * @return identified node in graph
     */
    public Node getNode(char name)
    {
    	for (Node n: nodes)
    	{
    		if (n.getName() == name)
    			return n;
    	}
    	return null;
    }
    
    /**
     * Returns set of nodes
     * @return set of all nodes in graph
     */
    public Set<Node> getNodes()
    {
    	return nodes;
    }
}