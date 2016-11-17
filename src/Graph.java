import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;

/**
 * A graph implementation.
 * Created by RobertLorentz on 30/10/16.
 */
public class Graph {
    private ArrayList<Vertex> vertexes;
    private int edgeNum;

    public Graph(int v){
        vertexes = new ArrayList<>(v);
        loadVertexes(v);
    }

    public ArrayList<Vertex> getVertexes() { return vertexes; }
    public int getNumberOfVertexes() { return vertexes.size(); }
    public int getEdgeNum() { return edgeNum; }

    public int vertexCount() {
        return vertexes.size();
    }

    public ArrayList<Edge> edgesForVertex(int vertex) {
        return getVertex(vertex).getEdges();
    }

    void loadVertexes(int v) {
        for(int i = 1; i<=v; i++){
            addVertex(i);
        }
    }

    public void addVertex(int repr){
        vertexes.add(new Vertex(repr));
    }

    public Vertex getVertex(int value) {
        return vertexes.get(value-1);
    }

    public ArrayList<Edge> edges() {
        ArrayList<Edge> edges = new ArrayList<>();
        for(Vertex v : vertexes){
            for(Edge edge : v.getEdges())
                edges.add(edge);
        }
        return edges;
    }

    public void addEdge(int from, int edgeTo){
        Vertex v = getVertex(from);
        Edge edge = v.addEdge(from, edgeTo);
        v.setHasEdge();
        getVertex(edgeTo).setHasEdge();
    }

    public void removeEdge(int from, int to) {
        Vertex v = getVertex(from);
        v.removeEdge(to);
    }

    public Optional<Edge> getEdge(int from, int to) {
        return getVertex(from).getEdge(to);
    }

    public class Vertex {
        private Boolean hasEdge;
        private int value;
        private ArrayList<Edge> edges;
        public int getValue() { return value; }
        public ArrayList<Edge> getEdges() { return edges; }

        public Optional<Edge> getEdge(int to) {
            for(Edge edge : edges){
                if(edge.getTo() == to)
                    return Optional.of(edge);
            }
            return Optional.empty();
        }

        public Boolean hasEdge(){ return hasEdge; }

        public void setHasEdge() { hasEdge = true; }

        public Vertex(int value) {
            hasEdge = false;
            this.value = value;
            edges = new ArrayList<>();
        }

        public Edge addEdge(int edgeFrom, int edgeTo){
            edgeNum++;
            Edge e = new Edge(edgeFrom, edgeTo);
            edges.add(e);
            return e;
        }

        public void removeEdge(int to) {
            for(Edge edge : edges){
                if(edge.getTo() == to) {
                    edges.remove(edge);
                    break;
                }
            }
        }
    }

    public static class Edge  {
        private int edgeFrom;
        private int edgeTo;

        public Edge(int edgeFrom, int edgeTo){
            this.edgeFrom = edgeFrom;
            this.edgeTo = edgeTo;
        }

        public int getFrom() { return edgeFrom; }

        public int getTo() { return edgeTo; }


    }
}