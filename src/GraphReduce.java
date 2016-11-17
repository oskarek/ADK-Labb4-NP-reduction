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

        printFirst(graph);

        printRoles(graph);

        printScenes(graph);

        io.close();
    }

    public void printFirst(Graph graph) {
        io.println(graph.getNumberOfVertexes());
        io.println(graph.getEdgeNum()+2);
        io.println(m+2);
    }

    public void printRoles(Graph graph) {
        ArrayList<Graph.Vertex> vertexes = graph.getVertexes();
        //The divas roles
        io.println("1 1");
        io.println("1 2");
        for(Graph.Vertex vertex : vertexes) {
            //Skip the divas
            if(vertex.getValue() == 1 || vertex.getValue() == 2){
                continue;
            }
            String s = "";
            int p=0;
            for(int i = 3; i<=m+2; i++){
                if(i==m+2) {
                    s += i;
                    p++;
                    continue;
                }
                s += i + " ";
                p++;
            }
            s = p + " " + s;
            io.println(s);
        }

    }
    public void printScenes(Graph graph) {
        ArrayList<Graph.Vertex> vertexes = graph.getVertexes();
        for(Graph.Vertex v : vertexes){
            ArrayList<Graph.Edge> edges = v.getEdges();

            //Edge case if a vertex has no neighbour, it creates an edge to the first role
            if(!v.hasEdge()){
                io.println("2 " + v.getValue() + " 3");
            }
            for(Graph.Edge edge : edges) {
                io.println("2 " + edge.getFrom() + " " + edge.getTo());
            }
        }
    }

    public Graph readGraph() {
        //+2 because we want to add 2 divas
        int v = io.getInt()+2;
        int e = io.getInt();
        m = io.getInt();
        Graph graph = new Graph(v);

        for (int i = 0; i < e; i++) {
            int a = io.getInt()+2;
            int b = io.getInt()+2;
            graph.addEdge(a, b);
        }

        return graph;
    }


    public static void main(String[] args) {
        new GraphReduce();
    }
}