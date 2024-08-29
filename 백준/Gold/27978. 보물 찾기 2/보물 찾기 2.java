import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   27978
 * @problemTitle    보물 찾기 2
 */

public class Main {
    static final int INF = 100000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInput = br.readLine().split(" ");
        int H = Integer.parseInt(userInput[0]);
        int W = Integer.parseInt(userInput[1]);

        boolean[][] map = new boolean[H][W];
        int[][] dis = new int[H][W];
        int startX = -1, startY = -1, endX = -1, endY = -1;

        String line;
        char c;
        for (int i = 0; i < H; i++) {
            line = br.readLine();
            for (int j = 0; j < W; j++) {
                c = line.charAt(j);
                if (c == '#') {
                    map[i][j] = true;
                } else if (c == 'K') {
                    startX = j;
                    startY = i;
                } else if (c == '*') {
                    endX = j;
                    endY = i;
                }
                dis[i][j] = INF;
            }
        }

        bw.write(findMinimumFuelConsumption(map, dis, startX, startY, endX, endY) + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static final int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int findMinimumFuelConsumption(boolean[][] map, int[][] dis, int startX, int startY, int endX, int endY) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[]{startX, startY, 0});
        dis[startY][startX] = 0;

        int i;
        int addFuel;

        while (!deque.isEmpty()) {
            int[] cur = deque.pollFirst();
            int x = cur[0], y = cur[1], fuel = cur[2];

            if (x == endX && y == endY) return fuel;

            for (i = 0; i < 8; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
                if (map[ny][nx]) continue;

                addFuel = (dx[i] == 1) ? 0 : 1;

                if (dis[ny][nx] > fuel + addFuel) {
                    if (dx[i] == 1) {
                        deque.offerFirst(new int[]{nx, ny, fuel});
                    } else {
                        deque.offerLast(new int[]{nx, ny, fuel + 1});
                    }
                    dis[ny][nx] = fuel + addFuel;
                }
            }
        }

        return -1;
    }
}