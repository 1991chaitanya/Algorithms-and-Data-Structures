public class TestGraph {

    public static void main(String[] args) {
        CustomGraph customGraph = new CustomGraph(5);
        CustomGraph.Vertex vertex = customGraph.createVertex(1);
        customGraph.addVertex(vertex,0);

        CustomGraph.Vertex vertex2 = customGraph.createVertex(2);
        customGraph.addVertex(vertex2,1);

        CustomGraph.Vertex vertex3 = customGraph.createVertex(3);
        customGraph.addVertex(vertex3,2);

        CustomGraph.Vertex vertex4 = customGraph.createVertex(4);
        customGraph.addVertex(vertex4,3);

        CustomGraph.Vertex vertex5 = customGraph.createVertex(5);
        customGraph.addVertex(vertex5,4);

        customGraph.addEdge(vertex, vertex2);
        customGraph.addEdge(vertex, vertex3);
        customGraph.addEdge(vertex, vertex4);
        customGraph.addEdge(vertex, vertex5);

        customGraph.addEdge(vertex2, vertex);
        customGraph.addEdge(vertex2, vertex3);
        customGraph.addEdge(vertex2, vertex4);
        customGraph.addEdge(vertex2, vertex5);

        customGraph.addEdge(vertex3, vertex);
        customGraph.addEdge(vertex3, vertex2);
        customGraph.addEdge(vertex3, vertex4);
        customGraph.addEdge(vertex3, vertex5);

        customGraph.addEdge(vertex4, vertex);
        customGraph.addEdge(vertex4, vertex2);
        customGraph.addEdge(vertex4, vertex3);
        customGraph.addEdge(vertex4, vertex5);

        customGraph.addEdge(vertex5, vertex);
        customGraph.addEdge(vertex5, vertex2);
        customGraph.addEdge(vertex5, vertex3);
        customGraph.addEdge(vertex5, vertex4);

        // customGraph.print();
        
        // customGraph.bfs(vertex5);
         
           customGraph.dfs(vertex5);
    }

}