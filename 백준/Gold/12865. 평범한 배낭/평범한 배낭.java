import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   12865
 * @problemTitle    평범한 배낭
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tokens = null;

        tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]); // 물건의 개수
        int m = Integer.parseInt(tokens[1]); // 준서가 감당할 수 있는 무게 한계

        int[][] items = new int[n][2];
        for (int i = 0; i < n; ++i) {
            tokens = br.readLine().split(" ");
            items[i][0] = Integer.parseInt(tokens[0]); // 물건의 무게
            items[i][1] = Integer.parseInt(tokens[1]); // 물건의 가치
        }

        int[][] result = new int[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int w = 1; w <= m; ++w) {
                if (items[i - 1][0] > w) {
                    result[i][w] = result[i - 1][w];
                } else {
                    result[i][w] = Math.max(result[i - 1][w], result[i - 1][w - items[i - 1][0]] + items[i - 1][1]);
                }
            }
        }

        bw.write(result[n][m] + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}
