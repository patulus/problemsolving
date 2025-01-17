import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   24500
 * @problemTitle    blobblush
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());
        long M = 1L;

        // N == 7이면 0b111이므로 모든 비트가 1이므로 XOR 시 7보다 작을 수 밖에 없음
        // N == 8이면 0b1000이므로 모든 비트가 1이 되기 위해서는 0b0111인 7 카드를 뽑아 XOR 시 15가 되게 해야 함
        // N == 9이면 0b1001이므로 모든 비트가 1이 되기 위해서는 0b0110인 6 카드를 뽑아 XOR 시 15가 되게 해야 함
        // 뽑힌 카드의 적힌 수를 모두 XOR한 값이 최대가 되기 위해서는 N과 XOR 시 N의 0인 비트가 1이 되게 하는 카드를 뽑아야 함
        while (M < N) {
            // N 미만인 카드를 찾기 위해 비트 위치를 증가(2배)하며, 첫 번째 반복 이후 1이 나오지 않도록 1을 증가시킴
            // N == 7일 때 M == 1, M == 3 / M == 7
            // N == 9일 때 M == 1, M == 3, M == 7 / M == 15
            M = 2 * M + 1;
        }

        // M과 N이 같으면 이미 모든 비트가 1인 상태이므로 한 장의 카드와 그 값을 출력
        if (M == N) {
            sb.append("1").append("\n");
            sb.append(M).append("\n");
        // M과 N이 다르면 N이 0인 비트를 1로 채운 것이 M이므로, 채운 카드를 찾기 위해 XOR 연산으로 그 값을 출력
        // N == 9일 때 현재 M == 15이므로 XOR 연산을 통해 6을 얻을 수 있음
        } else {
            sb.append("2").append("\n");
            sb.append(M ^ N).append("\n");
            sb.append(N).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        
        br.close();
        bw.close();
    }
}