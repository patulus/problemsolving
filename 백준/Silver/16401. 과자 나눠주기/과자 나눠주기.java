import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   16401
 * @problemTitle    과자 나눠주기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;

        String[] userInput = br.readLine().split(" ");
        int M = Integer.parseInt(userInput[0]); // 조카의 수
        int N = Integer.parseInt(userInput[1]); // 과자의 수
        userInput = br.readLine().split(" ");
        int[] L = new int[N]; // 과자의 길이
        for (i = 0; i < N; i++) {
            L[i] = Integer.parseInt(userInput[i]);
        }

        Arrays.sort(L); // 이분 탐색을 위한 정렬

        int min = 1; // 막대 과자 탐색 최소 길이
        int max = L[L.length-1]; // 막대 과자 탐색 최대 길이
        int cen = -1; // 중앙 값
        int res = 0; // 조카 한 명에게 줄 수 있는 막대 과자 최대 길이 (모든 조카에게 나눠줄 수 없으면 0을 출력)
        int cnt = -1; // 각각의 막대 과자를 중앙 값만큼 쪼갰을 때 총 과자의 개수

        while (min <= max) {
            cen = (min + max) / 2;

            cnt = 0;
            for (i = 0; i < L.length; i++) {
                cnt += L[i] / cen;
            }

            // 쪼갠 막대 과자의 양이 조카 수보다 적다면
            if (cnt < M) {
                // 쪼개는 길이를 줄임
                max = cen - 1;
            // 쪼갠 막대 과자의 양이 조카 수와 같거나 많으면
            } else {
                // 쪼개는 길이를 일단 기록
                res = cen;
                // 쪼개는 길이를 늘려 최대 길이를 찾음
                min = cen + 1;
            }
        }

        bw.write(res + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}