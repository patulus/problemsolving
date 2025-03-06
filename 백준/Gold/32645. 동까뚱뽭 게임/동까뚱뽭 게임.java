import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   32645
 * @problemTitle    동까뚱뽭 게임
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] tokens;

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            tree.add(new ArrayList<>());
        }

        boolean[] dp = new boolean[N];

        for (int i = 0; i < N - 1; ++i) { // 트리이므로 (N - 1)개의 간선을 가짐
            tokens = br.readLine().split(" ");
            int start = Integer.parseInt(tokens[0]) - 1;
            int end = Integer.parseInt(tokens[1]) - 1;

            tree.get(start).add(end);
            tree.get(end).add(start);
        }

        bfs(tree, dp, 0, -1);

        for (int i = 0; i < N; ++i) {
            sb.append(dp[i] ? "donggggas" : "uppercut").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static boolean bfs(List<List<Integer>> tree, boolean[] dp, int cur, int parent) {
        // 말단 정점에서 출발하면 말단 정점이므로 0:0으로 게임이 종료되며 동점이므로 혁준이가 승리
        // 동우가 먼저 말단 정점에 도착하면 게임이 종료되므로 말단 정점이 아닌 정점에서 출발 시 동우가 승리
        // 따라서 말단 정점의 여부를 확인하면 됨
        boolean winDongwoo = false;

        for (Integer next : tree.get(cur)) {
            // 현재 정점 cur의 부모 정점이 next이면 무한 이동이 가능하므로 부모라면 이동하지 않음
            if (next == parent) continue;

            if (!bfs(tree, dp, next, cur)) {
                winDongwoo = true;
            }
        }
        dp[cur] = winDongwoo;

        return winDongwoo;
    }
}
