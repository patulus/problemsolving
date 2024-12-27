import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int K = Integer.parseInt(userInput[1]);

        if (N == 1) {
            while (K-- > 0) sb.append("1 ");
        } else if (N == 2 && K == 1) {
            sb.append("1 2");
        } else {
            sb.append("-1");
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}