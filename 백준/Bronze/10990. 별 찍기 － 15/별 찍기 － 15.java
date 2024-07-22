import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   10990
 * @problemTitle    별 찍기 - 15
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int i, j;
        int N = Integer.parseInt(br.readLine());
        
        for (i = 0; i < N; i++) {
            // 왼쪽 공백을 출력한다
            // N - i - 2번 반복됨
            for (j = 0; j < N - i - 1; j++) {
                sb.append(' ');
            }
            
            // 왼쪽 별을 출력한다
            sb.append('*');
            
            // 중앙 공백을 출력한다
            // 2 * i - 1번 반복됨
            for (j = 2 * i - 1; j > 0; j--) {
                sb.append(' ');
            }
            
            // 오른쪽 별을 출력한다
            if (i > 0) {
                sb.append('*');
            }

            sb.append('\n');
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}