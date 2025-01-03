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

        int r, c;

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);

        int[][] mat = new int[N][M];

        for (r = 0; r < N; ++r) {
            tokens = br.readLine().split(" ");
            for (c = 0; c < M; ++c) {
                mat[r][c] = Integer.parseInt(tokens[c]);
            }
        }
        for (r = 0; r < N; ++r) {
            tokens = br.readLine().split(" ");
            for (c = 0; c < M; ++c) {
                mat[r][c] += Integer.parseInt(tokens[c]);

                sb.append(mat[r][c]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
