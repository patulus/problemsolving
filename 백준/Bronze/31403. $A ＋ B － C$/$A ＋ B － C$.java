import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   31403
 * @problemTitle    A+B-C
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String A = br.readLine();
        String B = br.readLine();
        String C = br.readLine();
        
        bw.write((Integer.parseInt(A) + Integer.parseInt(B) - Integer.parseInt(C)) + "\n");
        bw.write((Integer.parseInt(A.concat(B)) - Integer.parseInt(C)) + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}