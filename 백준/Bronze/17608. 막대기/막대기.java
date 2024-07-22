import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String userInput = br.readLine();

        int N = Integer.parseInt(userInput);
        int[] arr = new int[N];
        int i, max = -1, cnt = 0;

        for (i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (i = N - 1; i >= 0; --i) {
            if (arr[i] > max) {
                max = arr[i];
                ++cnt;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
    }
}