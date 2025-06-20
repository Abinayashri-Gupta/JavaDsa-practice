import java.util.*;

class Edge {
    int dest, weight;
    Edge(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }
}

class GraphList {
    List<List<Edge>> adjList;
    int vertices;

    GraphList(int v) {
        vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adjList.add(new ArrayList<>());
    }

    void addEdge(int u, int v, int weight) {
        adjList.get(u).add(new Edge(v, weight));
        adjList.get(v).add(new Edge(u, weight));
    }

    void printList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + ": ");
            for (Edge edge : adjList.get(i))
                System.out.print(edge.dest +" w="+edge.weight+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphList g = new GraphList(3);
        g.addEdge(0, 1, 4);
        g.addEdge(1, 2, 6);
        g.addEdge(0, 2, 5);
        g.printList();
    }
}
