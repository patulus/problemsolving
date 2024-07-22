import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   7785
 * @problemTitle    회사에 있는 사람
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] userInput;
        
        int cntLog = Integer.parseInt(br.readLine());
        Set<String> logs = new HashSet<>();
        
        for (; cntLog > 0; cntLog--) {
            userInput = br.readLine().split(" ");
            
            switch (userInput[1]) {
                case "enter":
                    logs.add(userInput[0]);
                    break;
                case "leave":
                    logs.remove(userInput[0]);
                    break;
            }
        }
        
        // 로그에 남겨진 사람들의 이름을 역순으로 정렬
        List<String> names = new ArrayList<>(logs);
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        
        // 로그 중 들어온 기록만 있으면 출력
        for (cntLog = 0; cntLog < names.size(); cntLog++) {
            bw.write(names.get(cntLog));
            bw.write('\n');
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}