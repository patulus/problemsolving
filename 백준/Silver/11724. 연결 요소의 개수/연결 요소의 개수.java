import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   11724
 * @problemTitle    연결 요소의 개수
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;
        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int M = Integer.parseInt(userInput[1]);

        boolean[][] adjacencyMatrix = new boolean[N][N];
        boolean[] visited = new boolean[N];

        int u, v;
        for (i = 0; i < M; i++) {
            userInput = br.readLine().split(" ");

            u = Integer.parseInt(userInput[0]) - 1;
            v = Integer.parseInt(userInput[1]) - 1;

            adjacencyMatrix[u][v] = true;
            adjacencyMatrix[v][u] = true;
        }

        int areas = 0;
        for (i = 0; i < N; i++) {
            if (!visited[i]) {
                dfs(adjacencyMatrix, visited, i);
                areas++;
            }
        }

        bw.write(areas + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static void dfs(boolean[][] adjacencyMatrix, boolean[] visited, int start) {
        visited[start] = true;

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[start][i] && !visited[i]) {
                dfs(adjacencyMatrix, visited, i);
            }
        }
    }
}