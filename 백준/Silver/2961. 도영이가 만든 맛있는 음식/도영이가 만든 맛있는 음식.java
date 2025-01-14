import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   2961
 * @problemTitle    도영이가 만든 맛있는 음식
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] solutions = new int[N][2];
        int set = 1;
        int diff = Integer.MAX_VALUE;

        String[] tokens;
        for (int i = 0; i < N; ++i) {
            tokens = br.readLine().split(" ");

            int sour = Integer.parseInt(tokens[0]);
            int bitter = Integer.parseInt(tokens[1]);

            solutions[i][0] = sour;
            solutions[i][1] = bitter;
        }

        while ((set & (1 << N)) == 0) {
            int sour = 1;
            int bitter = 0;
            for (int i = 0; i < N; ++i) {
                if ((set & (1 << i)) == 0) continue;
                sour *= solutions[i][0];
                bitter += solutions[i][1];
            }
            diff = Math.min(diff, Math.abs(sour - bitter));

            ++set;
        }

        bw.write(diff + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}