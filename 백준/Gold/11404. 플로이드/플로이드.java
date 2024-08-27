import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   11404
 * @problemTitle    플로이드
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final int INF = 100000001;

        int i, j, k;
        String[] userInput;

        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수

        int a, b, c;
        int[][] routes = new int[n][n];
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i == j) {
                    routes[i][j] = 0;
                } else {
                    routes[i][j] = INF;
                }
            }
        }
        for (i = 0; i < m; i++) {
            userInput = br.readLine().split(" ");
            a = Integer.parseInt(userInput[0]) - 1; // 버스의 시작 도시
            b = Integer.parseInt(userInput[1]) - 1; // 버스의 도착 도시
            c = Integer.parseInt(userInput[2]); // 한 번 타는데 필요한 비용

            // 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있음
            // 따라서, 비용이 최소인 노선만 선택
            routes[a][b] = Math.min(routes[a][b], c);
        }

        // 시작 도시에서 도착 도시로 가는데 필요한 최소 비용
        // i번째 줄 : 시작 도시, 한 줄에서 j번째 숫자 : 도착 도시와 최소 비용
        for (k = 0; k < n; k++) { // 환승 도시
            for (i = 0; i < n; i++) { // 시작 도시
                for (j = 0; j < n; j++) { // 도착 도시
                    // 도시 i에서 도시 j로 직통보다 도시 i에서 도시 k, 도시 k에서 도시 j로 환승하며 가는 것이
                    // 비용을 절감할 수 있으면 해당 비용을 기록
                    routes[i][j] = Math.min(routes[i][j], routes[i][k] + routes[k][j]);
                }
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                sb.append(routes[i][j] != INF ? routes[i][j] : 0).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static class Bus implements Comparable<Bus> {
        int start, end, weight;

        public Bus(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Bus o) {
            return this.weight - o.weight;
        }
    }
}
