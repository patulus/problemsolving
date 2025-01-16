import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   18917
 * @problemTitle    수열과 쿼리 38
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine()); // 쿼리의 개수
        String[] tokens;

        long sum = 0;
        long xor = 0;
        while (M > 0) {
            tokens = br.readLine().split(" ");

            switch (tokens[0]) {
                case "1": {
                    long value = Long.parseLong(tokens[1]);
                    sum += value;
                    xor ^= value;
                }
                    break;
                case "2": {
                    long value = Long.parseLong(tokens[1]);
                    sum -= value;
                    xor ^= value;
                }
                    break;
                case "3":
                    sb.append(sum).append("\n");
                    break;
                case "4":
                    sb.append(xor).append("\n");
                    break;
            }

            --M;
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}