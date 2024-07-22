import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        long J = N * M * K;
        
        char[] nums = Long.toString(J).toCharArray();
        int[] cnt = new int[10];
        
        for (int i = 0; i < nums.length; i++) {
            cnt[nums[i] - '0']++; 
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(cnt[i]);
        }
    }
}