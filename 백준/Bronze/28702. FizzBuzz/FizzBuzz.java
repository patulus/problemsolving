import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx, i;

        String[] tokens = new String[3];
        for (idx = 0; idx < 3; ++idx) {
            tokens[idx] = br.readLine();
        }

        i = 0;
        for (idx = 0; idx < 3; ++idx) {
            try {
                i = Integer.parseInt(tokens[idx]);
            } catch (NumberFormatException e) {
                ++i;
            }
        }
        ++i;

        if (i % 15 == 0) {
            bw.write("FizzBuzz\n");
        } else {
            if (i % 3 == 0) {
                bw.write("Fizz\n");
            } else if (i % 5 == 0) {
                bw.write("Buzz\n");
            } else {
                bw.write(i + "\n");
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
