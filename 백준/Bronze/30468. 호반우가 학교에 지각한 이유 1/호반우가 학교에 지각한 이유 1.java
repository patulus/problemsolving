import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // [0]: STR, [1]: DEX, [2]: INT, [3]: LUK, [4]: N
        String[] userInput = br.readLine().split(" ");
        
        int allSum = Integer.parseInt(userInput[0]) + Integer.parseInt(userInput[1]) + Integer.parseInt(userInput[2]) + Integer.parseInt(userInput[3]);
        int ble = 0;
        int N = Integer.parseInt(userInput[4]);
        
        while (((allSum + ble) / 4) < N) {
            ble++;
        }
        
        bw.write(ble + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}