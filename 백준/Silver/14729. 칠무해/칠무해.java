import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   14729
 * @problemTitle    칠무해
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int i;
        int N = Integer.parseInt(br.readLine()); // 학생의 수
        float[] scores = new float[N];
        for (i = 0; i < N; i++) {
            scores[i] = Float.parseFloat(br.readLine());
        }
        Arrays.sort(scores);
        
        for (i = 0; i < 7; i++) {
            sb.append(String.format("%.3f\n", scores[i]));
        }
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}