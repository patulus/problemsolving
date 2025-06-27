import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   2455
 * @problemTitle    지능형 기차
 */
public final class Main {
    private final static int NUM_OF_STATIONS = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tokens = null;

        tokens = br.readLine().split(" ");
        int person = Integer.parseInt(tokens[1]);
        int max = 0;

        for (int s = 1; s < NUM_OF_STATIONS; ++s) {
            tokens = br.readLine().split(" ");
            person += Integer.parseInt(tokens[1]) - Integer.parseInt(tokens[0]);
            max = Math.max(max, person);
        }

        bw.write(max + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
