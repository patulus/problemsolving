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

        int i = 0;

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];


        String[] userInput = br.readLine().split(" ");
        int minIdx = -1;
        long sum = 0;
        for (i = 0; i < N; ++i) {
            arr[i] = Long.parseLong(userInput[i]);
            sum += arr[i];
            if (minIdx == -1 || arr[minIdx] > arr[i]) minIdx = i;
        }

        if (sum < sum - arr[minIdx] + (-sum)) {
            sum = sum - arr[minIdx] + (-sum);
            arr[minIdx] = -sum;
        }

        bw.write(sum + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
