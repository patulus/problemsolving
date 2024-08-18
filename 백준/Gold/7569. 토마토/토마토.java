import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   7569
 * @problemTitle    토마토
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i, j, k;

        String[] userInput = br.readLine().split(" ");
        int M = Integer.parseInt(userInput[0]); // 상자 가로 칸 수
        int N = Integer.parseInt(userInput[1]); // 상자 세로 칸 수
        int H = Integer.parseInt(userInput[2]); // 상자 개수

        // 상자 초기화
        int[][][] boxes = new int[H][N][M];
        boolean[][][] visited = new boolean[H][N][M];
        Queue<Tomato> queue = new ArrayDeque<>();
        for (i = 0; i < H; i++) {
            for (j = 0; j < N; j++) {
                userInput = br.readLine().split(" ");
                for (k = 0; k < M; k++) {
                    boxes[i][j][k] = Integer.parseInt(userInput[k]);

                    // 이미 익은 토마토이면 주변 토마토가 익도록 하기 위해 별도로 파악한다
                    if (boxes[i][j][k] == 1) {
                        queue.offer(new Tomato(i, k, j));
                    }
                }
            }
        }

        // 토마토가 익기까지 걸리는 시간을 구한다
        bw.write(howLongDoesItTakeForTomatoesToRipen(boxes, visited, queue) + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    // 위, 아래, 왼쪽, 오른쪽, 앞쪽, 뒤쪽
    private static int[] dm = {0, 0, -1, 1, 0, 0};
    private static int[] dn = {0, 0, 0, 0, 1, -1};
    private static int[] dh = {1, -1, 0, 0, 0, 0};

    private static int howLongDoesItTakeForTomatoesToRipen(int[][][] boxes, boolean[][][] visited, Queue<Tomato> queue) {
        int cnt = 0;
        int i, j, k, nm, nn, nh;
        Tomato tomato, tomatoTemp;
        while (!queue.isEmpty()) {
            tomato = queue.poll();

            for (i = 0; i < 6; i++) {
                // 주변 토마토 위치 계산
                nm = tomato.getM() + dm[i];
                nn = tomato.getN() + dn[i];
                nh = tomato.getH() + dh[i];

                if (nm < 0 || nm >= boxes[0][0].length || nn < 0 || nn >= boxes[0].length || nh < 0 || nh >= boxes.length) continue;

                // 주변 토마토가 존재하고, 아직 익지 않은 상태이면
                if (boxes[nh][nn][nm] == 0 && !visited[nh][nn][nm]) {
                    // 주변 토마토를 익게 한다
                    // 익은 토마토의 일 수에 1을 더함
                    // 처음부터 익었던 토마토 1에 주변 토마토가 익으면 2가 되고, 익기까지 걸린 시간은 1
                    // 그 다음 주변 토마토는 3이 되고, 익기까지 걸린 시간은 2
                    boxes[nh][nn][nm] = boxes[tomato.getH()][tomato.getN()][tomato.getM()] + 1;
                    tomatoTemp = new Tomato(nh, nm, nn);
                    queue.offer(tomatoTemp);
                    visited[nh][nn][nm] = true;
                }
            }
        }

        // 토마토가 익기까지 걸린 시간 계산
        int res = -1;
        for (i = 0; i < boxes.length; i++) {
            for (j = 0; j < boxes[0].length; j++) {
                for (k = 0; k < boxes[0][0].length; k++) {
                    // 익지 않은 토마토가 있으면 -1
                    if (boxes[i][j][k] == 0) return -1;
                    // 토마토가 익기까지 걸린 최종 시간 파악
                    res = Math.max(res, boxes[i][j][k]);
                }
            }
        }

        // CTRL+G | line:column 75:21
        return res - 1;
    }
}

class Tomato {
    private int h, m, n;

    public Tomato(int h, int m, int n) {
        this.h = h;
        this.m = m;
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getH() {
        return h;
    }
}