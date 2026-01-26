import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n];
        for (int i = 0; i < n; ++i) {
            p[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        if (n >= 1) {
            dp[0] = p[0];
        }
        if (n >= 2) {
            dp[1] = p[0] + p[1];
        }
        if (n >= 3) {
            dp[2] = Math.max(p[1] + p[2], p[0] + p[2]);
            for (int i = 3; i < n; ++i) {
                dp[i] = Math.max(dp[i - 3] + p[i - 1] + p[i], dp[i - 2] + p[i]);
            }
        }

        bw.write(dp[n - 1] + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
