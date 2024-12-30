import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i = 0, j = 0;
        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int M = Integer.parseInt(userInput[1]);
        int S = Integer.parseInt(br.readLine());

        int memNum = -1, caseNum = -1;
        int[] submitted = new int[N];
        int[] deposited = new int[N];
        int[] cntAfterDeposited = new int[N];
        boolean[] forgot = new boolean[N];
        Arrays.fill(submitted, -1);
        Arrays.fill(deposited, -1);
        for (i = 0; i < M; ++i) {
            userInput = br.readLine().split(" ");
            memNum = Integer.parseInt(userInput[0]) - 1;
            caseNum = Integer.parseInt(userInput[1]);

            if (caseNum == 1) {
                deposited[memNum] = i;
            } else {
                submitted[memNum] = i;

                for (j = 0; j < N; ++j) {
                    // 본인이면 건너뜀
                    if (j == memNum) continue;
                    // 미입금 시 건너뜀
                    if (deposited[j] == -1) continue;
                    // 폼 제출 시 건너뜀
                    if (submitted[j] != -1) continue;
                    // 이미 잊은 회원이면 건너뜀
                    if (forgot[j]) continue;

                    ++cntAfterDeposited[j];

                    // 잊히기 조건에 부합 시 잊혔다고 판단
                    if (cntAfterDeposited[j] >= S) {
                        forgot[j] = true;
                    }
                }
            }
        }

        int printCnt = 0;
        for (i = 0; i < N; ++i) {
            if (!forgot[i]) continue;

            sb.append(i + 1).append("\n");
            ++printCnt;
        }
        if (printCnt == 0) sb.append("-1\n");

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
