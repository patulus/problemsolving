import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   17352
 * @problemTitle    여러분의 다리가 되어 드리겠습니다!
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] parents = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            parents[i] = i;
        }
        int[] rank = new int[N + 1];

        String[] tokens;
        for (int i = 0; i < N - 2; ++i) {
            tokens = br.readLine().split(" ");
            int u = Integer.parseInt(tokens[0]);
            int v = Integer.parseInt(tokens[1]);

            union(parents, rank, u, v);
        }

        for (int i = 1; i <= N; ++i) {
            parents[i] = find(parents, i);
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; ++i) {
            set.add(parents[i]);
        }
        for (int i : set) {
            sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static void union(int[] parent, int[] rank, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);

        // 이미 같은 집합이면 생략
        if (pu == pv) return;

        // u의 높이가 v의 높이보다 낮으면 높이가 큰 집합 v에 속하도록 함
        if (rank[pu] <= rank[pv]) {
            parent[pu] = pv;
        } else {
            parent[pv] = pu;
        }

        // 둘의 높이가 같으면 위 조건문 내부(parent[u] = v)에 의해 집합 v의 높이 증가
        if (rank[pu] == rank[pv]) {
            ++rank[pv];
        }
    }

    private static int find(int[] parent, int v) {
        // 부모가 자기 자신이면 자기 자신을 반환
        if (parent[v] == v) return v;

        /// Path compression
        // 자기 자신이 아니면 최종 부모(자기 자신이 나올 때까지)를 탐색
        return parent[v] = find(parent, parent[v]);
    }
}