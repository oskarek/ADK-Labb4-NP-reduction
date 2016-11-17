import java.util.ArrayList;

/**
 * Created by RobertLorentz on 15/11/16.
 */
public class GraphReduce {

    Kattio io;
    private int k;


    GraphReduce() {
        io = new Kattio(System.in, System.out);

        Graph graph = readGraph();

        printFirst(graph);

        printRoles(graph);

        printScenes(graph);

        io.close();
    }

    public void printFirst(Graph graph) {
        io.println(graph.getNumberOfVertexes());
        io.println(graph.getEdgeNum());
        io.println(k);
    }

    public void printRoles(Graph graph) {
        int vertexCount = graph.getNumberOfVertexes();
        for (int i = 0; i < vertexCount; i++) {
            io.print(k);
            for (int j = 1; j <= k; j++)
                io.print(" " + j);
            io.println();
        }
    }
    public void printScenes(Graph graph) {
        ArrayList<Graph.Vertex> vertexes = graph.getVertexes();
        for(Graph.Vertex v : vertexes)
            for(Graph.Edge edge : v.getEdges())
                io.println("2 " + edge.getFrom() + " " + edge.getTo());
    }

    public Graph readGraph() {
        //+2 because we want to add 2 divas
        int v = io.getInt()+2;
        int e = io.getInt();
        k = io.getInt()+2;
        Graph graph = new Graph(v);

        for (int i = 0; i < e; i++) {
            int a = io.getInt()+2;
            int b = io.getInt()+2;
            graph.addEdge(a, b);
        }

        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph = addMissingEdges(graph);

        return graph;
    }

    public Graph addMissingEdges(Graph graph) {
        ArrayList<Graph.Vertex> vertexes = graph.getVertexes();
        for(Graph.Vertex vertex : vertexes){
            if(!vertex.hasEdge())
                graph.addEdge(vertex.getValue(),3);
        }
        return graph;
    }


    public static void main(String[] args) {
        new GraphReduce();
    }
}
