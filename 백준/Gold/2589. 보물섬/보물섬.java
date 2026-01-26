import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String token = null;
        String[] tokens = br.readLine().split(" ");
        int row = Integer.parseInt(tokens[0]);
        int column = Integer.parseInt(tokens[1]);

        char[][] map = new char[row][column];
        for (int r = 0; r < row; ++r) {
            token = br.readLine();
            for (int c = 0; c < column; ++c) {
                map[r][c] = token.charAt(c);
            }
        }

        int max = -1;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < column; ++c) {
                if (map[r][c] == 'W') {
                    continue;
                }

                max = Math.max(max, bfs(map, r, c));
            }
        }

        bw.write(max + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static int[][] dis = new int[][] { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

    private static int bfs(char[][] map, int startRow, int startColumn) {
        Queue<Node> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[map.length][map[0].length];

        queue.offer(new Node(startRow, startColumn, 0));
        visited[startRow][startColumn] = true;

        int distance = 0;
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            int r = cur.r;
            int c = cur.c;
            distance = Math.max(distance, cur.dist);

            for (int i = 0; i < dis.length; ++i) {
                int nr = cur.r + dis[i][0];
                int nc = cur.c + dis[i][1];

                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length) {
                    continue;
                }

                if (map[nr][nc] == 'W' || visited[nr][nc]) {
                    continue;
                }

                queue.offer(new Node(nr, nc, cur.dist + 1));
                visited[nr][nc] = true;
            }
        }

        return distance;
    }

    static class Node {
        int r, c, dist;

        Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}
