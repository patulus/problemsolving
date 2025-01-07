import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

/**
 * BOJ#1676 팩토리얼 0의 개수
 */
public final class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String val = factorial(N).toString();

        int cnt = 0;
        for (int i = val.length() - 1; i >= 0; --i) {
            if (val.charAt(i) - '0' != 0) break;
            ++cnt;
        }

        bw.write(cnt + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static BigInteger factorial(int N) {
        long resUnder20 = 1;
        BigInteger res = BigInteger.ONE;

        int num = N;
        for (; num > 20; --num) {
            res = res.multiply(BigInteger.valueOf(num));
        }
        for (; num > 0; --num) {
            resUnder20 *= num;
        }

        res = res.multiply(BigInteger.valueOf(resUnder20));

        return res;
    }
}
