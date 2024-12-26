import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i, j;
        String[] userInput = br.readLine().split(" ");

        int[] nums = new int[10];    // X    -> f(X)
        int[] numsInv = new int[10]; // f(X) -> X
        for (i = 0; i < 10; ++i) {
            j = Integer.parseInt(userInput[i]);
            nums[i] = j;
            numsInv[j] = i;
        }

        userInput = br.readLine().split(" ");
        int A = calc(numsInv, Integer.parseInt(userInput[0]));
        int B = calc(numsInv, Integer.parseInt(userInput[1]));

        bw.write(calc(nums, A+B) + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static int calc(int[] numsInv, int f) {
        int res = 0;
        int mul = 1;

        while (f > 0) {
            res += numsInv[f % 10] * mul;

            f /= 10;
            mul *= 10;
        }

        return res;
    }
}