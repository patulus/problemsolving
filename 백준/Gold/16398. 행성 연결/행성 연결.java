import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   16398
 * @problemTitle    행성 연결
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 행성의 수

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 플로우 관리 비용 입력
        String[] tokens;
        for (int i = 0; i < N; ++i) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                int w = Integer.parseInt(tokens[j]);
                pq.offer(new Edge(i, j, w));
            }
        }

        // Union-Find 초기화
        int[] parent = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = i;
        }

        // Kruskal
        long weight = 0; // Overflow 방지
        Edge edge;
        while (!pq.isEmpty()) {
            edge = pq.poll();

            // 둘이 이미 연결된 상태이면(같은 집합이면) 다음 간선 확인
            if (find(parent, edge.start) == find(parent, edge.end)) continue;

            weight += edge.weight;
            union(parent, edge.start, edge.end);
        }

        bw.write(weight + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static void union(int[] parent, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);

        if (pu == pv) return;

        if (pu < pv) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
        }
    }

    private static int find(int[] parent, int v) {
        if (parent[v] == v) return v;

        // path compression
        return parent[v] = find(parent, parent[v]);
    }
}

class Edge implements Comparable<Edge> {
    int start, end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}