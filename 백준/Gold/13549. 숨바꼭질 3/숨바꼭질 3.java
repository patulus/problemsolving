import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   13549
 * @problemTitle    숨바꼭질 3
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]); // 수빈이의 위치
        int K = Integer.parseInt(userInput[1]); // 동생의 위치

        int[] map = new int[Math.max(N, K) * 2 + 1];
        Arrays.fill(map, Integer.MAX_VALUE);

        int minTime = -1;
        // 동생이 수빈이 뒤에 (= 수빈이가 동생 앞에) 있으면 수빈이는 뒤로 걷기만 가능
        if (K <= N) {
            minTime = N - K;
        } else { // 동생이 수빈이 앞에 (= 수빈이가 동생 뒤에) 있으면 앞, 뒤, 순간이동 가능
            dijkstra(map, N);
            // 동생에게로 가는 최소 시간 구하기
            minTime = map[K];
        }

        bw.write(minTime + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    static void dijkstra(int[] map, int N) {
        PriorityQueue<Loc> pq = new PriorityQueue<>();

        // 초기 수빈이의 위치
        pq.offer(new Loc(N, 0));
        map[N] = 0;

        Loc cur;
        while (!pq.isEmpty()) {
            // 경과 시간이 적은 위치를 찾기
            cur = pq.poll();

            // 해당 위치에 도달한 시간이 이미 적은 경우 다른 경로를 탐색
            if (map[cur.x] < cur.time) continue;

            // 한 걸음 물러설 수 있고, 해당 위치까지 가는 시간이 더 적으면
            if (cur.x - 1 >= 0 && map[cur.x - 1] > cur.time + 1) {
                // 현재 위치에서 해당 위치까지 한 걸음 물리기
                map[cur.x - 1] = cur.time + 1;
                pq.offer(new Loc(cur.x - 1, cur.time + 1));
            }

            // 한 걸음 나아갈 수 있고, 해당 위치까지 가는 시간이 더 적으면
            if (cur.x + 1 < map.length && map[cur.x + 1] > cur.time + 1) {
                // 현재 위치에서 해당 위치까지 한 걸음 걷기
                map[cur.x + 1] = cur.time + 1;
                pq.offer(new Loc(cur.x + 1, cur.time + 1));
            }

            // 순간 이동 가능하고, 해당 위치까지 가는 시간이 더 적으면
            if (cur.x * 2 < map.length && map[cur.x * 2] > cur.time) {
                // 현재 위치에서 해당 위치까지 순간 이동
                map[cur.x * 2] = cur.time;
                pq.offer(new Loc(cur.x * 2, cur.time));
            }
        }

        // 동생이 있는 위치까지 걸린 시간은 map에 기록돼 있음
    }

    static class Loc implements Comparable<Loc> {
        int x, time;

        public Loc(int x, int time) {
            this.x = x;
            this.time = time;
        }

        @Override
        public int compareTo(Loc o) {
            // 오름차순
            return this.time - o.time;
        }
    }
}
