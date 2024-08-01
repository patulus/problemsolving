import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1072
 * @problemTitle    게임
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInput = br.readLine().split(" ");
        double X = Integer.parseInt(userInput[0]); // 게임 횟수
        double Y = Integer.parseInt(userInput[1]); // 이긴 게임

        bw.write(minWin(X, Y) + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    public static long minWin(double X, double Y) {
        long res = -1;
        long low = 1;
        long mid = -1;
        long high = Integer.MAX_VALUE;

        long Z = (long)((Y*100/X));
        long nZ = -1;

        // 승률이 이미 99% 이상이면 100%가 될 수 없기 때문에 -1을 출력
        if (Z >= 99) {
            return -1;
        }

        while (low <= high) {
            // 형택이는 앞으로의 모든 게임에서 지지 않으므로
            // 앞으로 하는 게임은 모두 승리
            mid = (low + high) / 2; // 최소 이겨야 하는(해야 하는) 게임의 판 수

            nZ = (long)(((Y+mid)*100/(X+mid)));

            if (nZ <= Z) { // 게임을 더 한 후 승률이 현재와 같거나 낮으면 게임을 더 해야 함
                low = mid + 1;
            } else { // 게임을 더 한 후 승률이 현재보다 크면 기록하고 승률이 바뀌는 최소 판 수를 찾기
                res = mid;
                high = mid - 1;
            }
        }

        return res;
    }
}