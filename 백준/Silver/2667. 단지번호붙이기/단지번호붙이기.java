import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   2667
 * @problemTitle    단지번호붙이기
 */

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i, j;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        String[] userInput;
        for (i = 0; i < N; ++i) {
            userInput = br.readLine().split("");
            for (j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(userInput[j]);
            }
        }

        List<Integer> cntHome = new ArrayList<>();
        int numOfHome = 1;
        int temp;
        for (i = 0; i < N; ++i) {
            for (j = 0; j < N; ++j) {
                if (map[i][j] == 1) {
                    temp = dfs(map, j, i, ++numOfHome);
                    cntHome.add(temp);
                }
            }
        }

        Collections.sort(cntHome);

        sb.append(cntHome.size()).append("\n");
        for (int num : cntHome) {
            sb.append(num).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static final int[][] delta = { {0, -1}, {0, 1}, {-1, 0}, {1, 0} };
    private static int dfs(int[][] map, int x, int y, int numOfHome) {
        map[y][x] = numOfHome;

        int cntHome = 1;
        int nx, ny;
        for (int i = 0; i < 4; ++i) {
            nx = x + delta[i][0];
            ny = y + delta[i][1];

            if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;

            if (map[ny][nx] == 1) {
                cntHome += dfs(map, nx, ny, numOfHome);
            }
        }

        return cntHome;
    }
}