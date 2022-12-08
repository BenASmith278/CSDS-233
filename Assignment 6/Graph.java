import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    class Vertex {
        private String id;
        private ArrayList<Edge> edges = new ArrayList<>();  // adjacency list
        private boolean encountered;

        public Vertex(String ident) {
            id = ident;
            encountered = false;
        }
    }

    class Edge {
        private int endNode;
    }

    private Vertex[] vertices;
    private int numVertices;
    private int maxNum;

    public Graph(int maximum) {
        vertices = new Vertex[maximum];
        numVertices = 0;
        maxNum = maximum;
    }

    public boolean addNode(String name) {
        if(checkDuplicate(name))
            return false;
        addNodeHelper(name);
        return true;
    }

    public void addNodeHelper(String name) {
        // grow vertices if array "vertices" is too small
        if(numVertices >= maxNum) {
            Vertex[] newVertices = new Vertex[maxNum+5];
            for(int i=0; i<maxNum; i++) {
                newVertices[i] = vertices[i];
            }

            vertices = newVertices;
        }

        vertices[numVertices] = new Vertex(name);
        numVertices++;
    }

    public boolean addNodes(String[] names) {
        for(String name : names)
            if(checkDuplicate(name))
                return false;

        for(String name : names)
            addNodeHelper(name); 

        return true;
    }

    public boolean checkDuplicate(String id) {
        if(numVertices == 0)
            return false;

        // check for existing id in vertices
        for(int i=0; i<numVertices; i++) {
            if(vertices[i].id == id) {
                return true;
            }
        }

        // false if no duplicate
        return false;
    }

    public int findIndex(String name) {
        // return index of name in vertices
        for(int i=0; i<maxNum; i++) {
            if(vertices[i].id == name) {
                return i;
            }
        }

        return -1;  // if not found
    }

    public boolean addEdge(String from, String to) {
        // get indices of from and to
        int i = findIndex(from);
        int j = findIndex(to);
        if(i == -1 || j == -1)
            return false;
        addEdgeHelper(from, to);
        return true;
    }

    public void addEdgeHelper(String from, String to) {
        int i = findIndex(from);
        int j = findIndex(to);
        
        // add an edge from i to j
        Edge newEdge = new Edge();
        newEdge.endNode = j;

        vertices[i].edges.add(newEdge);

        // add an edge to j for Node i
        newEdge = new Edge();
        newEdge.endNode = i;

        vertices[j].edges.add(newEdge);
    }

    public boolean addEdges(String from, String[] tolist) {
        // check inputs
        if(findIndex(from) == -1)
            return false;
        for(String to : tolist) {
            if(findIndex(to) == -1)
                return false;
        }

        for(String to : tolist)
            addEdgeHelper(from, to);

        return true;
    }

    public boolean removeEdge(String from, String to) {
        
        
        return true;
    }

    public boolean removeNode(String name) {

        return true;
    }

    public boolean removeNodes(String[] nodelist) {

        return true;
    }

    public void printGraph() {
        for(int i=0;i<numVertices;i++) {
            System.out.print(vertices[i].id + ": ");
            for(int j=0;j<vertices[i].edges.size();j++) {
                System.out.print(vertices[vertices[i].edges.get(j).endNode].id);
                if(j < vertices[i].edges.size() - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }

}