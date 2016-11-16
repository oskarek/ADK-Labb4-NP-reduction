import java.util.ArrayList;

/**
 * Created by RobertLorentz on 15/11/16.
 */
public class GraphReduce {

    Kattio io;
    private int m;


    GraphReduce() {
        io = new Kattio(System.in, System.out);

        Graph graph = readGraph();

        translateToCasting(graph);
    }

    public void translateToCasting(Graph graph) {
        ArrayList<Graph.Vertex> vertexes = graph.getVertexes();
        ArrayList<String> scenes = new ArrayList<>();
        for(Graph.Vertex v : vertexes){
            ArrayList<Graph.Edge> edges = v.getEdges();
            if(edges.isEmpty()){
                scenes.add("2 ".concat(Integer.toString(v.getValue())+" 1"));
            }
            for(Graph.Edge edge : edges) {
                String s = "2 ".concat(Integer.toString(edge.getFrom())+" "+Integer.toString(edge.getTo()));
                scenes.add(s);
            }
        }
    }

    public Graph readGraph() {
        int v = io.getInt();
        int e = io.getInt();
        m = io.getInt();
        Graph graph = new Graph(v);
        for (int i = 0; i < e; i++) {
            int a = io.getInt();
            int b = io.getInt();
            graph.addEdge(a, b, 0);
        }

        return graph;
    }


    public static void main(String[] args) {
        new GraphReduce();
    }
}
