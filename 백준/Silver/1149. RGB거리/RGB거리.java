import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1149
 * @problemTitle    RGB거리
 */
public final class Main {
    private static final int COLOURS = 3;
    private static final int COLOUR_RED = 0;
    private static final int COLOUR_BLUE = 1;
    private static final int COLOUR_GREEN = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] weight = new int[N][COLOURS];

        String[] tokens;
        for (int i = 0; i < N; ++i) {
            tokens = br.readLine().split(" ");

            weight[i][COLOUR_RED] = Integer.parseInt(tokens[0]);
            weight[i][COLOUR_BLUE] = Integer.parseInt(tokens[1]);
            weight[i][COLOUR_GREEN] = Integer.parseInt(tokens[2]);
        }

        int[][] dp = new int[N][COLOURS];
        dp[0][COLOUR_RED] = weight[0][COLOUR_RED];
        dp[0][COLOUR_BLUE] = weight[0][COLOUR_BLUE];
        dp[0][COLOUR_GREEN] = weight[0][COLOUR_GREEN];

        for (int i = 1; i < N; ++i) {
            // 현재 집을 빨간색으로 칠하려면 이전 집이 파란색이거나 초록색이어야 함
            dp[i][COLOUR_RED] = Math.min(dp[i - 1][COLOUR_BLUE], dp[i - 1][COLOUR_GREEN]) + weight[i][COLOUR_RED];
            // 현재 집을 파란색으로 칠하려면 이전 집이 빨간색이거나 초록색이어야 함
            dp[i][COLOUR_BLUE] = Math.min(dp[i - 1][COLOUR_RED], dp[i - 1][COLOUR_GREEN]) + weight[i][COLOUR_BLUE];
            // 현재 집을 초록색으로 칠하려면 이전 집이 빨간색이거나 파란색이어야 함
            dp[i][COLOUR_GREEN] = Math.min(dp[i - 1][COLOUR_RED], dp[i - 1][COLOUR_BLUE]) + weight[i][COLOUR_GREEN];
        }

        // 최종적으로 세 개의 비용 중 최소인 것을 선택
        bw.write(Math.min(dp[N - 1][COLOUR_RED], Math.min(dp[N - 1][COLOUR_BLUE], dp[N - 1][COLOUR_GREEN])) + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
