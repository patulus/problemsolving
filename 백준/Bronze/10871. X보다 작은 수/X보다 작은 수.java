import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedWriter;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        String A = br.readLine();

        st = new StringTokenizer(A, " ");

        for (int i = 0; i < N; i++) {
            String token = st.nextToken();

            if (Integer.parseInt(token) < X) {
                bw.write(token);
                bw.write(" ");
            }
        }

        bw.flush();
        bw.newLine();
        bw.close();
    }
}