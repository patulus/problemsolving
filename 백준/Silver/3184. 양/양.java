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

        String[] tokens = br.readLine().split(" ");
        int R = Integer.parseInt(tokens[0]);
        int C = Integer.parseInt(tokens[1]);

        int[][] map = new int[R][C];
        int[][] area = new int[R][C];
        for (int r = 0; r < R; ++r) {
            tokens = br.readLine().split("");
            for (int c = 0; c < C; ++c) {
                int e = -2;

                switch (tokens[c].charAt(0)) {
                    case '.':
                        e = 0;
                        break;
                    case '#':
                        e = -1;
                        break;
                    case 'o':
                        e = 1;
                        break;
                    case 'v':
                        e = 2;
                        break;
                };

                map[r][c] = e;
            }
        }

        // 같은 공간을 식별
        int curAreaNumber = 1;
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (map[r][c] == -1) {
                    continue;
                }
                if (area[r][c] != 0) {
                    continue;
                }

                findSameArea(map, area, R, C, new int[] { c, r }, curAreaNumber++);
            }
        }

        // 양과 늑대의 수를 비교
        int cntSheep = 0;
        int cntWolf = 0;
        int[][] alive = new int[curAreaNumber][2];
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                int areaNumber = area[r][c];

                if (map[r][c] == 1) {
                    ++alive[areaNumber][0];
                    ++cntSheep;
                } else if (map[r][c] == 2) {
                    ++alive[areaNumber][1];
                    ++cntWolf;
                }
            }
        }

        for (int a = 1; a < curAreaNumber; ++a) {
            if (alive[a][0] > alive[a][1]) {
                cntWolf -= alive[a][1];
            } else {
                cntSheep -= alive[a][0];
            }
        }

        bw.write(cntSheep + " " + cntWolf + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static final int[][] d = { {-1, 0}, {1, 0}, {0, 1}, {0, -1} };

    private static void findSameArea(int[][] map, int[][] area, int R, int C, int[] start, int areaNumber) {
        Queue<int[]> q = new ArrayDeque<>();
        area[start[1]][start[0]] = areaNumber;
        q.offer(start);

        int[] e;
        while (!q.isEmpty()) {
            e = q.poll();

            int x = e[0];
            int y = e[1];

            for (int i = 0; i < d.length; ++i) {
                int nx = x + d[i][0];
                int ny = y + d[i][1];

                if (nx < 0 || nx >= C || ny < 0 || ny >= R) {
                    continue;
                }

                if (map[ny][nx] == -1) {
                    continue;
                }

                if (area[ny][nx] != 0) {
                    continue;
                }

                area[ny][nx] = areaNumber;
                q.offer(new int[] { nx, ny });
            }
        }
    }
}
