import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   9095
 * @problemTitle    1, 2, 3 더하기
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] table = new int[12];
        table[1] = 1;
        table[2] = 2;
        table[3] = 4;
        for (int i = 4; i < table.length; ++i) {
            table[i] = table[i - 3] + table[i - 2] + table[i - 1];
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            int n = Integer.parseInt(br.readLine());

            sb.append(table[n]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
