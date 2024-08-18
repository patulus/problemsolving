import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   11725
 * @problemTitle    트리의 부모 찾기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i;
        String[] userInput;

        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> adjacencyList = new ArrayList<>();
        boolean[] visited = new boolean[N];
        int[] parents = new int[N];

        for (i = 0; i< N; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        int start, end;
        for (i = 0; i < N-1; i++) {
            userInput = br.readLine().split(" ");
            start = Integer.parseInt(userInput[0]) - 1;
            end = Integer.parseInt(userInput[1]) - 1;

            adjacencyList.get(start).add(end);
            adjacencyList.get(end).add(start);
        }

        dfs(adjacencyList, visited, parents, 0);

        for (i = 1; i < N; i++) {
            sb.append(parents[i] + 1).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static void dfs(List<List<Integer>> adjacencyList, boolean[] visited, int[] parents, int v) {
        visited[v] = true;

        for (int w : adjacencyList.get(v)) {
            if (!visited[w]) {
                dfs(adjacencyList, visited, parents, w);
                parents[w] = v;
            }
        }
    }
}