package prep.datastructures;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.LinkedList;

/**
 * A simple graph. Nodes are strings.
 * @author rbart
 *
 */
public class Graph {

	private Map<String, List<String>> edges;
	
	public Graph() {
		edges = new HashMap<String, List<String>>();
	}
	
	public Set<String> getNodes() {
		return edges.keySet();
	}
	
	public void addNode(String s) {
		if (!edges.containsKey(s)) edges.put(s, new LinkedList<String>());
	}
	
	private void assertNodeExists(String s) {
		if (!edges.containsKey(s))
			throw new IllegalArgumentException("Graph does not contain node: " + s);
	}
	
	public void addEdge(String u, String v) {
		assertNodeExists(u);
		assertNodeExists(v);
		edges.get(u).add(v);
		edges.get(v).add(u);
	}
	
	public List<String> getEdges(String u) {
		assertNodeExists(u);
		return edges.get(u);
	}
	
	public boolean containsNode(String s) {
		return edges.containsKey(s);
	}
	
	public boolean containsEdge(String u, String v) {
		if (!containsNode(u) || !containsNode(v)) return false;
		List<String> edges = getEdges(u);
		return edges.contains(v);
	}
}
