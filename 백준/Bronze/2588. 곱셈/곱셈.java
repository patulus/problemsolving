import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   2588
 * @problemTitle    곱셈
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        sb.append(a * (b % 10)).append("\n");
        sb.append(a * (b / 10 % 10)).append("\n");
        sb.append(a * (b / 100 % 10)).append("\n");
        sb.append(a * b).append("\n");

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}