import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int Q = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < Q; i++) {
            int a = Integer.parseInt(br.readLine());
            
            if ((a & (-a)) == a)
                bw.write('1');
            else
                bw.write('0');
            
            bw.write('\n');
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}