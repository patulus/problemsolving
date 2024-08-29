import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1719
 * @problemTitle    택배
 */

public class Main {
    static final int INF = 100000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i, u, v, w;
        String[] userInput = br.readLine().split(" ");

        int n = Integer.parseInt(userInput[0]);
        int m = Integer.parseInt(userInput[1]);

        int[][] adjMat = new int[n][n];
        int[][] firstNodes = new int[n][n];
        for (u = 0; u < n; u++) {
            for (v = 0; v < n; v++) {
                if (u == v) {
                    adjMat[u][v] = 0;
                } else {
                    adjMat[u][v] = INF;
                }
                firstNodes[u][v] = -1;
            }
        }

        for (i = 0; i < m; i++) {
            userInput = br.readLine().split(" ");
            u = Integer.parseInt(userInput[0]) - 1;
            v = Integer.parseInt(userInput[1]) - 1;
            w = Integer.parseInt(userInput[2]);

            adjMat[u][v] = w;
            adjMat[v][u] = w;

            // u와 v는 인접
            firstNodes[u][v] = v;
            firstNodes[v][u] = u;
        }

        for (w = 0; w < n; w++) { // 경유 노드
            for (u = 0; u < n; u++) { // 시작 노드
                for (v = 0; v < n; v++) { // 종료 노드
                    // 시작 노드에서 종료 노드로 바로 가는 것보다 어떤 노드를 경유하는 것이 더 적은 비용이면 갱신
                    if (adjMat[u][w] + adjMat[w][v] < adjMat[u][v]) {
                        adjMat[u][v] = adjMat[u][w] + adjMat[w][v];
                        // 시작 노드에서 종료 노드로 갈 때 처음 방문하는 노드는 시작 노드에서 경유 노드로 갈 때와 동일
                        // (시작 노드 -> 경유 노드 -> 종료 노드)
                        firstNodes[u][v] = firstNodes[u][w];
                    }
                }
            }
        }

        for (u = 0; u < n; u++) {
            for (v = 0; v < n; v++) {
                if (u == v) {
                    sb.append("- ");
                } else {
                    sb.append(firstNodes[u][v] + 1).append(" ");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}