class Demo {
    public static void main(String[] args) {
        Graph G = new Graph(2);

        G.addNodes(new String[]{"A", "B", "C", "D"});

        G.addEdges("A", new String[]{"B", "D", "C"});

        G.removeNode("D");

        G.addNode("D");
        G.addEdge("A", "D");
        G.addEdge("D", "B");
        
        G.removeEdge("B", "A");

        G.addEdge("B", "A");
    }
}