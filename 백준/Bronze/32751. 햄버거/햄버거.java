import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int S = Integer.parseInt(br.readLine());
        String[] userInput = br.readLine().split(" ");
        int[] remains = new int[4];

        remains[0] = Integer.parseInt(userInput[0]);
        remains[1] = Integer.parseInt(userInput[1]);
        remains[2] = Integer.parseInt(userInput[2]);
        remains[3] = Integer.parseInt(userInput[3]);

        byte[] burger = br.readLine().getBytes();

        bw.write(check(burger, remains) ? "Yes\n" : "No\n");

        bw.close();
        br.close();
    }

    private static boolean check(byte[] burger, int[] remains) {
        // 가장 아래쪽 재료와 가장 위쪽 재료가 빵이 아니면 맛있는 햄버거가 아닙니다.
        if (burger[0] != 'a' || burger[burger.length - 1] != 'a') return false;
        --remains[0];

        for (int i = 1; i < burger.length; ++i) {
            // 재료가 부족하면 맛있는 햄버거가 아닙니다.
            if (--remains[burger[i] - 'a'] < 0) return false;
            // 인접 재료와 같다면 맛있는 햄버거가 아닙니다.
            if (burger[i] == burger[i-1]) return false;
        }

        return true;
    }
}