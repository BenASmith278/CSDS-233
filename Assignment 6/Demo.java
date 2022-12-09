class Demo {
    public static void main(String[] args) {
        Graph G = new Graph(10);

        G.addNode("A");
        G.addNode("B");
        G.addNode("D");
        G.addNode("C");

        G.addEdge("A", "B");
        G.addEdge("A", "D");
        G.addEdge("A", "C");
        G.addEdge("D", "B");

        G.printGraph();

        G.removeNode("D");

        G.printGraph();
    }
}