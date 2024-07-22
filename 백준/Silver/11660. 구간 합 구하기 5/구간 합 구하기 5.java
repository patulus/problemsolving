import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i, j, k, l, ans;
        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int M = Integer.parseInt(userInput[1]);

        int[][] arr = new int[N + 1][N + 1];
        int[][] sum = new int[N + 1][N + 1];
        for (i = 1; i < N + 1; ++i) {
            userInput = br.readLine().split(" ");
            for (j = 1; j < N + 1; ++j) {
                arr[i][j] = Integer.parseInt(userInput[j - 1]);
            }
        }

        for (i = 1; i < N + 1; ++i) {
            for (j = 1; j < N + 1; ++j) {
                sum[i][j] = arr[i][j] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
            }
        }

        for (; M > 0; --M) {
            userInput = br.readLine().split(" ");
            i = Integer.parseInt(userInput[0]);
            j = Integer.parseInt(userInput[1]);
            k = Integer.parseInt(userInput[2]);
            l = Integer.parseInt(userInput[3]);

            ans = sum[k][l] - sum[k][j-1] - sum[i-1][l] + sum[i-1][j-1];
            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
