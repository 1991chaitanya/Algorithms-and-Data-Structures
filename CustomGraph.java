import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class CustomGraph {

	Vertex[] vertices;

	CustomGraph(int capacity) {
		vertices = new Vertex[capacity];
	}

	public Vertex createVertex(int data) {
		Vertex vertex = new Vertex(data);
		return vertex;
	}

	public void addVertex(Vertex vertex, int pos) {
		vertices[pos] = vertex;
	}

	public void addEdge(Vertex source, Vertex destination) {
		source.addAdjacent(destination);
		destination.addAdjacent(source);
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