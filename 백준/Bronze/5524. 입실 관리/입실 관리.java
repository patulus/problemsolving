import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * BOJ#5524 입실 관리
 */
public final class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String token;

        int N = Integer.parseInt(br.readLine());
        while (N > 0) {
            token = br.readLine().toLowerCase();
            sb.append(token).append("\n");
            --N;
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}