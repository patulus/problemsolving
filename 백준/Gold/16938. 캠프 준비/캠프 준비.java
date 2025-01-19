import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   16938
 * @problemTitle    캠프 준비
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 기초 정보 입력
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]); // 백준이가 가진 문제의 수
        int L = Integer.parseInt(tokens[1]); // 문제 난이도의 최소 합
        int R = Integer.parseInt(tokens[2]); // 문제 난이도의 최대 합
        int X = Integer.parseInt(tokens[3]); // 문제 난이도의 최대 차이

        int S = 0; // 선택된 문제 집합
        int res = 0; // 조건에 만족하는 문제를 선택하는 방법의 수

        // 문제 난이도 입력
        int[] difficulties = new int[N];
        tokens = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            difficulties[i] = Integer.parseInt(tokens[i]);
        }

        // 모든 문제를 선택할 때까지 반복
        while (S < (1 << N)) {
            int idx = -1; // 현재 선택할 문제의 난이도 인덱스
            int tmp = S; // 문제가 선택되었는지 확인하기 위한 임시 변수

            int min = Integer.MAX_VALUE; // 가장 쉬운 난이도를 가진 문제의 난이도
            int max = 0;                 // 가장 어려운 난이도를 가진 문제의 난이도
            int sum = 0;                 // 선택된 문제의 합

            // 문제 선택
            while (tmp > 0) { // 모든 집합 원소를 탐색할 때까지 반복
                ++idx;
                // 현재 문제가 선택되지 않았으면 다음 문제를 탐색
                if ((tmp & 1) == 0) {
                    tmp >>= 1;
                    continue;
                }

                sum += difficulties[idx];
                min = Math.min(min, difficulties[idx]);
                max = Math.max(max, difficulties[idx]);

                tmp >>= 1;
            }

            // 문제 합이 최소 합 미만이거나, 최대 합 초과이면 다른 문제들을 선택
            if (L > sum || R < sum) {
                ++S;
                continue;
            }

            // 가장 쉬운 문제와 어려운 문제의 난이도 차가 입력 값보다 작으면 다른 문제들을 선택
            if (max - min < X) {
                ++S;
                continue;
            }

            // 이 방법은 문제의 조건을 만족하므로 방법의 수를 증가
            ++res;

            // 새로운 문제 조합 탐색
            ++S;
        }

        bw.write(res + "\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}