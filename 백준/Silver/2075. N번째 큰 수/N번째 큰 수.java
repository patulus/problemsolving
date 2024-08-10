import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   2075
 * @problemTitle    N번째 큰 수
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i, j;
        String[] userInput;
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        for (i = 0; i < N; i++) {
            userInput = br.readLine().split(" ");
            for (j = 0; j < N; j++) {
                pq.offer(Long.parseLong(userInput[j]));
            }
        }

        // 우선순위 큐에 의해 delete 시 제일 큰 수가 나오므로
        // N번째 큰 수를 찾으려면 delete를 5번하면 됨 
        long res = -1;
        for (i = 0; i < N && !pq.isEmpty(); i++) {
            res = pq.poll();
        }

        bw.write(res + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}