import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   2346
 * @problemTitle    풍선 터뜨리기
 */

class Balloon {
    private int number, paperNumber;
    
    Balloon(int number, int paperNumber) {
        this.number = number;
        this.paperNumber = paperNumber;
    }
    
    public int getNumber() {
        return number;
    }
    
    public int getPaperNumber() {
        return paperNumber;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int i;
        
        int N = Integer.parseInt(br.readLine());
        String[] userInput = br.readLine().split(" ");
        
        // 큐 초기화
        Deque<Balloon> dq = new ArrayDeque<>();
        for (i = 0; i < N; i++) {
            dq.offerLast(new Balloon(i+1, Integer.parseInt(userInput[i])));
        }
        
        /*
            [1, 2, 3, 4, 5]
    
            [2, 3, 4, 5]
            [3, 4, 5, 2] ... 1
            [4, 5, 2, 3] ... 2
            
            [5, 2, 3]
            [3, 5, 2] ... 1
            [2, 3, 5] ... 2
            [5, 2, 3] ... 3
            
            [2, 3]
            [3, 2] ... 1
            
            [2]
        */
        Balloon t = dq.pollFirst();
        sb.append(t.getNumber()).append(" ");
        while (dq.size() != 1) {
            if (t.getPaperNumber() > 0) {
                for (i = 1; i < t.getPaperNumber(); i++) {
                    dq.offerLast(dq.pollFirst());
                }
            } else {
                for (i = 0; i < -t.getPaperNumber(); i++) {
                    dq.offerFirst(dq.pollLast());
                }
            }
            
            t = dq.pollFirst();
            sb.append(t.getNumber()).append(" ");
        }
        t = dq.pollFirst();
        sb.append(t.getNumber()).append("\n");
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}