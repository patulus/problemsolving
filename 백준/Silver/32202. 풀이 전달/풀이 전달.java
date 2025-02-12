import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   32202
 * @problemTitle    풀이 전달
 */
public final class Main {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        // 1) 한 명이 현이에게 설명을 듣고 짝꿍에게 설명 전파
        // 2) 두 명이 현이에게 설명을 듣기
        int[][] dp = new int[N][2];
        dp[0][0] = 2;
        dp[0][1] = 1;

        for (int i = 1; i < N; ++i) {
            // 이전 상태에서 한 줄을 추가하는데, 그 한 줄이 1)인 경우
            dp[i][0] = (2 * ((dp[i - 1][0] + dp[i - 1][1]) % MOD)) % MOD;
            // 이전 상태에서 한 줄을 추가하는데, 그 한 줄이 2)인 경우
            dp[i][1] = dp[i - 1][0];
        }

        bw.write(((dp[N - 1][0] + dp[N - 1][1]) % MOD) + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
