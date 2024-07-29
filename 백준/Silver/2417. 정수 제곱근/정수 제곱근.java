import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   2417
 * @problemTitle    정수 제곱근
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        bw.write(solution(n, 0, n) + "\n");

        bw.close();
        br.close();
    }

    private static long solution(long n, long start, long end) {
        long mid = 0L;
        long result = 1L;

        while (start <= end) {
            mid = (start + end) / 2;

            if (Math.pow(mid, 2) < n) {
                start = mid + 1;
            } else if (Math.pow(mid, 2) >= n) {
                result = mid;
                end = mid - 1;
            }
        }

        return result;
    }
}