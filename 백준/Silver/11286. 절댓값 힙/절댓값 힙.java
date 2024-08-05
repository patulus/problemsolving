import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   11286
 * @problemTitle    절댓값 힙
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> absHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1.compareTo(o2);
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        int userInput;
        Integer deleteKey;
        for (; N > 0; N--) {
            userInput = Integer.parseInt(br.readLine());

            if (userInput == 0) {
                deleteKey = absHeap.poll();
                sb.append(deleteKey != null ? deleteKey : 0).append("\n");
            }
            else absHeap.offer(userInput);
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}