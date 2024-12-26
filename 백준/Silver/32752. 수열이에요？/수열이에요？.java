import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int L = Integer.parseInt(userInput[1]) - 1;
        int R = Integer.parseInt(userInput[2]);

        int[] nums = new int[N];
        userInput = br.readLine().split(" ");
        for (i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(userInput[i]);
        }

        Arrays.sort(nums, L, R);

        boolean isOk = false;
        for (i = 1; i < N; ++i) {
            if (nums[i - 1] > nums[i]) break;
        }
        if (i == N) isOk = true;

        bw.write(isOk ? "1\n" : "0\n");
        bw.flush();

        bw.close();
        br.close();
    }
}