import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] userInput = br.readLine().split(" ");
        int burn = Integer.parseInt(userInput[0]);
        int patty = Integer.parseInt(userInput[1]);
        int hamburger = Math.min(burn / 2, patty);
        
        bw.write(hamburger + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}