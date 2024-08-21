import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   15649
 * @problemTitle    N과 M (1)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]); // 1부터 N까지 자연수 중 중복 없이
        int M = Integer.parseInt(userInput[1]); // M개를 고른 수열을 모두 구하라

        int[] history = new int[M];
        dfs(sb, N, M, history, 0);

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static void dfs(StringBuilder sb, int N, int M, int[] history, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(history[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            history[depth] = i;
            dfs(sb, N, M, history, depth + 1);
        }
    }
}