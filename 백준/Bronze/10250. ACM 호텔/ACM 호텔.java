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

        int T = Integer.parseInt(br.readLine()); // 반복 횟수
        String[] userInput;
        int H, W, N;
        int h, n;

        while (T > 0) {
            userInput = br.readLine().split(" "); // 띄어쓰기를 기준으로 토큰화
            H = Integer.parseInt(userInput[0]); // 층 수
            W = Integer.parseInt(userInput[1]); // 층당 방 수
            N = Integer.parseInt(userInput[2]); // 손님 번호

            h = N % H; // YY
            n = N / H + 1; // XX

            if (h == 0) {
                h = H;
                --n;
            }

            sb.append(h);

            if (calcDigit(n) < 2)
                sb.append('0');
            sb.append(n).append('\n');

            --T;
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }

    private static int calcDigit(int num) {
        int i = 0;

        while (num > 0) {
            num /= 10;
            ++i;
        }

        return i;
    }
}