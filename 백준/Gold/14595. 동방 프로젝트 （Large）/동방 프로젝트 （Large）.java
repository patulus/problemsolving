import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   14595
 * @problemTitle    동방 프로젝트 (Large)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 동아리 방의 개수
        int M = Integer.parseInt(br.readLine()); // 빅-종빈 빌런의 행동 횟수

        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            parent[i] = i;
        }
        String[] tokens = null;

        int rooms = N;
        for (; M > 0; --M) {
            tokens = br.readLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);

            while (find(parent, x) != find(parent, y)) {
                int temp = find(parent, x) + 1;
                union(parent, x, y);
                parent[x] = temp;
                rooms--;
            }
        }

        bw.write(rooms + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static void union(int[] parent, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);

        if (pu == pv) return;

        parent[pu] = pv;
    }

    private static int find(int[] parent, int v) {
        if (parent[v] == v) return v;

        // path compression
        return parent[v] = find(parent, parent[v]);
    }
}