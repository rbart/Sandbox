package prep.datastructures.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import prep.datastructures.Graph;

public class BFS {

	public static Map<String, String> bfs(Graph g, String s) {
		
		if (!g.containsNode(s)) 
			throw new IllegalArgumentException("Cannot search starting from non-existant node: " + s);
		
		Set<String> discovered = new HashSet<String>();
		Map<String, String> tree = new HashMap<String, String>();
		List<List<String>> layers = new ArrayList<List<String>>();
		int i = 0;
		
		layers.add(Collections.singletonList(s));
		discovered.add(s);
		
		while (!layers.get(i).isEmpty()) {
			
			List<String> nextLayer = new ArrayList<String>();
			
			for (String u : layers.get(i)) {
				
				List<String> edges = g.getEdges(u);
				for (String v : edges) {
					if (!discovered.contains(v)) {
						discovered.add(v);
						tree.put(v,  u);
						nextLayer.add(v);
					}
				}
				
			}
			layers.add(nextLayer);
			i += 1;
		}
		
		return tree;
	}
	
	/**
	 * Searches for a path from node s to node t in Graph g.
	 * If no path is found, null is returned.
	 * If either s or t is not in the graph, an IllegalArgumentException is thrown.
	 * @param g
	 * @param s
	 * @param t
	 * @return
	 */
	public static List<String> findPath(Graph g, String s, String t) {
		if (!g.containsNode(s) || !g.containsNode(t))
			throw new IllegalArgumentException("Node not in graph");
		
		Map<String, String> tree = bfs(g, s);
		
		if (!tree.containsKey(t)) return null; // no path
		
		List<String> path = new ArrayList<String>();
		
		String node = t;
		
		while (node != s) {
			path.add(node);
			node = tree.get(node);
		}
		path.add(s);

		Collections.reverse(path);
		
		return path;
	}
	
	
	public static void main(String[] args) {
		
		Graph g = testGraph1();
		
		List<String> path = findPath(g, "g", "i");
		
		if (path == null) System.out.println("no path found");
		
		else for (String node : path) System.out.println(node);
	}
	
	private static Graph testGraph1() {
		String[] nodes = {"a", "b", "c", "d", "e", "f", "g", "h", "i"};
		
		Graph g = new Graph();
		for (String n : nodes) g.addNode(n);
		
		g.addEdge("a", "b");
		g.addEdge("b", "c");
		g.addEdge("c", "d");
		g.addEdge("d", "e");
		g.addEdge("a", "f");
		g.addEdge("b", "g");
		g.addEdge("c", "h");
		g.addEdge("h", "i");
		
		require(g.containsEdge("a", "b"));
		require(g.containsEdge("b", "c"));
		require(g.containsEdge("c", "d"));
		require(g.containsEdge("d", "e"));
		
		return g;
	}
	
	private static void require(boolean b) {
		if (!b) throw new RuntimeException();
	}
}
