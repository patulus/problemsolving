import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int i, j;
        
        for (i = N-1; i >= 0; i--) {
            for (j = i; j > 0; j--) {
                bw.write(' ');
            }
            for (j = N-i-1; j > 0; j--) {
                bw.write('*');
            }
            for (j = 0; j < N-i; j++) {
                bw.write('*');
            }
            bw.write('\n');
        }
        for (i = 0; i < N-1; i++) {
            for (j = 0; j <= i; j++) {
                bw.write(' ');
            }
            for (j = N-i-2; j > 0; j--) {
                bw.write('*');
            }
            for (j = 0; j < N-i-1; j++) {
                bw.write('*');
            }
            bw.write('\n');
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}