import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int clap = 0;
        int cur;

        for (int i = 3; i <= N; i++) {
            cur = i;
            while (cur != 0) {
                if ((cur % 10) == 3 || (cur % 10) == 6 || (cur % 10) == 9) {
                    clap++;
                }
                cur /= 10;
            }
        }

        bw.write(clap + "\n");
        bw.flush();
    }
}