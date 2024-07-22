import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static int gcd(int Na, int Nb) {
        if (Nb == 0) return Na;
        return gcd(Nb, Na % Nb);
    }
    
    public static int lcm(int Na, int Nb) {
        return ((Na * Nb) / gcd(Na, Nb));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] userInput = br.readLine().split(" ");
        int Na = Integer.parseInt(userInput[0]);
        int Nb = Integer.parseInt(userInput[1]);
        
        bw.write(gcd(Na, Nb) + "\n");
        bw.write(lcm(Na, Nb) + "\n");
        
        bw.close();
        br.close();
    }
}