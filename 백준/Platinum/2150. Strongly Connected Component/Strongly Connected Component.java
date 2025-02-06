import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   2150
 * @problemTitle    Strongly Connected Component
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] tokens = br.readLine().split(" ");
        int V = Integer.parseInt(tokens[0]);
        int E = Integer.parseInt(tokens[1]);

        boolean[] visited = new boolean[V];
        List<List<Integer>> edge = new ArrayList<>();
        List<List<Integer>> revEdge = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        List<List<Integer>> sccs = new ArrayList<>();
        for (int i = 0; i < V; ++i) {
            edge.add(new ArrayList<>());
            revEdge.add(new ArrayList<>());
        }

        for (int i = 0; i < E; ++i) {
            tokens = br.readLine().split(" ");

            int start = Integer.parseInt(tokens[0]) - 1;
            int end = Integer.parseInt(tokens[1]) - 1;

            edge.get(start).add(end);
            revEdge.get(end).add(start);
        }

        for (int i = 0; i < V; ++i) {
            if (visited[i]) continue;
            graphDfs(edge, visited, stack, i);
        }

        Arrays.fill(visited, false);

        while (!stack.isEmpty()) {
            int cur = stack.remove(stack.size() - 1);
            if (visited[cur]) continue;

            List<Integer> scc = new ArrayList<>();
            revDfs(revEdge, visited, scc, cur);
            // 번호 순으로 노드 정렬
            scc.sort(Comparator.naturalOrder());
            sccs.add(scc);
        }
        // 첫 노드의 번호 순으로 강한 연결 요소 집합 정렬
        sccs.sort((l1, l2) -> l1.get(0) - l2.get(0));

        sb.append(sccs.size()).append("\n");
        for (List<Integer> list : sccs) {
            for (int node : list) {
                sb.append(node + 1).append(" ");
            }
            sb.append("-1\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static void graphDfs(List<List<Integer>> edge, boolean[] visited, List<Integer> stack, int start) {
        visited[start] = true;

        for (int next : edge.get(start)) {
            if (visited[next]) continue;

            graphDfs(edge, visited, stack, next);
        }

        stack.add(start);
    }

    private static void revDfs(List<List<Integer>> revEdge, boolean[] visited, List<Integer> scc, int start) {
        visited[start] = true;

        for (int next : revEdge.get(start)) {
            if (visited[next]) continue;

            revDfs(revEdge, visited, scc, next);
        }

        scc.add(start);
    }
}
