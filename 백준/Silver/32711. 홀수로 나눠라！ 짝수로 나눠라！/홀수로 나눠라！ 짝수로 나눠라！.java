import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] tokens = br.readLine().split(" ");

        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        bw.write(solution(arr, N) + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(int[] arr, int N) throws IOException {
        int i;

        int sum = 0;
        int cntOdd = 0;
        for (i = 0; i < N; ++i) {
            if (arr[i] % 2 != 0) ++cntOdd;

            sum += arr[i];
        }

        /* 홀수인 경우 */
        // 홀수인 경우 홀수로 나누기 방법을 통해 한 개 이상의 집합으로 나눌 수 있음
        if (sum % 2 != 0) return 1;

        /* 짝수인 경우 */
        // 원소가 하나인 경우 짝수 개의 집합을 만들 수 없고 무조건 집합의 수가 1 즉 홀수임
        if (N == 1) return 0;

        // 홀수가 없으면 짝수로 나누기 방법을 통해 둘 이상의 집합으로 나눌 수 있음
        if (cntOdd == 0) return 1;

        // 홀수 + 홀수 = 짝수
        // 1 1 2 4 4 2 1 1은 1 1 | 2 4 | 4 2 | 1 1로 집합의 수가 짝수가 되도록 나눌 수 있음
        // 합이 짝수이면서 홀수가 4개 이상이면 집합을 만들 수 있음
        if (cntOdd >= 4) return 1;

        // 1 1 2 4 4 2은 1 1 | 2 4 4로 집합의 수가 짝수가 되도록 나눌 수 있음
        // 1 2 4 4 2 1은 짝수 개의 집합을 만들 수 없음
        // 홀수가 처음과 끝 원소 중 한 쪽에 존재하면 집합을 만들 수 있음
        if (arr[0] % 2 != 0 && arr[N - 1] % 2 == 0 || arr[0] % 2 == 0 && arr[N - 1] % 2 != 0) return 1;

        // 그 외의 경우는 집합을 만들 수 없다고 간주
        return 0;
    }
}
