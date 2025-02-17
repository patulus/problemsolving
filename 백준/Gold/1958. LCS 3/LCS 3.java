import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1958
 * @problemTitle    LCS 3
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = new String[3];
        for (int i = 0; i < 3; ++i) {
            s[i] = br.readLine();
        }

        int[][][] dp = new int[s[2].length()][s[1].length()][s[0].length()];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int len = dp(s, dp, 0, 0, 0);
        sb.append(len).append("\n");

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static int dp(String[] s, int[][][] dp, int i, int j, int k) {
        if (i >= s[0].length() || j >= s[1].length() || k >= s[2].length()) return 0;

        if (dp[k][j][i] != -1) return dp[k][j][i];

        dp[k][j][i] = Math.max(dp(s, dp, i + 1, j, k), Math.max(dp(s, dp, i, j + 1, k), dp(s, dp, i, j, k + 1)));

        if (s[0].charAt(i) == s[1].charAt(j) && s[1].charAt(j) == s[2].charAt(k)) {
            dp[k][j][i] = Math.max(dp[k][j][i], dp(s, dp, i + 1, j + 1, k + 1) + 1);
        }

        return dp[k][j][i];
    }
}
