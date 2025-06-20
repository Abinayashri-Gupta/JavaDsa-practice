class GraphAdjacencyMatrix {
    int[][] adjMatrix;
    int vertices;

    GraphAdjacencyMatrix(int v) {
        vertices=v;
        adjMatrix=new int[v][v];
    }
    void addEdge(int u, int v,int w) {
        adjMatrix[u][v] = w;
        adjMatrix[v][u] = w;
    }

    void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        GraphAdjacencyMatrix g=new GraphAdjacencyMatrix(3);
        g.addEdge(1, 0,4);
        g.addEdge(2, 0,6);
        g.addEdge(1, 2,3);
        g.printMatrix();
    }
}
