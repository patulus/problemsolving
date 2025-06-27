import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   11049
 * @problemTitle    행렬 곱셈 순서
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tokens = null;

        // 행렬의 개수
        int numMatrix = Integer.parseInt(br.readLine());
        // 행렬의 크기 (순서대로 곱셈을 할 수 있도록 입력이 주어짐)
        int[] matrixDegrees = new int[numMatrix + 1];
        tokens = br.readLine().split(" ");
        matrixDegrees[0] = Integer.parseInt(tokens[0]);
        for (int i = 1; i < numMatrix; ++i) {
            matrixDegrees[i] = Integer.parseInt(tokens[1]);
            tokens = br.readLine().split(" ");
        }
        matrixDegrees[numMatrix] = Integer.parseInt(tokens[1]);
        tokens = null;

        // 결과 배열 초기화
        int[][] result = new int[numMatrix + 1][numMatrix + 1];
        for (int i = 0; i < numMatrix + 1; ++i) {
            result[i][i] = 0;
        }

        for (int l = 1; l < numMatrix; ++l) {
            for (int i = 1; i < numMatrix + 1 - l; ++i) {
                int j = i + l;
                result[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    int temp = result[i][k] + result[k + 1][j] + matrixDegrees[i - 1] * matrixDegrees[k] * matrixDegrees[j];
                    result[i][j] = Math.min(result[i][j], temp);
                }
            }
        }

        bw.write(result[1][numMatrix] + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}