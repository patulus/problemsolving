import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   2623
 * @problemTitle    음악프로그램
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]); // 가수의 수
        int M = Integer.parseInt(tokens[1]); // 보조 PD의 수

        List<List<Integer>> edge = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            edge.add(new ArrayList<>());
        }
        int[] indegree = new int[N];

        for (int i = 0; i < M; ++i) {
            tokens = br.readLine().split(" ");

            int n = Integer.parseInt(tokens[0]); // 보조 PD가 담당한 가수의 수
            int prev = Integer.parseInt(tokens[1]) - 1;
            for (int j = 2; j <= n; ++j) {
                int cur = Integer.parseInt(tokens[j]) - 1;

                edge.get(prev).add(cur);
                ++indegree[cur];

                prev = cur;
            }
        }

        List<Integer> order = new ArrayList<>();
        topologicalSort(edge, indegree, order, N);
        if (order.size() == N) {
            for (int singer : order) {
                sb.append(singer + 1).append("\n");
            }
        } else {
            sb.append("0\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static void topologicalSort(List<List<Integer>> edge, int[] indegree, List<Integer> order, int N) {
        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; ++i) {
            if (indegree[i] == 0) queue.offer(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            order.add(cur);

            for (int next : edge.get(cur)) {
                --indegree[next];

                if (indegree[next] == 0) queue.offer(next);
            }
        }
    }
}
