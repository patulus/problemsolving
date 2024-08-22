import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   14888
 * @problemTitle    연산자 끼워넣기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;

        int N = Integer.parseInt(br.readLine()); // 수의 개수
        int[] nums = new int[N];

        String[] userInput = br.readLine().split(" ");
        for (i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(userInput[i]);
        }

        int[] oper = new int[4];
        int[] operUsed = new int[4];
        userInput = br.readLine().split(" "); // (수의 개수) - 1 만큼의 연산자가 주어짐
        for (i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(userInput[i]);
        }

        long[] res = new long[2];
        res[0] = -1000000001; // 최대 연산 결과
        res[1] = 1000000001; // 최소 연산 결과

        backtracking(nums, 1, oper, operUsed, nums[0], res);

        bw.write(res[0] + "\n");
        bw.write(res[1] + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static void backtracking(int[] nums, int numsIdx, int[] oper, int[] operUsed, long curRes, long[] res) {
        // 모든 항을 살펴보았다면 최솟값 및 최댓값 기록
        if (numsIdx == nums.length) {
            res[0] = Math.max(res[0], curRes);
            res[1] = Math.min(res[1], curRes);
            return;
        }

        long curResBackup = curRes;
        for (int i = 0; i < 4; i++) {
            // 연산자를 사용할 수 없으면 다음 연산자 적용
            // 연산자를 사용할 수 있으면 해당 연산자 적용
            if (oper[i] > 0 && operUsed[i] < oper[i]) {
                // 해당 연산자 적용
                operUsed[i]++;

                switch (i) {
                    case 0: // +
                        curRes += nums[numsIdx];
                        break;
                    case 1: // -
                        curRes -= nums[numsIdx];
                        break;
                    case 2: // *
                        curRes *= nums[numsIdx];
                        break;
                    case 3: // /
                        curRes /= nums[numsIdx];
                        break;
                }

                // 다음 항으로 이동
                backtracking(nums, numsIdx + 1, oper, operUsed, curRes, res);

                // 다른 연산자로 적용해보기 위해 원 상태로 복구
                operUsed[i]--;
                curRes = curResBackup;
            }
        }
    }
}