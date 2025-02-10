import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   2156
 * @problemTitle    포도주 시식
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 포도주 잔의 개수

        int[] amounts = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            amounts[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n + 1];

        bw.write(dp(amounts, dp, n) + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static int dp(int[] amounts, int[] dp, int n) {
        dp[1] = amounts[1];
        if (n == 1) return dp[1];

        dp[2] = dp[1] + amounts[2];
        if (n == 2) return dp[2];

        for (int i = 3; i <= n; ++i) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + amounts[i], dp[i - 3] + amounts[i - 1] + amounts[i]));
        }
        return dp[n];
    }
}
