import java.util.ArrayList;

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
        if(findIndex(name) != -1)  // if vertex already exists in vertices
            return false;
        addNodeHelper(name);

        System.out.println("After Add Node " + name +": ");
        printGraph();
        return true;
    }

    private void addNodeHelper(String name) {
        // grow vertices if array "vertices" is too small
        if(numVertices >= maxNum) {
            Vertex[] newVertices = new Vertex[maxNum+5];
            for(int i=0; i<maxNum; i++) {
                newVertices[i] = vertices[i];
            }

            maxNum += 5;
            vertices = newVertices;
        }

        // place vertex in correct alphabetical spot in vertices
        int j = numVertices;
        for(int i=numVertices-1; i>-1; i--) {
            for(int k=0;k<vertices[i].id.length() && k<name.length();k++) {
                if(vertices[i].id.charAt(k) > name.charAt(k)) {
                    j--;
                    vertices[i+1] = vertices[i];
                }
            }
        }

        numVertices++;
        vertices[j] = new Vertex(name);
    }

    public boolean addNodes(String[] names) {
        for(String name : names)
            if(findIndex(name) != -1)  // if vertex exists in vertices
                return false;

        for(String name : names)
            addNodeHelper(name); 

        System.out.println("After Add Nodes: ");
        printGraph();
        return true;
    }

    private int findIndex(String name) {
        // return index of name in vertices
        for(int i=0; i<numVertices; i++) {
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
        addEdgeHelper(i, j);
        
        System.out.println("After Add Edge " + from + " -> " + to + ": ");
        printGraph();
        return true;
    }

    private void addEdgeHelper(int i, int j) {        
        // add an edge from i to j
        Edge newEdge = new Edge();
        newEdge.endNode = j;

        // place edge in correct spot in edges
        int n = vertices[i].edges.size();
        for(int m=n-1; m>-1; m--) {
            if(vertices[i].edges.get(m).endNode > newEdge.endNode) {
                n--;
            }
        }
        vertices[i].edges.add(n, newEdge);

        // add an edge to j for Node i
        newEdge = new Edge();
        newEdge.endNode = i;

        n = vertices[j].edges.size();
        for(int m=n-1; m>-1; m--) {
            if(vertices[j].edges.get(m).endNode > newEdge.endNode) {
                n--;
            }
        }
        vertices[j].edges.add(n, newEdge);
    }

    public boolean addEdges(String from, String[] tolist) {
        int i = findIndex(from);
        
        // check inputs
        if(i == -1)
            return false;
        for(String to : tolist) {
            if(findIndex(to) == -1)
                return false;
        }

        for(String to : tolist)
            addEdgeHelper(i, findIndex(to));

        System.out.println("After Add Edges: ");
        printGraph();
        return true;
    }

    private void removeEdgeHelper(String from, String to) {
        int fromIndex = findIndex(from);
        int toIndex = findIndex(to);

        for(int i=0; i<vertices[fromIndex].edges.size();i++) {
            if(vertices[fromIndex].edges.get(i).endNode == toIndex)
                vertices[fromIndex].edges.remove(vertices[fromIndex].edges.get(i));
        }
    }

    public boolean removeEdge(String from, String to) {
        // removes edge from -> to if it exists
        int fromIndex = findIndex(from);
        int toIndex = findIndex(to);
        if(fromIndex == -1 || toIndex == -1)
            return false;
        
        removeEdgeHelper(from, to);
        removeEdgeHelper(to, from);  // remove both edges
        System.out.println("After Remove Edge " + from + " -> " + to + ": ");
        printGraph();
        return true;
    }

    public boolean removeAllEdges(String from) {
        int fromIndex = findIndex(from);
        if(fromIndex == -1)
            return false;

        for(int i=0;i<vertices[fromIndex].edges.size();i++) {
            removeEdgeHelper(from, vertices[vertices[fromIndex].edges.get(i).endNode].id);
        }

        System.out.println("After Remove All Edges From Node " + from + ": ");
        printGraph();
        return true;
    }

    private void removeNodeHelper(String name) {
        int i = findIndex(name);
        
        // remove all edges pointing to vertex
        removeAllEdges(name);
        for(int n=0;n<numVertices;n++) {
            removeEdgeHelper(vertices[n].id, name);
        }

        // shift vertices over
        int j;
        for(j=i;j<numVertices-1;j++) {
            vertices[j] = vertices[j+1];
        }

        // update edge endNode variables
        for(int n=0;n<numVertices-1;n++) {
            for(int m=0;m<vertices[n].edges.size();m++) {
                if(vertices[n].edges.get(m).endNode >= i)
                    vertices[n].edges.get(m).endNode--;
            }
        }

        vertices[j] = null;
        numVertices--;
    }

    public boolean removeNode(String name) {
        int i = findIndex(name);
        if(i == -1)
            return false;

        removeNodeHelper(name);
        System.out.println("After Remove Node " + name + ": ");
        printGraph();
        return true;
    }

    public boolean removeNodes(String[] nodelist) {
        for(String name : nodelist){
            removeNodeHelper(name);
        }

        return true;
    }

    public void printGraph() {
        // for each vertex, print adjacency list
        for(int i=0;i<numVertices;i++) {
            System.out.print(vertices[i].id + ": ");

            for(int j=0;j<vertices[i].edges.size();j++) {
                System.out.print(vertices[vertices[i].edges.get(j).endNode].id);

                // add comma if appropriate
                if(j < vertices[i].edges.size() - 1)
                    System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public String[] DFS(String from, String to, String neighborOrder) {
        
        return new String[0];
    }

    public String[] BFS(String from, String to, String neighborOrder) {

        return new String[0];
    }

    public String[] shortestPath(String from, String to) {

        return new String[0];
    }

    public String[] secondShortestPath(String from, String to) {

        return new String[0];
    }
}