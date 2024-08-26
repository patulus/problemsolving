import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1389
 * @problemTitle    케빈 베이컨의 6단계 법칙
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i, j, k;
        String[] userInput = br.readLine().split(" ");
        final int INF = 10001;

        int N = Integer.parseInt(userInput[0]); // 유저의 수
        int M = Integer.parseInt(userInput[1]); // 친구 관계의 수

        int[][] relations = new int[N+1][N+1];
        for (i = 0; i <= N; i++) {
            for (j = 0; j <= N; j++) {
                if (i == j) {
                    relations[i][j] = 0;
                } else {
                    relations[i][j] = INF;
                }
            }
        }

        int relationA, relationB;
        for (i = 0; i < M; i++) {
            userInput = br.readLine().split(" ");
            relationA = Integer.parseInt(userInput[0]);
            relationB = Integer.parseInt(userInput[1]);

            relations[relationA][relationB] = 1;
            relations[relationB][relationA] = 1;
        }

        for (k = 1; k <= N; k++) {
            for (i = 1; i <= N; i++) {
                for (j = 1; j <= N; j++) {
                    relations[i][j] = Math.min(relations[i][j], relations[i][k] + relations[k][j]);
                }
            }
        }

        int min = INF;
        int num = -1;
        int numOfKevinBacon = 0;
        for (i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++) {
                if (relations[i][j] >= 1 && relations[i][j] < INF) {
                    numOfKevinBacon += relations[i][j];
                }
            }
            if (numOfKevinBacon < min) {
                num = i;
                min = numOfKevinBacon;
            }
            numOfKevinBacon = 0;
        }

        bw.write(num + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
