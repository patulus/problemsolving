import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   31860
 * @problemTitle    열심히 일하는 중
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] userInput = br.readLine().split(" ");

        int i;
        int N = Integer.parseInt(userInput[0]); // 송이가 해야 하는 일
        int M = Integer.parseInt(userInput[1]); // 일을 처리한 후 현재 중요도에서 감소시킬 중요도
        int K = Integer.parseInt(userInput[2]); // 완료한 것으로 간주하는 중요도의 최댓값

        PriorityQueue<Integer> priority = new PriorityQueue<>(Comparator.reverseOrder());
        for (i = 0; i < N; i++) {
            priority.offer(Integer.parseInt(br.readLine()));
        }

        int D = 0; // 경과 일 수
        int Y = 0; // 전날 송이의 만족감
        int P = 0; // 오늘 할 일의 중요도
        int S = 0; // 오늘 송이의 만족감

        while (!priority.isEmpty()) {
            // 오늘해야 하는 일을 확인 (송이는 하루에 하나의 일만 처리할 수 있음)
            P = priority.poll();
            // 일의 중요도가 K 이하이면 완료된 일이라 간주하고 일을 처리하지 않음
            if (P <= K) continue;
            // 일을 처리할 수 있으면 경과 일 수 증가
            D++;

            // 오늘 송이의 만족감 계산 (내림[Y/2] +P)
            S = Math.floorDiv(Y, 2) + P;
            Y = S;

            priority.offer(P - M);

            sb.append(S).append("\n");
        }

        bw.write(D + "\n");
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}