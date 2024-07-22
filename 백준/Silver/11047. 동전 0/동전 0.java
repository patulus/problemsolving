import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInput;
        int i, cnt = 0;

        userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int K = Integer.parseInt(userInput[1]);
        int[] coins = new int[N];

        for (i = 0; i < N; ++i) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (i = N - 1; i >= 0; --i) {
            if ((K / coins[i]) != 0) {
                cnt += K / coins[i];
                K -= coins[i] * (K / coins[i]);
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}