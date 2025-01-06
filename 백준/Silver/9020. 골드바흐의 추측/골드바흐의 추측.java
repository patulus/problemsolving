import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * BOJ#9020 골드바흐의 추측
 */
public final class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] primeTable = createPrimeTable(10000);

        int T = Integer.parseInt(br.readLine());
        int token, i, ta, tb, a, b, diff;

        while (T > 0) {
            token = Integer.parseInt(br.readLine());

            a = b = 0;
            diff = Integer.MAX_VALUE;

            for (i = token - 1; i >= 2; --i) {
                if (!primeTable[i]) continue;
                if (!primeTable[token - i]) continue;
                if (i + (token - i) != token) continue;

                ta = token - i;
                tb = i;
                if (diff > Math.abs(tb - ta)) {
                    a = ta;
                    b = tb;
                    diff = b - a;
                }
            }

            sb.append(a).append(" ").append(b).append("\n");

            --T;
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean[] createPrimeTable(int N) {
        boolean[] primeTable = new boolean[N + 1];
        // JVM에서 boolean 원시 타입 생성 시 false이므로 모든 원소를 true로 변경
        Arrays.fill(primeTable, true);

        // 0과 1은 소수가 아님이 자명
        primeTable[0] = primeTable[1] = false;

        // 어떤 수 N은 두 공약수 A와 B의 곱으로 표현할 수 있으며 A가 루트 N보다 크면 B는 루트 N보다 작음, B도 루트 N보다 크면 곱했을 때 N을 넘음
        for (int num = 0; num <= Math.sqrt(N); ++num) {
            // 이미 배수 확인으로 걸러진 수라면 소수가 아니므로 건너뜀
            if (!primeTable[num]) continue;

            // 해당 소수의 배수는 소수가 아니므로 제외 처리
            for (int mul = num * num; mul <= N; mul += num) {
                primeTable[mul] = false;
            }
        }

        return primeTable;
    }
}
