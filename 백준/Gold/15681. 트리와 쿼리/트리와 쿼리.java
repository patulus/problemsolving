import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   15681
 * @problemTitle    트리와 쿼리
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i;
        String[] userInput = br.readLine().split(" ");

        int N = Integer.parseInt(userInput[0]); // 정점 개수
        int R = Integer.parseInt(userInput[1]) - 1; // 루트
        int Q = Integer.parseInt(userInput[2]); // 쿼리 개수

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (i = 0; i < N; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // N-1 줄에 걸쳐 간선의 정보가 주어짐
        int u, v;
        for (i = 0; i < N-1; i++) {
            userInput = br.readLine().split(" ");
            u = Integer.parseInt(userInput[0]) - 1;
            v = Integer.parseInt(userInput[1]) - 1;

            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u);
        }

        boolean[] visited = new boolean[N];
        int[] cntChildNodes = new int[N];
        // 서브 트리의 정점 개수를 센다
        cntChildNodes[R] = find(adjacencyList, visited, cntChildNodes, R);

        // 센 정점 개수를 출력
        for (i = 0; i < Q; i++) {
            sb.append(cntChildNodes[Integer.parseInt(br.readLine()) - 1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static int find(List<List<Integer>> adjacencyList, boolean[] visited, int[] cntChildNodes, int R) {
        visited[R] = true;

        // 현재 노드를 센다
        int cntVertex = 1;
        // 인접 노드를 방문
        for (int V : adjacencyList.get(R)) {
            if (!visited[V]) {
                cntVertex += find(adjacencyList, visited, cntChildNodes, V);
            }
        }
        
        // 자식 노드 개수 기록
        cntChildNodes[R] = cntVertex;

        return cntVertex;
    }
}