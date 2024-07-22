import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1966
 * @problemTitle    프린터 큐
 */

class Document {
    private int priority, docNum;
    
    Document(int priority, int docNum) {
        this.priority = priority;
        this.docNum = docNum;
    }
    
    public int getPriority() {
        return priority;
    }
    
    public int getDocNum() {
        return docNum;
    }
}

public class Main {
    // 현재 큐에서 가장 높은 우선순위를 가진 문서가 있는지 확인
    public static int getMaxPriority(Queue<Document> printerQueue) {
        int max = -1;
        
        for (Document doc : printerQueue) {
            if (max < doc.getPriority()) max = doc.getPriority();
        }
        
        return max;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        Queue<Document> printerQueue = new ArrayDeque<>();
        int i;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
        int N, M; // 문서의 개수와 인쇄 순서가 궁금한 문서의 큐에서의 위치
        
        int maxPriority = -1;
        Document doc;
        String[] userInput;
        for (; T > 0; T--) {
            userInput = br.readLine().split(" "); // 문서의 개수와 인쇄 순서가 궁금한 문서의 큐에서의 위치를 입력 받는다
            N = Integer.parseInt(userInput[0]); // 문서의 개수
            M = Integer.parseInt(userInput[1]); // 인쇄 순서가 궁금한 문서의 큐에서의 위치
            
            userInput = br.readLine().split(" "); // 문서의 중요도를 차례대로 입력 받는다
            // 프린터 큐 초기화
            for (i = 0; i < N; i++) {
                printerQueue.offer(new Document(Integer.parseInt(userInput[i]), i));
            }
            
            i = 0;
            while (!printerQueue.isEmpty()) {
                // 현재 큐에서 가장 높은 우선순위를 가진 문서 파악
                maxPriority = getMaxPriority(printerQueue);
                // 현재 큐의 가장 앞에 있는 문서를 꺼내
                doc = printerQueue.poll();
                // 중요도를 확인
                // 현재 문서보다 중요도가 높은 문서가 있으면
                if (doc.getPriority() < maxPriority) {
                    // 이 문서를 인쇄하지 않고 큐의 가장 뒤에 재배치
                    printerQueue.offer(doc);
                    continue;
                }
                // 그렇지 않으면 바로 인쇄
                i++;
                
                // 인쇄 순서가 궁금한 문서가 인쇄되면
                // 더 이상 궁금한 것이 없으므로 다음 테스트 케이스로 넘어감
                if (doc.getDocNum() == M) {
                    sb.append(i).append("\n");
                    printerQueue.clear();
                    break;
                }
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}