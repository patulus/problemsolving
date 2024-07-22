import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int i;
        int cntOneBit;
        char[] userInput;
        
        while (true) {
            cntOneBit = 0;
            userInput = br.readLine().toCharArray();
            
            if (userInput[0] == '#') break;
            
            for (i = 0; i < userInput.length - 1; i++) {
                if (userInput[i] == '1') {
                    cntOneBit++;
                }
                
                sb.append(userInput[i]);
            }
            
            if (userInput[i] == 'e') {
                if (cntOneBit % 2 == 0) {
                    userInput[i] = '0';
                } else {
                    userInput[i] = '1';
                }
            } else {
                if (cntOneBit % 2 != 0) {
                    userInput[i] = '0';
                } else {
                    userInput[i] = '1';
                }
            }
            
            sb.append(userInput[i]);
            sb.append('\n');
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        br.close();
        bw.close();
    }
}