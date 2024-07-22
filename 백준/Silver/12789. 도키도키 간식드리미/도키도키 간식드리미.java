import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   12789
 * @problemTitle    도키도키 간식드리미
 */

public class Main {
    public static int findMin(List<Integer> E, int start, int end) {
        int min = E.get(start);
        
        if (start < end) {
            for (int i = start + 1; i <= end; i++) {
                if (min > E.get(i))
                    min = E.get(i);
            }
        }
        
        return min;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int i;
        int N = Integer.parseInt(br.readLine());
        
        String[] userInput = br.readLine().split(" ");
        List<Integer> W = new ArrayList<>();
        for (i = 0; i < userInput.length; i++) {
            W.add(Integer.valueOf(userInput[i]));
        }
        
        Stack<Integer> T = new Stack<>();
        int now = 1;
        boolean isFailed = false;
        
        for (i = 0; i < N; i++) {
            if (isFailed) break;
            if (!T.isEmpty()) {
                // 대기열에 있는 순번이 줄 서 있는 순번보다 낮고
                while (!T.isEmpty() && T.peek() < W.get(i)) {
                    // 간식을 받을 차례이면 간식을 받고
                    if (now == T.pop()) {
                        now++;
                    // 간식을 받을 차례가 아니면 승환이는 간식을 못 받는다
                    } else {
                        isFailed = true;
                    }
                }
            }
            
            // 현재 순번을 대기열로 옮긴다
            T.push(W.get(i));
        }
        
        bw.write(!isFailed ? "Nice\n" : "Sad\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}