import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.StringTokenizer;

public class Main {
    public static long factorial(int n) {
        long result = n;

        for (int i = 1; i < n; i++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        OutputStream out = System.out;
        OutputStreamWriter writer = new OutputStreamWriter(out);
        BufferedWriter bw = new BufferedWriter(writer);

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long result = 0;
        if (R == 0 || N - R == 0) {
            result = 1;
        }
        else {
            result = factorial(N) / (factorial(N - R) * factorial(R));
        }
        
        bw.write(result + "\n");
        bw.flush();
    }
}