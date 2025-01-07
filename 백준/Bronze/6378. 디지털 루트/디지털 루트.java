import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ#6378 디지털 루트
 */
public final class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i, sum;
        byte[] token;

        while (true) {
            token = br.readLine().getBytes();
            if (token[0] == '0') break;

            sum = 0;
            for (i = 0; i < token.length; ++i) {
                sum += token[i] - '0';
            }

            sum = sumDigit(sum);
            while (sum / 10 > 0) {
                sum = sumDigit(sum);
            }

            sb.append(sum).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int sumDigit(int n) {
        int res = 0;

        while (n > 0) {
            res += n % 10;
            n /= 10;
        }

        return res;
    }
}