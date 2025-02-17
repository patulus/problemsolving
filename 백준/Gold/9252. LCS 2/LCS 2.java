import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   9252
 * @problemTitle    LCS 2
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = new String[2];
        for (int i = 0; i < 2; ++i) {
            s[i] = br.readLine();
        }

        int[][] dp = new int[s[1].length()][s[0].length()];
        for (int i = 0; i < dp.length; ++i) {
            Arrays.fill(dp[i], -1);
        }

        int len = dp(s, dp, 0, 0);
        if (len <= 0) {
            sb.append("0\n");
        } else {
            sb.append(len).append("\n");
            tracking(sb, s, dp, 0, 0);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static int dp(String[] s, int[][] dp, int s1, int s2) {
        if (s1 >= s[0].length() || s2 >= s[1].length()) return 0;

        if (dp[s2][s1] != -1) return dp[s2][s1];

        dp[s2][s1] = Math.max(dp(s, dp, s1 + 1, s2), dp(s, dp, s1, s2 + 1));

        if (s[0].charAt(s1) == s[1].charAt(s2)) {
            dp[s2][s1] = Math.max(dp[s2][s1], dp(s, dp, s1 + 1, s2 + 1) + 1);
        }

        return dp[s2][s1];
    }

    private static void tracking(StringBuilder sb, String[] s, int[][] dp, int s1, int s2)
    {
        if (s1 >= s[0].length() || s2 >= s[1].length()) return;

        if (s[0].charAt(s1) == s[1].charAt(s2)) {
            sb.append(s[0].charAt(s1));
            tracking(sb, s, dp, s1 + 1, s2 + 1);
        } else {
            if (s1 + 1 < s[0].length() && s2 + 1 < s[1].length()) {
                if (dp[s2][s1 + 1] >= dp[s2 + 1][s1]) {
                    tracking(sb, s, dp, s1 + 1, s2);
                } else {
                    tracking(sb, s, dp, s1, s2 + 1);
                }
            } else if (s1 + 1 < s[0].length()) {
                tracking(sb, s, dp, s1 + 1, s2);
            } else if (s2 + 1 < s[1].length()) {
                tracking(sb, s, dp, s1, s2 + 1);
            }
        }
    }
}
