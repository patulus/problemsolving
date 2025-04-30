import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   33572
 * @problemTitle    자세히 보아야 예쁘다
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens;
        tokens = br.readLine().split(" ");
        long N = Long.parseLong(tokens[0]);
        long M = Long.parseLong(tokens[1]);

        long safe = 0;
        tokens = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            safe += Long.parseLong(tokens[i]) - 1L;
        }

        if (safe >= M) {
            bw.write("DIMI\n");
        } else {
            bw.write("OUT\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}
