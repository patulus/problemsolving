import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   11053
 * @problemTitle    가장 긴 증가하는 부분 수열
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 수열의 크기
        String[] tokens = br.readLine().split(" ");

        int[] nums = new int[N + 1];
        for (int i = 1; i <= N; ++i) {
            nums[i] = Integer.parseInt(tokens[i - 1]);
        }

        int max = 0;
        int[] dp = new int[N + 1];

        for (int idx = 1; idx <= N; ++idx) {
            dp[idx] = 1;

            for (int sel = 1; sel < idx; ++sel) {
                if (nums[sel] < nums[idx]) {
                    dp[idx] = Math.max(dp[idx], dp[sel] + 1);
                }
            }

            max = Math.max(max, dp[idx]);
        }

        bw.write(max + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
