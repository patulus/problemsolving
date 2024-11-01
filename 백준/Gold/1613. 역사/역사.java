import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1613
 * @problemTitle    역사
 */

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] userInput = br.readLine().split(" ");
        int n = Integer.parseInt(userInput[0]);
        int k = Integer.parseInt(userInput[1]);

        // 사건의 전후 관계를 추측하기 위해 2차원 행렬을 생성하고 원소를 0으로 채운다.
        int[][] floydMat = new int[n][n];

        int start = -1, end = -1;
        while (k > 0) {
            userInput = br.readLine().split(" ");

            start = Integer.parseInt(userInput[0]) - 1;
            end = Integer.parseInt(userInput[1]) - 1;

            // 앞에 있는 사건의 번호는 -1을, 뒤에 있는 사건의 번호는 1을 원소로 가진다.
            floydMat[start][end] = -1;
            floydMat[end][start] = 1;

            --k;
        }

        floyd(floydMat, n);

        int s = Integer.parseInt(br.readLine());
        while (s > 0) {
            userInput = br.readLine().split(" ");

            start = Integer.parseInt(userInput[0]) - 1;
            end = Integer.parseInt(userInput[1]) - 1;

            sb.append(floydMat[start][end]).append('\n');

            --s;
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static void floyd(int[][] floydMat, int n) {
        for (int stopover = 0; stopover < n; ++stopover) {
            for (int start = 0; start < n; ++start) {
                for (int end = 0; end < n; ++end) {
                    // 사건A 사건B 사건C : -1
                    // 사건A 사건C 사건B : -1
                    // 사건C 사건A 사건B : -1
                    if (floydMat[start][stopover] == -1 && floydMat[stopover][end] == -1) {
                        floydMat[start][end] = -1;
                    }
                    // 사건C 사건B 사건A : 1
                    // 사건B 사건C 사건A : 1
                    // 사건B 사건A 사건C : 1
                    else if (floydMat[end][stopover] == -1 && floydMat[stopover][start] == -1) {
                        floydMat[start][end] = 1;
                    }
                    // 사건의 전후 관계를 알 수 없음 : 0
                }
            }
        }
    }
}