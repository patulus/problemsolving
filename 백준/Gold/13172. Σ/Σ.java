import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ#13172 Σ
 */
public final class Main {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tokens;
        int M = Integer.parseInt(br.readLine()); // 주사위 개수
        long N = 1;
        long S = 0;
        int a, b;

        while (M > 0) {
            // 주사위 정보
            tokens = br.readLine().split(" ");
            b = Integer.parseInt(tokens[0]);
            a = Integer.parseInt(tokens[1]);

            // 통분 시 분자는 (기존 분자 * 새 분모 + 새 분자 * 기존 분모), 분모는 (기존 분모 * 새 분모)
            S = S * b + a * N;
            N *= b;

            S %= MOD;
            N %= MOD;

            --M;
        }
        
        // 분모의 역원은 a^(p-2) mod p로 구할 수 있음.
        // 문제에서 p는 1,000,000,007이므로 거듭제곱 연산을 통해 최종 결과를 구할 수 있음
        // (S * NR) mod MOD => (S mod MOD) * (NR mod MOD) mod MOD인데 S와 NR은 위에서 모듈러 연산이 이루어짐
        long ans = S * pow(N, MOD - 2) % MOD;
        bw.write(ans + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static long pow(long rt, long exp) {
        long res = 1;

        while (exp > 0) {
            if (exp % 2 != 0) res = (res * rt) % MOD;
            rt = (rt * rt) % MOD;
            exp /= 2;
        }

        return res;
    }
}
