import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1620
 * @problemTitle    나는야 포켓몬 마스터 이다솜
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tokens = null;

        tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]); // 도감에 수록된 포켓몬의 개수
        int M = Integer.parseInt(tokens[1]); // 맞춰야 하는 문제의 개수
        tokens = null;

        String[] idx = new String[N];
        HashMap<String, Integer> map = new HashMap<>();

        int i = 0;
        while (N > 0) {
            --N;

            String name = br.readLine();
            idx[i] = name;
            map.put(name, i++);
        }

        StringBuilder sb = new StringBuilder();
        String input = null;
        while (M > 0) {
            --M;

            input = br.readLine();
            if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
                i = Integer.parseInt(input) - 1;
                sb.append(idx[i]).append("\n");
            } else {
                sb.append(map.get(input) + 1).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}