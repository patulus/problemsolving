import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1717
 * @problemTitle    집합의 표현
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String tokens[] = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]); // 0부터 n까지의 수 중 겹치지 않게 하나의 원소를 가지는 n + 1개의 집합
        int m = Integer.parseInt(tokens[1]); // 연산 개수

        // 같은 집합인지 판단을 위한 배열 생성 및 초기화
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            parent[i] = i;
        }
        /// Union by rank
        // 트리 높이를 낮추기 위한 배열 생성
        int[] rank = new int[n + 1];

        // 연산 수행
        while (m > 0) {
            tokens = br.readLine().split(" ");
            int op = Integer.parseInt(tokens[0]);
            int a = Integer.parseInt(tokens[1]);
            int b = Integer.parseInt(tokens[2]);

            switch (op) {
                case 0:
                    union(parent, rank, a, b);
                    break;
                case 1:
                    sb.append(find(parent, a) == find(parent, b) ? "YES\n" : "NO\n");
                    break;
            }

            --m;
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