import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * BOJ#1929 소수 구하기
 */
public final class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tokens = br.readLine().split(" ");

        int M = Integer.parseInt(tokens[0]);
        int N = Integer.parseInt(tokens[1]);

        boolean[] primeTable = getPrimeTable(N);

        // 닫힌 구간 [M, N]에서 소수 찾기
        for (int i = M; i <= N; ++i) {
            if (primeTable[i]) {
                sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean[] getPrimeTable(int N) {
        boolean[] primeTable = new boolean[N + 1];

        // JVM이 힙 영역에 배열 생성 시 기본 false를 가지도록 하므로 true로 초기화
        Arrays.fill(primeTable, true);

        // 0과 1은 소수가 아님이 자명
        primeTable[0] = primeTable[1] = false;

        // 루트 N 이하까지 구해도 되는 것은 N이 소수가 아니면 두 개의 약수 A와 B의 곱으로 표현 가능
        // A가 루트 N보다 크면 B는 루트 N보다 작음, 만약 B도 루트 N보다 크면 A와 B의 곱은 N을 초과함 (루트 (N+1) * 루트 (N+1) = N + 1)
        for (int num = 2; num <= Math.sqrt(N); ++num) {
            // 이미 제외된 경우라면 배수 제외를 하지 않고 다음 수를 탐색
            if (!primeTable[num]) continue;

            // num의 배수는 소수가 아니므로 제외
            // num * num부터 시작하는 이유는 num * (num - 1)은 이미 이전 단계인 num - 1에서 처리되었기 때문임 (3 * 3부터 시작하는 이유는 3 * 2는 2에서 처리되었기 때문)
            for (int mul = num * num; mul <= N; mul += num) {
                primeTable[mul] = false;
            }
        }

        return primeTable;
    }
}
