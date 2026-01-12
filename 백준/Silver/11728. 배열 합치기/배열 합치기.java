import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);

        // 정렬된 배열 A
        int[] A = new int[N];
        tokens = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(tokens[i]);
        }

        // 정렬된 배열 B
        int[] B = new int[M];
        tokens = br.readLine().split(" ");
        for (int i = 0; i < M; ++i) {
            B[i] = Integer.parseInt(tokens[i]);
        }

        // 두 배열이 정렬돼 있으므로 투 포인터를 활용하면,
        // 이미 정렬된 두 배열이 결합된 결과를 출력할 수 있음
        int pA = 0;
        int pB = 0;
        while (pA < N && pB < M) {
            int eA = A[pA];
            int eB = B[pB];

            if (eA <= eB) {
                sb.append(eA).append(" ");
                ++pA;
            } else {
                sb.append(eB).append(" ");
                ++pB;
            }
        }

        // 남아 있는 배열을 뒤에 붙임
        int[] R = (pA == N) ? B : A;
        int pR = (pA == N) ? pB : pA;
        for (int i = pR; i < R.length; ++i) {
            int eR = R[i];

            sb.append(eR).append(" ");
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
