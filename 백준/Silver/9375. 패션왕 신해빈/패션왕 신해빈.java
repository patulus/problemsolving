import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   9375
 * @problemTitle    패션왕 신해빈
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int testCases = Integer.parseInt(br.readLine());
        int result = 1;
        
        int nApparel;
        String[] userInput;
        
        Map<String, Integer> apparels = new HashMap<>();
        
        while (testCases > 0) {
            nApparel = Integer.parseInt(br.readLine());
            
            for (; nApparel > 0; nApparel--) {
                userInput = br.readLine().split(" ");
                
                apparels.put(userInput[1], apparels.getOrDefault(userInput[1], 0) + 1);
            }
            
            /*
            hat headgear / sunglasses eyewear / turban headgear
            => headgear 2개, eyewear 1개
            [가능한 경우의 수]
            hat headgear
            sunglasses eyewear
            turban headgear
            hat headgear sunglasses eyewear
            turban headgear sunglasses eyewear
            [계산식]
            (headgear 2개 + 안 하는 경우 * eyewear 1개 + 안 하는 경우) - (둘 다 안 해서 알몸인 경우)
            3 C 1 * 2 C 1 - 1 = 3 * 2 - 1 = 5
             */
            for (int value : apparels.values()) {
                result *= (value + 1);
            }
            
            bw.write((result - 1) + "\n");
            
            result = 1;
            apparels.clear();
            testCases--;
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}