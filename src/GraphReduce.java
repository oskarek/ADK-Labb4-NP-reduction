/**
 * Created by RobertLorentz on 15/11/16.
 */
public class GraphReduce {

Kattio io;

    GraphReduce() {
        io = new Kattio(System.in, System.out);

        Graph graph = readGraph();

        translateToCasting(graph);
    }

    public void translateToCasting(Graph graph) {

    }

    public Graph readGraph() {
        int v = io.getInt();
        int e = io.getInt();
        int m = io.getInt();
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
