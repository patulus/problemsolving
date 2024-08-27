import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   11779
 * @problemTitle    최소비용 구하기 2
 */

public class Main {
    static final int INF = 100000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i;
        String[] userInput;

        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        int a, b, c;
        List<List<Route>> routes = new ArrayList<>();
        for (i = 0; i < n; i++) {
            routes.add(new ArrayList<>());
        }
        for (i = 0; i < m; i++) {
            userInput = br.readLine().split(" ");
            a = Integer.parseInt(userInput[0]) - 1;
            b = Integer.parseInt(userInput[1]) - 1;
            c = Integer.parseInt(userInput[2]);

            routes.get(a).add(new Route(a, b, c));
        }

        userInput = br.readLine().split(" ");
        int start = Integer.parseInt(userInput[0]) - 1;
        int end = Integer.parseInt(userInput[1]) - 1;

        int[] distances = new int[n];
        int[] minRoute = new int[n];
        for (i = 0; i < n; i++) {
            distances[i] = INF;
            minRoute[i] = -1;
        }

        calcMinRoute(routes, distances, minRoute, start);

        // 스페셜 저지가 붙은 문제는 예제 출력 외에도 다른 출력이 있을 수 있음
        List<Integer> res = new ArrayList<>();
        chkMinRoute(res, minRoute, start, end);

        sb.append(distances[end]).append("\n");
        sb.append(res.size()).append("\n");
        for (i = 0; i < res.size(); i++) {
            sb.append(res.get(i)).append(" ");
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static void calcMinRoute(List<List<Route>> routes, int[] distances, int[] minRoute, int start) {
        PriorityQueue<Route> pq = new PriorityQueue<>();
        pq.offer(new Route(start, start, 0));
        distances[start] = 0;

        Route cur;
        while (!pq.isEmpty()) {
            cur = pq.poll();

            // 해당 경로의 비용이 이전 최소 비용 경로의 비용보다 많으면 다음 경로 탐색
            if (distances[cur.end] < cur.cost) continue;

            // 갈 수 있는 도시 탐색
            for (Route route : routes.get(cur.end)) {
                // 현재 경로에서 다음 도시로 가는 비용이 이전 최소 비용 경로의 비용보다 적으면
                // 해당 경로를 다음 도시까지 가는 경로로 설정
                if (distances[cur.end] + route.cost < distances[route.end]) {
                    distances[route.end] = distances[cur.end] + route.cost;
                    minRoute[route.end] = cur.end;
                    pq.offer(new Route(route.start, route.end, distances[route.end]));
                }
            }
        }
    }

//    static void chkMinRoute(StringBuilder sb, int[] minRoute, int start, int end) {
    static void chkMinRoute(List<Integer> res, int[] minRoute, int start, int end) {
        res.add(0, end + 1);

        if (end == start) {
            return;
        }

        chkMinRoute(res, minRoute, start, minRoute[end]);
    }

    static class Route implements Comparable<Route> {
        final int start, end, cost;

        public Route(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Route o) {
            return this.cost - o.cost;
        }
    }
}