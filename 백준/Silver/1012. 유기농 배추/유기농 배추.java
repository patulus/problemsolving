import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1012
 * @problemTitle    유기농 배추
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i, j;
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        String[] userInput;
        int[][] field; // 배추밭
        int M = 0, N = 0; // 배추밭의 가로 길이와 세로 길이
        int K = 0; // 배추가 심어져 있는 위치의 개수
        int X = 0, Y = 0; // 배추의 위치
        int numberOfCabbageWhiteWormsNeeded; // 필요한 배추흰지렁이 마리 수

        for (; T > 0; T--) {
            userInput = br.readLine().split(" ");

            M = Integer.parseInt(userInput[0]); // 배추밭의 가로 길이
            N = Integer.parseInt(userInput[1]); // 배추밭의 세로 길이
            K = Integer.parseInt(userInput[2]); // 배추가 심어져 있는 위치의 개수

            // 배추밭 초기화
            numberOfCabbageWhiteWormsNeeded = 0;
            field = new int[N][M];
            for (i = 0; i < K; i++) {
                userInput = br.readLine().split(" ");

                X = Integer.parseInt(userInput[0]); // 배추의 가로 좌표
                Y = Integer.parseInt(userInput[1]); // 배추의 세로 좌표

                field[Y][X] = 1;
            }

            // 필요한 배추흰지렁이 마리 수 계산
            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    // 해당 위치에 배추가 있으면 인접한 배추를 탐색
                    if (field[i][j] == 1) {
                        numberOfCabbageWhiteWormsNeeded += calculateTheNumberOfCabbageWormsNeeded(field, j, i);
                    }
                }
            }

            bw.write(numberOfCabbageWhiteWormsNeeded + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }

    // 상하좌우
    private static int[] dx = {0, 0, -1, 1}; // dj
    private static int[] dy = {-1, 1, 0, 0}; // di

    private static int calculateTheNumberOfCabbageWormsNeeded(int[][] field, int x, int y) {
        Cabbage cabbage;
        int i, nx, ny;
        Queue<Cabbage> queue = new ArrayDeque<>();

        cabbage = new Cabbage(x, y);
        queue.offer(cabbage);
        field[y][x] = 2;

        while (!queue.isEmpty()) {
            cabbage = queue.poll();
            x = cabbage.getX();
            y = cabbage.getY();

            // 인접 배추 탐색
            for (i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx < 0 || nx >= field[0].length || ny < 0 || ny >= field.length) continue;
                if (field[ny][nx] != 1) continue;

                cabbage = new Cabbage(nx, ny);
                queue.offer(cabbage);
                field[ny][nx] = 2;
            }
        }

        // 인접 배추가 없으면 해당 구역이 끝났으므로 해당 구역에 배추흰지렁이를 배치
        return 1;
    }
}

class Cabbage {
    private int x, y;

    public Cabbage(int x, int y) {
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