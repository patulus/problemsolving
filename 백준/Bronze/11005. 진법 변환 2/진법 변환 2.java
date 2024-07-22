import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        
        String[] userInput = br.readLine().split(" ");
        
        int N = Integer.parseInt(userInput[0]);
        int B = Integer.parseInt(userInput[1]);
        List<Character> list = new ArrayList<>();
        
        while (N > 0) {
            if (N % B < 10) {
                list.add((char)(N % B + '0'));
            } else {
                list.add((char)(N % B - 10 + 'A'));
            }
            
            N /= B;
        }
        
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
        }
        sb.append("\n");
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}