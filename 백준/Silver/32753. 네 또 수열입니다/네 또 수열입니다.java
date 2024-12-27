import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int K = Integer.parseInt(userInput[1]);

        int[] seq = new int[N*K];
        int[] res = new int[N*K];
        int[] kary = new int[N];
        Arrays.fill(kary, K);

        makeSeq(seq, kary, res, N, K, 0);
        if (res[0] != 0) {
            for (int i = 0; i < N * K; ++i) {
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            bw.write(sb.toString());
        } else {
            bw.write("-1\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }

    private static void makeSeq(int[] seq, int[] kary, int[] res, int N, int K, int idx) {
        if (idx == N * K) {
            for (int i = 0; i < res.length; ++i) {
                res[i] = seq[i];
            }
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (kary[i] <= 0) continue;

            int sum = 0;
            for (int j = 0; j < idx; ++j) {
                sum += seq[j];
            }
            if (idx < N * K - 1 && sum + (i + 1) != idx + 1) continue;

            seq[idx] = i + 1;
            --kary[i];

            makeSeq(seq, kary, res, N, K, idx + 1);

            seq[idx] = 0;
            ++kary[i];
        }
    }
}