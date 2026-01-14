import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    private static final long MOD = 1_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];
        for (int lastNum = 1; lastNum <= 9; ++lastNum) {
            dp[1][lastNum] = 1;
        }

        for (int len = 2; len <= N; ++len) {
            dp[len][0] = dp[len - 1][1] % MOD;
            dp[len][9] = dp[len - 1][8] % MOD;
            for (int lastNum = 1; lastNum <= 8; ++lastNum) {
                dp[len][lastNum] = (dp[len - 1][lastNum - 1] + dp[len - 1][lastNum + 1]) % MOD;
            }
        }

        long ans = 0;
        for (int lastNum = 0; lastNum <= 9; ++lastNum) {
            if (N == 1 && lastNum == 0) {
                continue;
            }

            ans = (ans % MOD + dp[N][lastNum] % MOD) % MOD;
        }

        bw.write(ans + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
