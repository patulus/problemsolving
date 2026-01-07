import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] tokens;

        int N = Integer.parseInt(br.readLine());

        int[][] adjMat = new int[N][N];
        for (int i = 0; i < N; ++i) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                adjMat[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        for (int k = 0; k < N; ++k) {
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    if (adjMat[i][k] == 1 && adjMat[k][j] == 1) {
                        adjMat[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(adjMat[i][j]).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
