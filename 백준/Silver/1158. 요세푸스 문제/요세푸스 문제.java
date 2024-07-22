import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1158
 * @problemTitle    요세푸스 문제
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int K = Integer.parseInt(userInput[1]);
        
        int i;
        Queue<Integer> josephus = new ArrayDeque<>();
        for (i = 1; i <= N; i++) {
            josephus.offer(i);
        }
        
        i = 0;
        sb.append("<");
        while (josephus.size() != 1) {
            i++;
            
            if (i % K == 0) {
                sb.append(josephus.poll()).append(", ");
                i = 0;
                continue;
            }
            
            josephus.offer(josephus.poll());
        }
        
        sb.append(josephus.poll()).append(">\n");
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}