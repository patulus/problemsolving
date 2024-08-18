import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   2146
 * @problemTitle    다리 만들기
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i, j;
        String[] userInput;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (i = 0; i < N; i++) {
            userInput = br.readLine().split(" ");
            for (j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(userInput[j]);
            }
        }

        // 같은 섬에 다리를 놓으면 안 되므로 섬을 구분한다
        int islandNumber = 65;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    islandNumbering(map, j, i, islandNumber);
                    islandNumber++;
                }
            }
        }

        // 다리를 놓는데, 가장 짧은 다리를 찾는다
        int res = Integer.MAX_VALUE;
        for (i = 65; i < islandNumber; i++) {
            res = Math.min(res, bridgeConstructionSiteSelection(map, i));
        }
        bw.write(res + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    // 상, 하, 좌, 우
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static void islandNumbering(int[][] map, int x, int y, int islandNumber) {
        map[y][x] = islandNumber;

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
            if (map[ny][nx] != 1) continue;

            islandNumbering(map, nx, ny, islandNumber);
        }
    }

    private static int bridgeConstructionSiteSelection(int[][] map, int islandNumber) {
        int i, j;
        Queue<Area> queue = new ArrayDeque<>();
        int[][] dist = new int[map.length][map[0].length];
        // 현재 섬의 블럭 거리는 0으로, 그 나머지는 -1로 초기화
        // 현재 섬을 모두 큐에 넣는다
        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[0].length; j++) {
                dist[i][j] = -1;
                if (map[i][j] == islandNumber) {
                    dist[i][j] = 0;
                    queue.offer(new Area(j, i));
                }
            }
        }

        int nx, ny;
        Area areaTemp;
        while (!queue.isEmpty()) {
            areaTemp = queue.poll();

            for (i = 0; i < 4; i++) {
                nx = areaTemp.getX() + dx[i];
                ny = areaTemp.getY() + dy[i];

                if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
                if (map[ny][nx] == islandNumber) continue;

                // 다리를 놓을 수 있는 곳이면
                if (map[ny][nx] == 0 && dist[ny][nx] == -1) {
                    // 다리를 놓는다
                    dist[ny][nx] = dist[areaTemp.getY()][areaTemp.getX()] + 1;
                    queue.offer(new Area(nx, ny));
                // 다리를 놓으려고 봤더니 다른 섬이면
                } else if (map[ny][nx] != islandNumber && map[ny][nx] != 0) {
                    // 다리 길이를 반환
                    return dist[areaTemp.getY()][areaTemp.getX()];
                }
            }
        }

        return -1;
    }
}

class Area {
    private int x, y;

    public Area(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}