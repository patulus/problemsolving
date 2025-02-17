import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1463
 * @problemTitle    1로 만들기
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] table = new int[1_000_001];

        for (int i = 2; i <= N; ++i) {
            // 1을 뺀다.
            table[i] = table[i - 1] + 1;
            // 3으로 나눈다.
            if (i % 3 == 0) table[i] = Math.min(table[i], table[i / 3] + 1);
            // 2로 나눈다.
            if (i % 2 == 0) table[i] = Math.min(table[i], table[i / 2] + 1);
        }

        bw.write(table[N] + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
