import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   11723
 * @problemTitle    집합
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int S = 0;

        int M = Integer.parseInt(br.readLine());
        String[] tokens;
        while (M > 0) {
            tokens = br.readLine().split(" ");

            switch (tokens[0]) {
                case "add": {
                    try {
                        int x = Integer.parseInt(tokens[1]);
                        S |= (1 << (x - 1));
                    } catch (NullPointerException ex) {
                        break;
                    }
                }
                    break;
                case "remove": {
                    try {
                        int x = Integer.parseInt(tokens[1]);
                        S &= (~(1 << (x - 1)));
                    } catch (NullPointerException ex) {
                        break;
                    }
                }
                    break;
                case "check": {
                    int x = Integer.parseInt(tokens[1]);
                    sb.append((S & (1 << (x - 1))) != 0 ? 1 : 0).append("\n");
                }
                    break;
                case "toggle": {
                    int x = Integer.parseInt(tokens[1]);
                    S ^= (1 << (x - 1));
                }
                    break;
                case "all":
                    S = (1 << (20)) - 1;
                    break;
                case "empty":
                    S = 0;
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