import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.junit.Test;

public class junitTest {

	@Test
	public void test() {
		Graph g = new Graph();
		Node n = new Node('A');
		
		g.addNode(n);
		assertEquals('A', g.getNode('A').getName());
		
		Node c = new Node('C');
		Node d = new Node('D');
		Map<Node, Integer> myMap = new HashMap<>();
		myMap.put(d, 1);
		
		c.setAdjacentNodes(myMap);
		
		assertEquals(1, c.getAdjacentNodes().get(d).intValue());
		
		Node q = new Node('Z');
		
		q.setDistance(5);
		
		assertEquals(5, q.getDistance());
		
		
		Node p = new Node('B');
		LinkedList<Node> sPath = new LinkedList<>();
		sPath.add(p);
		
		p.setShortestPath(sPath);
		
		assertEquals('B', p.getShortestPath().removeFirst().getName());
		
		
		FlightMap fM = new FlightMap();
		Graph g2 = new Graph();
		Node a = new Node('A');
		Node b = new Node('B');
		
		g2.addNode(a);
		g2.addNode(b);
		
		a.addDestination(b, 5);
		
		assertEquals(5, fM.calculateShortestPathFromSource(g2, a).getNode('B').getDistance());
	}

}
