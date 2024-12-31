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

        int i = 0, j = 0;
        int[][] apt = new int[15][14];
        for (j = 0; j < 14; ++j) {
            apt[0][j] = j + 1;
        }
        for (i = 1; i < 15; ++i) {
            for (j = 0; j < 14; ++j) {
                if (j == 0) {
                    apt[i][j] = 1;
                    continue;
                }

                apt[i][j] = apt[i][j - 1] + apt[i - 1][j];
            }
        }

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        int n, k;
        while (T > 0) {
            k = Integer.parseInt(br.readLine()); // 층
            n = Integer.parseInt(br.readLine()) - 1; // 호

            sb.append(apt[k][n]).append("\n");

            --T;
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
