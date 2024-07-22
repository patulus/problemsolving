import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int X = Integer.parseInt(userInput[1]);

        int[] arr = new int[N];
        userInput = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(userInput[i]);
        }

        int i;
        int sw = arr[0];
        for (i = 1; i < X; ++i) {
            sw += arr[i];
        }
        int maxSum = sw;
        int maxCnt = 1;

        for (i = X; i < N; ++i) {
            sw -= arr[i - X];
            sw += arr[i];

            if (sw == maxSum) ++maxCnt;
            else if (maxSum < sw) {
                maxSum = sw;
                maxCnt = 1;
            }
        }

        bw.write(maxSum == 0 ? "SAD" : maxSum + "\n" + maxCnt + "\n");
        bw.flush();
    }
}
