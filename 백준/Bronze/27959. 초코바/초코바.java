import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   27959
 * @problemTitle    초코바
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);

        if (100 * N - M >= 0) {
            bw.write("Yes\n");
        } else {
            bw.write("No\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}