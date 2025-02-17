import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   11726
 * @problemTitle    2xn 타일링
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] table = new int[n + 1];
        table[1] = 1;
        if (n >= 2) table[2] = 2;
        if (n >= 3) table[3] = 3;

        for (int i = 4; i <= n; ++i) {
            table[i] = Math.max(table[i], (table[i - 2] % 10_007 + table[i - 1] % 10_007) % 10_007);
        }

        bw.write(table[n] + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
