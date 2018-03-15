import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CustomGraph {

	Vertex[] vertices;
	Edge[] edges;

	CustomGraph(int capacity) {
		vertices = new Vertex[capacity];
		edges = new Edge[capacity];
	}

	public Vertex createVertex(int data) {
		Vertex vertex = new Vertex(data);
		return vertex;
	}

	public void addVertex(Vertex vertex, int pos) {
		vertices[pos] = vertex;
	}

	public void addEdge(Vertex source, Vertex destination, int pos) {
		source.addAdjacent(destination);
		destination.addAdjacent(source);
		edges[pos] = new Edge(source, destination);
	}

	public void print() {
		for(int i=0;i<vertices.length;i++) {
			System.out.println("Vertex: "+vertices[i].data);
			System.out.print("Adjacent: (");
			for (Vertex adj: vertices[i].adjacentVertices) {
				System.out.print(adj.data+" ");
			}
			System.out.print(")");
			System.out.println("");
		}
	}

	public void bfs(Vertex v) {
		Map<Vertex, Boolean> visitedMap = new HashMap<>();
		Queue<Vertex> vertexQueue = new ArrayDeque<>();
		vertexQueue.add(v);
		while (!vertexQueue.isEmpty()) {
			Vertex visited = vertexQueue.poll();
			if (visitedMap.get(visited) == null) {
				visitedMap.put(visited, true);
				System.out.println("Visited: "+visited.data);
			}
			for (Vertex adj : visited.adjacentVertices) {
				if (visitedMap.get(adj) == null) {
					vertexQueue.add(adj);
				}
			}
		}
	}

	public void dfs(Vertex v) {
		Map<Vertex, Boolean> visitedMap = new HashMap<>();
		dfsVisit(v, visitedMap);	
	}

	private void dfsVisit(Vertex v, Map<Vertex, Boolean> visitedMap) {
		if (visitedMap.get(v) == null) {
			visitedMap.put(v, true);
			System.out.println("Visited: "+v.data);
		}
		for (Vertex adj: v.adjacentVertices) {
			if (visitedMap.get(adj) == null) {
				dfsVisit(adj, visitedMap);
			}
		}
	}

	public boolean detectCycle() {
		boolean isCycle = false;
		Map<Vertex, Node> vertexVsNode = new HashMap<>();
		for (Vertex vertex: vertices) {
			Node node = makeSet(0, vertex.data);
			vertexVsNode.put(vertex, node);
		}
		for (Edge edge : edges) {
			Vertex source = edge.source;
			Vertex dest = edge.dest;
			Node sourceNode = vertexVsNode.get(source);
			Node destNode = vertexVsNode.get(dest);
			Node repSourceNode = findSet(sourceNode);
			Node repDestNode = findSet(destNode);
			if (repSourceNode.equals(repDestNode)) {
				isCycle = true;
				break;
			} else {
				union(repSourceNode, repDestNode);
			}
		}
		return isCycle;
	}

	/*private boolean dfsVisit(Vertex v, Vertex source,  Map<Vertex, Boolean> visitedMap, Map<Vertex, Vertex> vertexVsSource, Boolean isCycle) {
		if (visitedMap.get(v) == null) {
			visitedMap.put(v, true);
			System.out.println("Visited: "+v.data);
			vertexVsSource.put(v, source);
		}
		for (Vertex adj: v.adjacentVertices) {
			if (visitedMap.get(adj) == null) {
				dfsVisit(adj, v, visitedMap, vertexVsSource, isCycle);
			} else {
				// Vertex s = vertexVsSource.get(adj);
				Vertex l = vertexVsSource.get(v);
				if (l!=null && !l.equals(adj)) {
					isCycle = true;
				}				
			}
		}
		return isCycle;
	}*/
	
	class Edge {
		int weight;
		Vertex source;
		Vertex dest;
		
		public Edge(Vertex source, Vertex dest) {
            this.source = source;
            this.dest = dest;
		}
		
		
		@Override
		public boolean equals(Object obj) {
			return this.source.equals(((Edge)obj).source) && this.dest.equals(((Edge)obj).dest);
		}
	}

	class Node implements Comparable<Node> {
		int rank;
		int data; 
		Node parent;
		
		@Override
		public boolean equals(Object obj) {
			return this.data == ((Node)obj).data;
		}
		
		@Override
		public int compareTo(Node o) {
			if (this.rank > o.rank) {
				return 1;
			} else if (this.rank < o.rank) {
				return -1;
			} 
			
			return 0;
		}
		
		@Override
		public String toString() {
			return "data: "+data+". rank: "+rank+". parent: "+parent.data;
		}
	}
	
	public Node makeSet(int rank, int data) {
		Node node = new Node();
		node.rank = 0;
		node.data = data;
		node.parent = node;
		return node;
	}
	
	public void union(Node node1, Node node2) {
		Node node1Rep = findSet(node1);
		Node node2Rep = findSet(node2);
		if (node1Rep.rank > node2Rep.rank) {
			node2Rep.parent = node1Rep;
			node1Rep.rank++;
		} else {
			node1Rep.parent = node2Rep;
			node2Rep.rank++;
		}
	}
	
	public Node findSet(Node node) {
		
		while (!node.parent.equals(node)) {
			node = node.parent;
		}
		return node;
	}
	
	public void traverseDisjointSet() {
		
	}
	
	class Vertex {
		int data;
		Set<Vertex> adjacentVertices;

		Vertex(int data) {
			this.data = data;
			adjacentVertices = new LinkedHashSet<>();
		}

		void addAdjacent(Vertex vertex) {
			adjacentVertices.add(vertex);
		}

		@Override
		public int hashCode() {
			return data;
		}

		@Override
		public boolean equals(Object obj) {
			return this.data == ((Vertex)obj).data;
		}

	}



}