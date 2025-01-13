import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   31908
 * @problemTitle    커플링 매치
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Map<String, List<String>> rings = new HashMap<>();
        
        String[] tokens;
        while (N > 0) {
            tokens = br.readLine().split(" ");
            if (tokens[1].equals("-")) {
                --N;
                continue;
            }
            
            rings.putIfAbsent(tokens[1], new ArrayList<>());
            rings.get(tokens[1]).add(tokens[0]);
            
            --N;
        }
        
        int cnt = 0;
        for (String key : rings.keySet()) {
            if (rings.get(key).size() == 2) {
                ++cnt;
                sb.append(rings.get(key).get(0)).append(" ").append(rings.get(key).get(1)).append("\n");
            }
        }
        sb.insert(0, "\n").insert(0, cnt);
        
        bw.write(sb.toString());
        bw.flush();
        
        br.close();
        bw.close();
    }
}