import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        byte[] nickname = br.readLine().getBytes();
        for (int i = 0; i < n; ++i) {
            switch (nickname[i]) {
                case 'I':
                    nickname[i] = 'i';
                    break;
                case 'l':
                    nickname[i] = 'L';
                    break;
                default:
                    break;
            }

            sb.append((char)nickname[i]);
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}