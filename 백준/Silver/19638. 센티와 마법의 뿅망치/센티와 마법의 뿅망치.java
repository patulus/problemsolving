import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   19638
 * @problemTitle    센티와 마법의 뿅망치
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i;
        Integer someHgiant;

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]); // 거인 나라의 인구 수
        int Hcenti = Integer.parseInt(userInput[1]); // 센티의 키
        int T = Integer.parseInt(userInput[2]); // 뿅망치 횟수 제한

        // 거인의 키
        PriorityQueue<Integer> Hgiants = new PriorityQueue<>(Comparator.reverseOrder());
        for (i = 0; i < N; i++) {
            someHgiant = Integer.valueOf(br.readLine());
            Hgiants.offer(someHgiant);
        }

        int cntHammer = 0;
        while (!Hgiants.isEmpty() && cntHammer < T) {
            // 가장 키가 큰 거인을 조회
            someHgiant = Hgiants.peek();
            // 이 거인의 키가 1보다 작거나 1이거나, 센티보다 키가 작은 경우 망치질을 그만 두기
            if (someHgiant <= 1 || someHgiant < Hcenti) break;

            // 이 거인에게 망치질
            Hgiants.poll();
            Hgiants.offer(someHgiant / 2);
            cntHammer++;
        }

        // 가장 키가 큰 거인이 센티보다 작으면 (힙에 의해 나머지도 다 작음이 보장)
        // YES와 망치질 횟수
        if (Hgiants.peek() != null && Hgiants.peek() < Hcenti) {
            sb.append("YES\n").append(cntHammer).append("\n");
        // 가장 키가 큰 거인이 센티보다 크거나 같으면 망치질이 제한되었음
        // NO와 가장 키가 큰 거인의 키
        } else {
            sb.append("NO\n").append(Hgiants.peek()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}