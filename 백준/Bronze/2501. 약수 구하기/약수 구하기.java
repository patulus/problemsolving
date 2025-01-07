import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * BOJ#5524 입실 관리
 */
public final class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);

        // 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<>((num1, num2) -> num2 - num1);

        for (int q = 1; q <= N; ++q) {
            // 약수가 아니면 다음 수 탐색
            if (N % q != 0) continue;

            // 약수 삽입
            pq.offer(q);

            // 공간 최적화
            while (pq.size() > K) {
                pq.poll();
            }
        }

        bw.write(pq.size() < K? "0\n" : pq.poll() + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}