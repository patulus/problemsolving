import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int i, j;
        int cnt = N;
        int[] arr = new int[N + 1];
        for (i = 1; i <= N; ++i) {
            arr[i] = i;
        }

        while (cnt > 1) {
            // 홀수 칸의 수들을 모두 지운다
            for (i = 1; i <= N; i += 2) {
                arr[i] = 0;
                --cnt;
            }

            // 남은 수들을 왼쪽으로 모은다
            for (i = 1, j = 1; i <= N; ++i) {
                if (arr[i] != 0) {
                    arr[j++] = arr[i];
                    arr[i] = 0;
                }
            }

            N = cnt;
        }

        bw.write(arr[1] + "\n");
        bw.flush();
    }
}