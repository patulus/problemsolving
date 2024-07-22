import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] userInput = br.readLine().split(" ");
        
        int N = Integer.parseInt(userInput[0]); // 출전 등록 번호
        StringBuilder sb = new StringBuilder();
        
        Map<String, Integer> cntWord = new HashMap<>();
        String[] originalName = userInput[1].split("");
        for (String e : originalName) {
            // 한 번만 등장하는 단어는 값이 1을 유지하며, 여러 번 등장한 단어는 값이 1을 초과함
            cntWord.put(e, cntWord.getOrDefault(e, 0) + 1);
            
            // 출전자의 영어 이름에서 알파벳이 중복되지 않도록 추출
            if (cntWord.get(e) == 1) {
                sb.append(e);
            }
        }
        
        // 버려진 문자의 총 개수에 4를 더한 값을 붙임
        int cntDuplicate = 0;
        for (String e : cntWord.keySet()) {
            if (cntWord.get(e) > 1) {
                cntDuplicate += cntWord.get(e) - 1;
            }
        }
        sb.append(cntDuplicate + 4);
        
        // 맨 앞에 출전 등록 번호에 1906을 더한 값을 붙임
        sb.insert(0, (N+1906) + "");
        
        // 문자열을 뒤집음
        sb.reverse();
        
        // 맨 앞에 smupc_를 붙임
        sb.insert(0, "smupc_");
        
        // 주어진 사람의 SMUPC NAME을 출력
        bw.write(sb.toString());
        bw.write('\n');
        bw.flush();
        
        bw.close();
        br.close();
    }
}