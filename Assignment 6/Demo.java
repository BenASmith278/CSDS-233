class Demo {
    public static void main(String[] args) {
        Graph G = new Graph(10);

        G.addNode("A");
        G.addNode("B");
        G.addNode("C");
        G.addNode("D");

        G.addEdge("A", "B");
        G.addEdge("A", "C");
        G.addEdge("A", "D");

        G.printGraph();
    }
}