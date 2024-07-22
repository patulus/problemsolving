import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1269
 * @problemTitle    대칭 차집합
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] userInput = br.readLine().split(" ");
        
        int i;
        int cnt = 0;
        int sizeSetA = Integer.parseInt(userInput[0]);
        int sizeSetB = Integer.parseInt(userInput[1]);;
        
        // setA
        userInput = br.readLine().split(" ");
        Set<Integer> setA = new HashSet<>(/*Arrays.stream(userInput).map(Integer::valueOf).toList()*/);
        for (i = 0; i < sizeSetA; i++) {
            setA.add(Integer.valueOf(userInput[i]));
            cnt++;
        }
        
        // setB
        userInput = br.readLine().split(" ");
        
        // (setA - setB) + (setB - setA)
        for (i = 0; i < sizeSetB; i++) {
            if (setA.contains(Integer.valueOf(userInput[i]))) {
                setA.remove(Integer.valueOf(userInput[i]));
                cnt--;
            } else {
                setA.add(Integer.valueOf(userInput[i]));
                cnt++;
            }
        }
        
        bw.write(cnt + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}