import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] userInput;
        int[] arr = new int[3];
        int heru;
        int i, j;
        int[] aus = new int[2];
        
        while (true) {
            userInput = br.readLine().split(" ");
            arr[0] = Integer.parseInt(userInput[0]);
            arr[1] = Integer.parseInt(userInput[1]);
            arr[2] = Integer.parseInt(userInput[2]);
            
            if (arr[0] + arr[1] + arr[2] == 0) break;
            
            heru = Math.max(arr[0], arr[1]);
            heru = Math.max(heru, arr[2]);
            
            j = 0;
            for (i = 0; i < 3; i++) {
                if (arr[i] != heru) {
                    aus[j++] = arr[i];
                }
            }

            bw.write((Math.pow(heru, 2) == (Math.pow(aus[0], 2) + Math.pow(aus[1], 2)) ? "right" : "wrong"));
            bw.write('\n');
        }
        
        bw.close();
        br.close();
    }
}