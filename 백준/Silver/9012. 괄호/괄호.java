import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   9012
 * @problemTitle    괄호
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        String[] userInput;
        int i;
        
        int cnt = 0;
        boolean isCorrect;
        
        for (; T > 0; T--) {
            userInput = br.readLine().split("");
            
            for (i = 0; i < userInput.length; i++) {
                if (userInput[i].equals("(")) {
                    cnt++;
                } else {
                    if (cnt == 0) {
                        break;
                    } else {
                        cnt--;
                    }
                }
            }
            
            isCorrect = (i == userInput.length && cnt == 0);
            sb.append(isCorrect ? "YES" : "NO").append("\n");
            cnt = 0;
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}