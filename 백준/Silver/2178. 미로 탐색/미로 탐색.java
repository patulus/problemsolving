import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] userInput = br.readLine().split(" ");

        int i, j;

        int N = Integer.parseInt(userInput[0]);
        int M = Integer.parseInt(userInput[1]);

        int[][] map = new int[N][M];
        int[][] visited = new int[N][M];
        for (i = 0; i < N; ++i) {
            Arrays.fill(visited[i], -1);
        }
        for (i = 0; i < N; ++i) {
            userInput = br.readLine().split("");
            for (j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(userInput[j]);
            }
        }

        bfs(map, visited);
        bw.write(visited[N-1][M-1] + "\n");
        bw.flush();
    }

    static void bfs(int[][] map, int[][] visited) {
        int i, nx, ny;
        int[] e;
        Queue<int[]> q = new LinkedList<>();

        visited[0][0] = 1;
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            e = q.poll();

            for (i = 0; i < 4; ++i) {
                nx = e[0] + dx[i];
                ny = e[1] + dy[i];

                if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
                if (map[ny][nx] == 1 && visited[ny][nx] == -1) {
                    visited[ny][nx] = visited[e[1]][e[0]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}