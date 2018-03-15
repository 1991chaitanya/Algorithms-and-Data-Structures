import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class TestGraph {

    public static void main(String[] args) {
        CustomGraph customGraph = new CustomGraph(4);
        CustomGraph.Vertex vertex1 = customGraph.createVertex(0);
        customGraph.addVertex(vertex1,0);

        CustomGraph.Vertex vertex2 = customGraph.createVertex(1);
        customGraph.addVertex(vertex2,1);

        CustomGraph.Vertex vertex3 = customGraph.createVertex(2);
        customGraph.addVertex(vertex3,2);
        
        CustomGraph.Vertex vertex4 = customGraph.createVertex(3);
        customGraph.addVertex(vertex4,3);

       /* CustomGraph.Vertex vertex4 = customGraph.createVertex(4);
        customGraph.addVertex(vertex4,3);

        CustomGraph.Vertex vertex5 = customGraph.createVertex(5);
        customGraph.addVertex(vertex5,4);*/

        /*customGraph.addEdge(vertex, vertex2);
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
*/

        customGraph.addEdge(vertex1,vertex2,0);
        customGraph.addEdge(vertex2, vertex3,1);
        customGraph.addEdge(vertex3, vertex4,2);
        customGraph.addEdge(vertex4, vertex1,3);
        // customGraph.addEdge(vertex3, vertex4);
        
         customGraph.print();
        
        // customGraph.bfs(vertex5);
         
        //   customGraph.dfs(vertex5);
        boolean detectCycle = customGraph.detectCycle();
        System.out.println("Is Cycle: "+detectCycle);
        
     /* CustomGraph.Node node1 =   customGraph.makeSet(0, 1);
      CustomGraph.Node node2 =  customGraph.makeSet(0, 2);
      CustomGraph.Node node3 =  customGraph.makeSet(0, 3);
      CustomGraph.Node node4 =  customGraph.makeSet(0, 4);
      CustomGraph.Node node5 =  customGraph.makeSet(0, 5);
      CustomGraph.Node node6 =  customGraph.makeSet(0, 6);
      CustomGraph.Node node7 =  customGraph.makeSet(0, 7);

        customGraph.union(node1, node2);
        customGraph.union(node2, node3);
        customGraph.union(node4, node5);
        customGraph.union(node6, node7);
        customGraph.union(node5, node6);
        customGraph.union(node3, node7);
        
        CustomGraph.Node node[] = new CustomGraph.Node[7];
        //for(int i=0; i<7; i++) {
        	node[0] = node1;
        	node[1] = node2;
        	node[2] = node3;
        	node[3] = node4;
        	node[4] = node5;
        	node[5] = node6;
        	node[6] = node7;
        	
        	Arrays.sort(node);
        	
        	System.out.println("Highest ranked node: "+ node[6]);
        	
        	CustomGraph.Node found = customGraph.findSet(node2);
        	System.out.println("Representator: "+found);
        	
        	int a[] = {0, 1, 3, -2, 0, 1, 0, -3, 2, 3};
        	solution(a);
        	
        //}
*/    }
    
    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int n = A.length;
        int depth = 0;
        int i = n - 2;
        while (i > 0 ) {
             //if (A[i+1] > A[i] && A[i+1] < A[i]) {
                int currDepth = Math.min( (A[i+1] - A[i]), (A[i] - A[i-1]) );
                if (currDepth > depth) {
                    depth = currDepth;
                } 
                i--;
            // }         
        }
        
        return depth;
    }

}