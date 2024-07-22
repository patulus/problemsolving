import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   25192
 * @problemTitle   인사성 밝은 곰곰이
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String userInput;
        
        Set<String> chatNameHistory = new HashSet<>();
        int cntGomgomticon = 0; // 곰곰티콘의 사용 횟수
        boolean isHi = false; // 새로운 사람이 입장했는지 여부
        
        for (; N > 0; N--) {
            userInput = br.readLine();
            
            // 새로운 사람이 입장하면 기록을 모두 지운다
            // 왜냐하면 새로운 사람이 입장한 이후 처음 채팅을 입력하는 사람은 반드시 곰곰티콘으로 인사하기 때문
            if (userInput.equals("ENTER")) {
                isHi = true;
                chatNameHistory.clear();
                continue;
            }
            
            // ENTER이 아닌, 채팅을 친 사람의 닉네임이 입력으로 들어온다면
            // 그 사람이 인사했는지를 확인하고 인사하지 않았으면 곰곰티콘 사용 횟수를 증가
            // 새로운 사람이 들어오지 않았고 그 사람이 다시 채팅을 치면 사용 횟수는 증가되지 않음
            if (!chatNameHistory.contains(userInput)) {
                chatNameHistory.add(userInput);
                cntGomgomticon++;
            }
        }
        
        bw.write(cntGomgomticon + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}