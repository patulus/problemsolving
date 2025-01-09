import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   13977
 * @problemTitle    이항 계수와 쿼리
 */
public class Main {
    private static final int MOD = 1_000_000_007;
    private static final long[] factorialTable = new long[4000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        makeFactorialTable();

        String[] tokens;
        while (M > 0) {
            tokens = br.readLine().split(" ");

            int N = Integer.parseInt(tokens[0]);
            int K = Integer.parseInt(tokens[1]);

            sb.append(((factorialTable[N] % MOD) * pow((factorialTable[N - K] * factorialTable[K]), MOD - 2) % MOD) % MOD).append("\n");

            --M;
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static long pow(long a, long b) {
        long res = 1;

        while (b > 0) {
            if (b % 2 != 0) {
                res = ((res % MOD) * (a % MOD)) % MOD;
            }
            a = ((a % MOD) * (a % MOD)) % MOD;
            b /= 2;
        }

        return res;
    }

    private static void makeFactorialTable() {
        factorialTable[0] = 1;
        factorialTable[1] = 1;

        for (int i = 2; i <= 4000000; ++i) {
            factorialTable[i] = ((factorialTable[i - 1] % MOD) * (i % MOD)) % MOD;
        }
    }
}