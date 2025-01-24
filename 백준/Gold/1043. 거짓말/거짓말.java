import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1043
 * @problemTitle    거짓말
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]); // 사람의 수
        int M = Integer.parseInt(tokens[1]); // 파티의 수

        int[] parents = new int[N + 1];
        int[] rank = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            parents[i] = i;
        }

        tokens = br.readLine().split(" ");
        for (int i = 1; i < tokens.length; ++i) {
            int num = Integer.parseInt(tokens[i]);
            union(parents, rank, num, 0);
        }

        int[][] parties = new int[M][];
        for (int party = 0; party < M; ++party) {
            tokens = br.readLine().split(" ");
            int participants = Integer.parseInt(tokens[0]);

            parties[party] = new int[participants];
            for (int i = 0; i < participants; ++i) {
                parties[party][i] = Integer.parseInt(tokens[i + 1]);
            }

            for (int i = 1; i < participants; ++i) {
                union(parents, rank, parties[party][0], parties[party][i]);
            }
        }

        int res = 0;
        for (int party = 0; party < M; ++party) {
            int participants = parties[party].length;

            boolean canLie = true;
            for (int i = 0; i < participants; i++) {
                if (find(parents, parties[party][i]) == find(parents, 0)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) ++res;
        }

        bw.write(res + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static void union(int[] parents, int[] rank, int u, int v) {
        int pu = find(parents, u);
        int pv = find(parents, v);

        if (pu == pv) return;

        if (rank[pu] <= rank[pv]) {
            parents[pu] = pv;
        } else {
            parents[pv] = pu;
        }

        if (rank[pu] == rank[pv]) {
            ++rank[pv];
        }
    }

    private static int find(int[] parents, int u) {
        if (parents[u] == u) return u;

        return parents[u] = find(parents, parents[u]);
    }
}
