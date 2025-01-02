import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i;

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);

        int[] sheet = new int[N];
        tokens = br.readLine().split(" ");
        for (i = 0; i < N; i++) {
            sheet[i] = Integer.parseInt(tokens[i]);
        }

        int moves = 0;

        int left = sheet[0];
        int right = sheet[0];
        int newLeft, newRight;

        for (i = 1; i < N; i++) {
            newLeft = Math.min(left, sheet[i]);
            newRight = Math.max(right, sheet[i]);

            // 손을 움직여야 칠 수 있는 경우
            if (newRight - newLeft >= K) {
                ++moves;

                left = sheet[i];
                right = sheet[i];
            // 손을 움직이지 않고 칠 수 있는 경우
            } else {
                left = newLeft;
                right = newRight;
            }
        }

        bw.write(moves + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
