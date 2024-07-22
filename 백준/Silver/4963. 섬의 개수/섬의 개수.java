import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] userInput;

        int x, y;
        int w;
        int h;
        int cntLand;

        boolean[][] map;

        while (true) {
            userInput = br.readLine().split(" ");
            w = Integer.parseInt(userInput[0]) + 1;
            h = Integer.parseInt(userInput[1]) + 1;
            cntLand = 0;

            if (w == 1 || h == 1) break;

            map = new boolean[h][w];
            for (y = 0; y < 1; ++y) {
                for (x = 0; x < 1; ++x) {
                    map[y][x] = false;
                }
            }
            for (y = 1; y < h; ++y) {
                userInput = br.readLine().split(" ");
                for (x = 1; x < w; ++x) {
                    switch (userInput[x - 1]) {
                        case "0":
                            map[y][x] = false;
                            break;
                        case "1":
                            map[y][x] = true;
                    }
                }
            }

            for (y = 0; y < h; ++y) {
                for (x = 0; x < w; ++x) {
                    if (map[y][x]) {
                        dfs(map, x, y);
                        ++cntLand;
                    }
                }
            }
            sb.append(cntLand).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static void dfs(boolean[][] map, int x, int y) {
        map[y][x] = false;

        int nx, ny;
        for (int i = 0; i < 8; ++i) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
            if (map[ny][nx]) {
                dfs(map, nx, ny);
            }
        }
    }
}