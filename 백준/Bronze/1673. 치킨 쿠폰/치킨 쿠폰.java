import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1673
 * @problemTitle    치킨 쿠폰
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String userInput;
        String[] splitUserInput;
        int n, k;
        int d, c;
        
        while (true) {
            userInput = br.readLine();
            if (userInput == null || userInput.isEmpty()) break;
            
            splitUserInput = userInput.split(" ");
            
            // 가지고 있는 치킨 쿠폰의 장 수
            n = Integer.parseInt(splitUserInput[0]);
            // 치킨 쿠폰 한 장으로 교환 가능한 도장의 개수
            k = Integer.parseInt(splitUserInput[1]);
            
            // 치킨 쿠폰으로 주문 시 모을 수 있는 도장의 개수
            d = n;
            // 치킨 쿠폰으로 먹을 수 있는 마리 수
            c = n;
            // 치킨 쿠폰으로 주문 후 얻은 도장을 치킨 쿠폰으로 교환해 먹을 수 있는 마리 수
            c += d / k;
            
            while (d >= k) {
                d = d % k + d / k;
                // 다시 그 치킨 쿠폰으로 얻은 도장을 치킨 쿠폰으로 교환해 먹을 수 있는 마리 수
                c += d / k;
                // 치킨 쿠폰으로 주문했을 때 얻은 도장이
                // 치킨 쿠폰으로 교환할 수 없을 정도의 양이 될 때까지 센다
            }
            
            sb.append(c).append('\n');
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}