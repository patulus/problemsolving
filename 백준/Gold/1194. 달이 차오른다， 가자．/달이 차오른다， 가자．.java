import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   1194
 * @problemTitle    달이 차오른다, 가자.
 */
public class Main {
    private static final int NUM_OF_KEYS = 8;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String token;
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]); // 미로의 세로 크기
        int M = Integer.parseInt(tokens[1]); // 미로의 가로 크기

        Node start = null;
        char[][] map = new char[N][M];
        for (int row = 0; row < N; ++row) {
            token = br.readLine();
            for (int col = 0; col < M; ++col) {
                map[row][col] = token.charAt(col);

                if (map[row][col] == '0') {
                    start = new Node(col, row, 0, 0);
                }
            }
        }

        int cnt = bfs(map, start);

        bw.write(cnt + "\n");
        bw.flush();
        
        br.close();
        bw.close();
    }

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static int bfs(char[][] map, Node start) {
        boolean[][][] visited = new boolean[(int) Math.pow(2, NUM_OF_KEYS) + 1][map.length][map[0].length];

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start.keys][start.y][start.x] = true;

        Node curr;
        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (map[curr.y][curr.x] == '1') {
                return curr.cnt;
            }

            for (int i = 0; i < 4; ++i) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
                if (map[ny][nx] == '#') continue;

                if (map[ny][nx] >= 'A' && map[ny][nx] <= 'Z' && ((curr.keys & (1 << (map[ny][nx] - 'A'))) == 0)) continue;

                int newKeys = curr.keys;
                if (map[ny][nx] >= 'a' && map[ny][nx] <= 'z') {
                    newKeys |= (1 << (map[ny][nx] - 'a'));
                }

                if (!visited[newKeys][ny][nx]) {
                    queue.offer(new Node(nx, ny, curr.cnt + 1, newKeys));
                    visited[newKeys][ny][nx] = true;
                }
            }

        }

        return -1;
    }
}

class Node {
    int x, y;
    int cnt;
    int keys;

    public Node(int x, int y, int cnt, int keys) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.keys = keys;
    }
}