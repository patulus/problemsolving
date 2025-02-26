import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   2533
 * @problemTitle    사회망 서비스(SNS)
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens;

        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> sns = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            sns.add(new ArrayList<>());
        }

        int[][] dp = new int[N][2];

        for (int i = 0; i < N - 1; ++i) {
            tokens = br.readLine().split(" ");
            int u = Integer.parseInt(tokens[0]) - 1;
            int v = Integer.parseInt(tokens[1]) - 1;

            sns.get(u).add(v);
            sns.get(v).add(u);
        }

        dfs(sns, dp, 0, -1);

        bw.write(Math.min(dp[0][0], dp[0][1]) + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static void dfs(List<List<Integer>> sns, int[][] dp, int cur, int parent) {
        dp[cur][0] = 0; // cur이 얼리어답터가 아니면 얼리어답터 수는 0
        dp[cur][1] = 1; // cur이 얼리어답터이면 얼리어답터 수는 1

        // cur이 말단 노드이면 친구가 parent만 존재하므로 탐색 중단
        if (parent != -1 && sns.get(cur).size() == 1) {
            return;
        }

        for (Integer friend : sns.get(cur)) {
            if (friend == parent) continue; // parent -> cur를 통해 cur로 왔으나 cur -> friend(parent)이면 다음 친구를 탐색

            // 인접 노드(친구)에 대한 탐색 실시
            dfs(sns, dp, friend, cur);

            dp[cur][0] += dp[friend][1]; // cur이 얼리어답터가 아니면 친구가 얼리어답터여야 함 (그것이 얼리어답터 수니까...)
            dp[cur][1] += Math.min(dp[friend][0], dp[friend][1]); // cur이 얼리어답터이면 얼리어답터 수가 최소인 것을 선택해야 함 (그것이 출력의 목표니까...)
        }
    }
}
