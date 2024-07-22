import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int start, end, weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class GraphType {
    int nVertex;
    int nEdge;

    Edge[] edges;
    int curEdge;
    int[] parent;

    GraphType(int nVertex, int nEdge) {
        this.nVertex = nVertex;
        this.nEdge = nEdge;

        edges = new Edge[nEdge];
        curEdge = -1;
        parent = new int[nVertex];
        for (int i = 0; i < nVertex; i++) {
            parent[i] = -1;
        }
    }

    void addEdge(int start, int end, int weight) {
        Edge e = new Edge(start, end, weight);
        edges[++curEdge] = e;
    }

    void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            if (parentA < parentB) {
                parent[parentB] = parentA;
            } else {
                parent[parentA] = parentB;
            }
        }
    }

    int find(int cur) {
        if (parent[cur] == -1) return cur;
        while (parent[cur] != -1) {
            cur = parent[cur];
        }
        return cur;
    }

    int kruskal() {
        int weight = 0;
        int edgeAccepted = 0;
        int uset, vset;
        Edge e = null;

        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        int i = 0;
        while (edgeAccepted < nVertex - 1) {
            e = edges[i];

            uset = find(e.start);
            vset = find(e.end);

            if (uset != vset) {
                edgeAccepted++;
                weight += e.weight;
                union(uset, vset);
            }

            i++;
        }

        return weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nVertex = Integer.parseInt(br.readLine());
        int nEdge = Integer.parseInt(br.readLine());
        GraphType g = new GraphType(nVertex, nEdge);

        String[] userInput = null;
        for (int i = 0; i < nEdge; i++) {
            userInput = br.readLine().split(" ");
            g.addEdge(Integer.parseInt(userInput[0]) - 1, Integer.parseInt(userInput[1]) - 1, Integer.parseInt(userInput[2]));
        }

        bw.write(g.kruskal() + "\n");
        bw.flush();
    }
}