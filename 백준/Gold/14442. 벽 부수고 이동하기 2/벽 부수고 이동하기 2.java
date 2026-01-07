import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens;
        tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int M = Integer.parseInt(tokens[1]);
        int K = Integer.parseInt(tokens[2]);

        int[][] map = new int[N][M];
        int[][][] dist = new int[N][M][K + 1];
        for (int n = 0; n < N; ++n) {
            tokens = br.readLine().split("");
            for (int m = 0; m < M; ++m) {
                map[n][m] = Integer.parseInt(tokens[m]);
                for (int k = 0; k < K + 1; ++k) {
                    dist[n][m][k] = -1;
                }
            }
        }
        dist[0][0][0] = 1;

        int result = bfs(map, dist, N, M, K);

        bw.write(result + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static final int[] dx = { 0, 0, -1, 1 };
    private static final int[] dy = { -1, 1, 0, 0 };

    private static int bfs(int[][] map, int[][][] dist, int N, int M, int K) {
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[] { 0, 0, 0 });

        int[] element;
        while (!queue.isEmpty()) {
            element = queue.poll();

            int x = element[0];
            int y = element[1];
            int k = element[2];

            if (x == M - 1 && y == N - 1) {
                return dist[y][x][k];
            }

            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                int nk = k;
                if (map[ny][nx] == 1) {
                    if (k == K) {
                        continue;
                    }

                    nk = k + 1;
                }

                if (dist[ny][nx][nk] != -1) {
                    continue;
                }

                queue.offer(new int[] { nx, ny, nk });
                dist[ny][nx][nk] = dist[y][x][k] + 1;
            }
        }

        return -1;
    }
}
