import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1865
 * @problemTitle    웜홀
 */

public class Main {
    static final int INF = 100000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i;
        int TC = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        String[] userInput;

        int N, M, W;
        int S, E, T;
        List<List<int[]>> roads;
        List<List<int[]>> wormholes;
        int[] dist;
        for (; TC > 0; TC--) {
            userInput = br.readLine().split(" ");
            N = Integer.parseInt(userInput[0]); // 지점의 개수
            M = Integer.parseInt(userInput[1]); // 도로의 개수
            W = Integer.parseInt(userInput[2]); // 웜홀의 개수

            roads = new ArrayList<>();
            dist = new int[N];
            for (i = 0; i < N; i++) {
                roads.add(new ArrayList<>());
                dist[i] = INF;
            }

            for (i = 0; i < M; i++) {
                userInput = br.readLine().split(" ");
                S = Integer.parseInt(userInput[0]) - 1; // 시작 지점
                E = Integer.parseInt(userInput[1]) - 1; // 종료 지점
                T = Integer.parseInt(userInput[2]); // 이동 소요 시간

                roads.get(S).add(new int[]{ E, T });
                roads.get(E).add(new int[]{ S, T });
            }

            for (i = 0; i < W; i++) {
                userInput = br.readLine().split(" ");
                S = Integer.parseInt(userInput[0]) - 1; // 시작 지점
                E = Integer.parseInt(userInput[1]) - 1; // 도착 지점
                T = Integer.parseInt(userInput[2]); // 줄어드는 시간

                roads.get(S).add(new int[] { E, -T });
            }

            sb.append(bellmanFord(roads, dist, N) ? "YES" : "NO").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static boolean bellmanFord(List<List<int[]>> roads, int[] dist, int N) {
        int i, u;

        for (i = 0; i < N; i++) {
            for (u = 0; u < N; u++) {
                for (int[] v : roads.get(u)) {
                    if (dist[u] + v[1] < dist[v[0]]) {
                        dist[v[0]] = dist[u] + v[1];

                        // N개의 정점이 있을 때 최대 N-1개의 간선으로 최단 경로를 만들 수 있는데
                        // N-1개의 간선을 택했음에도 갱신이 일어나면
                        // N-1개의 간선만을 선택해서는 최단 경로를 찾을 수 없음
                        // 이는 시간여행 시 출발을 했을 때보다 시간이 되돌아가 있는 경우로, 계속 여행 시 엄청 과거로 돌아갈 것임
                        if (i == N-1) return true;
                    }
                }
            }
        }

        return false;
    }
}