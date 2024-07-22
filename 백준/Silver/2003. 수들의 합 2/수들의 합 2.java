import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] userInput = br.readLine().split(" ");

        int N = Integer.parseInt(userInput[0]);
        int M = Integer.parseInt(userInput[1]);
        userInput = br.readLine().split(" ");

        int i, j, cnt = 0, sum = 0;
        int[] arr = new int[N];
        for (i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(userInput[i]);
        }

        i = j = 0;
        while (true) {
            if (M <= sum) {
                sum -= arr[i++];
            } else {
                if (j == N) break;
                sum += arr[j++];
            }
            if (sum == M) ++cnt;
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}