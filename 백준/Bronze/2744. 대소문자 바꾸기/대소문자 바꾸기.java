import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        byte[] input = br.readLine().getBytes();

        int gap = 'a' - 'A';
        for (int i = 0; i < input.length; ++i) {
            if (input[i] >= 'A' && input[i] <= 'Z') {
                input[i] += gap;
            } else {
                input[i] -= gap;
            }

            sb.append((char) input[i]);
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
