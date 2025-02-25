import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   12784
 * @problemTitle    인하니카 공화국
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens;

        int T = Integer.parseInt(br.readLine());
        List<List<Bridge>> bridges = new ArrayList<>();
        boolean[] visited;

        while (T > 0) {
            tokens = br.readLine().split(" ");
            int N = Integer.parseInt(tokens[0]); // 섬의 개수
            int M = Integer.parseInt(tokens[1]); // 다리의 개수

            for (int i = 0; i < N; ++i) {
                bridges.add(new ArrayList<>());
            }
            visited = new boolean[N];

            for (int i = 0; i < M; ++i) {
                tokens = br.readLine().split(" ");
                int start = Integer.parseInt(tokens[0]) - 1;
                int end = Integer.parseInt(tokens[1]) - 1;
                int weight = Integer.parseInt(tokens[2]);

                bridges.get(start).add(new Bridge(end, weight));
                bridges.get(end).add(new Bridge(start, weight));
            }

            System.out.println(run(bridges, visited, N, 0, -1));

            bridges.clear();
            --T;
        }

        bw.close();
        br.close();
    }

    private static int run(List<List<Bridge>> bridges, boolean[] visited, int N, int cur, int parent) {
        if (parent != -1 && bridges.get(cur).size() == 1) {
            return bridges.get(cur).get(0).weight;
        }

        int res = 0;

        for (Bridge bridge : bridges.get(cur)) {
            if (bridge.end == parent) continue;

            if (!visited[bridge.end]) {
                visited[bridge.end] = true;
                res += Math.min(bridge.weight, run(bridges, visited, N, bridge.end, cur));
            }
        }

        return res;
    }
}

class Bridge {
    int end, weight;

    public Bridge(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("%d(%d)", end, weight);
    }
}
