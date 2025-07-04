import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   2902
 * @problemTitle    KMP는 왜 KMP일까?
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] splittedStr = br.readLine().split("-");
        StringBuilder result = new StringBuilder();

        for (String s : splittedStr) {
            result.append(s.charAt(0));
        }
        result.append("\n");

        bw.write(result.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
