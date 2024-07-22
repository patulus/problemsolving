import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int found = 0;
        int recent = 0;
        int current = 666;

        while (found < N) {
            if (recent != current && Integer.toString(current).contains("666")) {
                found += 1;
                recent = current;
                continue;
            }

            current += 1;
        }

        bw.write(current + "\n");
        bw.flush();
    }
}