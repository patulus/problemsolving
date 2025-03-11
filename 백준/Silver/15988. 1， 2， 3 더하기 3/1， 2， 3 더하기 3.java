import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   15988
 * @problemTitle    1, 2, 3 더하기 3
 */
public final class Main {
    private static final int N = 1_000_001;
    private static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long[] cases = new long[N];
        cases[1] = 1L;
        cases[2] = 2L;
        cases[3] = 4L;
        int filled = 4;

        int T = Integer.parseInt(br.readLine());
        while (T > 0) {
            int n = Integer.parseInt(br.readLine());
            for (; filled <= n; ++filled) {
                cases[filled] = (cases[filled - 1] + cases[filled - 2] + cases[filled - 3]) % MOD;
            }

            sb.append(cases[n]).append("\n");

            --T;
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
