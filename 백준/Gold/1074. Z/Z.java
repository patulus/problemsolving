import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int r = Integer.parseInt(tokens[1]);
        int c = Integer.parseInt(tokens[2]);

        int ans = 0;

        while (N > 0) {
            int half = 1 << (N - 1); // 블록 한 변 길이
            int block = half * half; // 블록 내부 요소 개수

            int blockNumber = 0;
            if (r < half && c < half) { // 왼쪽 상단
                blockNumber = 0;
            } else if (r < half && c >= half) { // 오른쪽 상단
                blockNumber = 1;
                c -= half;
            } else if (r >= half && c < half) { // 왼쪽 하단
                blockNumber = 2;
                r -= half;
            } else if (r >= half && c >= half) { // 오른쪽 하단
                blockNumber = 3;
                r -= half;
                c -= half;
            }

            ans += blockNumber * block;
            --N;
        }

        bw.write(ans + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
