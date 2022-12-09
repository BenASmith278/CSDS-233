import java.util.Arrays;

class Demo {
    public static void main(String[] args) {
        Graph G = new Graph(5);

        G.addNodes(new String[]{"A", "C", "D", "E", "End", "F", "G", "B", "Start"});

        G.addEdges("A", new String[]{"G", "Start"});
        G.addEdges("B", new String[]{"Start", "E", "F"});
        G.addEdges("D", new String[]{"Start", "F"});
        G.addEdge("F", "G");
        G.addEdge("G", "End");

        G.BFS("Start", "End", "reverse");
    }
}