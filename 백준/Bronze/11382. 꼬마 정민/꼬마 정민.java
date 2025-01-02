import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] userInput = br.readLine().split(" ");
        long sum = Long.parseLong(userInput[0]) + Long.parseLong(userInput[1]) + Long.parseLong(userInput[2]);

        bw.write(sum + "\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
