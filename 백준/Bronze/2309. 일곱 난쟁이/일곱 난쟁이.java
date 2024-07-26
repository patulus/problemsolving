import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   2309
 * @problemTitle    일곱 난쟁이
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i, j, k;

        // 키 입력 및 합산
        int totalTall = 0;
        int[] tall = new int[9];
        for (i = 0; i < 9; i++) {
            tall[i] = Integer.parseInt(br.readLine());
            totalTall += tall[i];
        }
        Arrays.sort(tall);

        // 아홉 명 중 일곱 명의 키 합이 100이 되기 위해
        // 100이 되지 않게 하는 두 명 제외
        boolean isEnd = false;
        for (i = 0; i < 9; i++) { // 한 명 선정
            if (!isEnd) {
                for (j = i + 1; j < 9; j++) { // 나머지 한 명 선정
                    if (totalTall - (tall[i] + tall[j]) == 100) { // 두 명을 제외했을 때 100이 되면 성공
                        for (k = 0; k < 9; k++) {
                            if (k == i || k == j) continue;

                            sb.append(tall[k]).append("\n");
                        }

                        isEnd = true;
                        break;
                    }
                }
            }
        }

        if (isEnd) {
            bw.write(sb.toString());
            bw.flush();
        }
        
        bw.close();
        br.close();
    }
}