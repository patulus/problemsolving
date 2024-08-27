import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   4485
 * @problemTitle    녹색 옷 입은 애가 젤다지?
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i, j;
        String[] userInput;

        int T = 0;
        int N; // 동굴의 크기
        int[][] cave; // 동굴
        int[][] total; // 잃은 루피 기록
        int k;

        while ((N = Integer.parseInt(br.readLine())) != 0) {
            cave = new int[N][N];
            total = new int[N][N];
            for (i = 0; i < N; i++) {
                userInput = br.readLine().split(" ");
                for (j = 0; j < N; j++) {
                    cave[i][j] = Integer.parseInt(userInput[j]);
                    total[i][j] = Integer.MAX_VALUE;
                }
            }

            calcRupeesLost(cave, total);

            sb.append("Problem ").append(++T).append(": ").append(total[N-1][N-1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();


        bw.close();
        br.close();
    }

    // 상, 하, 좌, 우
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    static void calcRupeesLost(int[][] cave, int[][] total) {
        PriorityQueue<Loc> pq = new PriorityQueue<>();
        // 링크가 동굴의 제일 왼쪽 위에 있다.
        pq.offer(new Loc(0, 0, cave[0][0]));

        int i, nx, ny;
        Loc cur;
        while (!pq.isEmpty()) {
            // 잃은 루피가 제일 적은 경로를 이어갈 새로운 위치를 탐색
            cur = pq.poll();

            for (i = 0; i < 4; i++) {
                nx = cur.x + dx[i];
                ny = cur.y + dy[i];

                if (nx < 0 || nx >= cave.length || ny < 0 || ny >= cave.length) continue;

                // (지금까지 잃은 루피 + 해당 위치에 가면 잃는 루피)가 (이전에 탐색된 경로에서 해당 위치로 갔을 때 잃은 루피)보다 적으면
                if (cur.lostRupees + cave[ny][nx] < total[ny][nx]) {
                    // 전자의 루피로 갱신하고
                    total[ny][nx] = cur.lostRupees + cave[ny][nx];
                    // 새로운 위치를 탐색
                    pq.offer(new Loc(nx, ny, total[ny][nx]));
                }
            }
        }
    }

    static class Loc implements Comparable<Loc> {
        int x, y, lostRupees;

        public Loc(int x, int y, int lostRupees) {
            this.x = x;
            this.y = y;
            this.lostRupees = lostRupees;
        }

        @Override
        public int compareTo(Loc o) {
            // 오름차순
            return this.lostRupees - o.lostRupees;
        }
    }
}