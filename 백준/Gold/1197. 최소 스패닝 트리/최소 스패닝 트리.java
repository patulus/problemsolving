import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static int[][] edges;
    static int[] parent;
    static int[] weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInput = br.readLine().split(" ");
        int V = Integer.parseInt(userInput[0]);
        int E = Integer.parseInt(userInput[1]);

        int i;
        edges = new int[E][3];
        parent = new int[V + 1];
        weight = new int[V + 1];

        for (i = 0; i < E; ++i) {
            userInput = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(userInput[0]);
            edges[i][1] = Integer.parseInt(userInput[1]);
            edges[i][2] = Integer.parseInt(userInput[2]);
        }
        for (i = 0; i < V + 1; ++i) {
            parent[i] = i;
        }

        bw.write(kruskal(V, edges) + "\n");
        bw.flush();
    }

    static int kruskal(int V, int[][] edges) {
        int edgeAccepted = 0;
        int uset, vset;
        int allWeight = 0;

        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));

        int i = 0;
        int[] e;
        while (edgeAccepted < V - 1) {
            e = edges[i++];

            uset = find(e[0]);
            vset = find(e[1]);

            if (uset != vset) {
                union(uset, vset);
                edgeAccepted += 1;
                allWeight += e[2];
            }
        }

        return allWeight;
    }

    static void union(int a, int b) {
        int pA = find(a);
        int pB = find(b);

        if (pA != pB) {
            if (weight[pA] < weight[pB]) {
                parent[pB] = pA;
                weight[pA] += 1;
            } else {
                parent[pA] = pB;
                weight[pB] += 1;
            }
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}