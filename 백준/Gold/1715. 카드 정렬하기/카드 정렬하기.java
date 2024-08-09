import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1715
 * @problemTitle    카드 정렬하기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;
        int N = Integer.parseInt(br.readLine()); // 숫자 카드 묶음의 개수
        PriorityQueue<Integer> cardPacks = new PriorityQueue<>(N);
        for (i = 0; i < N; i++) {
            cardPacks.offer(Integer.parseInt(br.readLine()));
        }

        int A, B;
        int cntCompare = 0;
        while (cardPacks.size() > 1) { // 카드 팩이 두 개 이상 있으면
            // 두 카드팩에 있는 카드 수를 확인 후
            A = cardPacks.poll();
            B = cardPacks.poll();

            // 하나로 만듦. 이때 이세계에서는 비교 횟수가 A+B
            cntCompare += A + B;

            // 하나로 만든 카드팩을 다른 카드팩과 합쳐 하나의 카드팩만 존재하도록 하기
            cardPacks.offer(A + B);
        }

        bw.write(cntCompare + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}