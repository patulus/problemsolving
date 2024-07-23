import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   1021
 * @problemTitle    회전하는 큐
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int i;
        
        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int M = Integer.parseInt(userInput[1]);
        
        // 큐 초기화
        LinkedList<Integer> dq = new LinkedList<>();
        for (i = N; i > 0; i--) {
            dq.offerFirst(i);
        }
        
        // 뽑아내려고 하는 수
        userInput = br.readLine().split(" ");
        int[] pollAry = new int[M];
        for (i = 0; i < M; i++) {
            pollAry[i] = Integer.parseInt(userInput[i]);
        }
        
        int total = 0;
        int leftCnt, rightCnt;
        for (int pollValue : pollAry) {
            leftCnt = dq.indexOf(pollValue); // 왼쪽 이동에 필요한 연산 횟수
            rightCnt = dq.size() - dq.indexOf(pollValue); // 오른쪽 이동에 필요한 연산 횟수
            
            if (leftCnt <= rightCnt) { // 두 연산 횟수 중 최소를 선택
                total += leftCnt;
                
                for (i = 0; i <= leftCnt; i++) { // 이동 및 뽑기
                    if (dq.getFirst() == pollValue) {
                        dq.pollFirst();
                    } else {
                        dq.offerLast(dq.pollFirst()); // 왼쪽으로 한 칸 이동 연산
                    }
                }
            } else {
                total += rightCnt;
                
                for (i = 0; i <= rightCnt; i++) {
                    if (dq.getFirst() == pollValue) {
                        dq.pollFirst();
                    } else {
                        dq.offerFirst(dq.pollLast()); // 오른쪽으로 한 칸 이동 연산
                    }
                }
            }
        }
        
        bw.write(total + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}