import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   31854
 * @problemTitle    부등호 퍼즐
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        
        int[][] map = new int[N][N];
        
        List<List<Integer>> edge = new ArrayList<>(N * N);
        for (int i = 0; i < N * N; ++i) {
            edge.add(new ArrayList<>());
        }
        int[] indegree = new int[N * N];
        
        String[] tokens;
        
        // 가로로 인접한 격자 칸이 만족해야 하는 대소 관계
        for (int i = 0; i < N; ++i) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < N - 1; ++j) {
                int left = i * N + j;
                int right = i * N + (j + 1);
                
                if (tokens[j].charAt(0) == '<') {
                    edge.get(left).add(right);
                    ++indegree[right];
                } else {
                    edge.get(right).add(left);
                    ++indegree[left];
                }
            }
        }
        
        // 세로로 인접한 격자 칸이 만족해야 하는 대소 관계
        for (int i = 0; i < N - 1; ++i) {
            tokens = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                int top = i * N + j;
                int bottom = (i + 1) * N + j;
                
                if (tokens[j].charAt(0) == '<') {
                    edge.get(top).add(bottom);
                    ++indegree[bottom];
                } else {
                    edge.get(bottom).add(top);
                    ++indegree[top];
                }
            }
        }
        
        topologySort(map, edge, indegree, N);
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
    
    private static void topologySort(int[][] map, List<List<Integer>> edge, int[] indegree, int N) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        // 진입 차수가 0인 정점 큐에 추가
        for (int i = 0; i < N * N; ++i) {
            if (indegree[i] == 0) queue.offer(i);
        }
        
        int val = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            map[cur / N][cur % N] = val++;
            
            // 해당 정점이 처리되었으므로 해당 정점과 연결된 정점의 진입 차수 감소
            for (int e : edge.get(cur)) {
                --indegree[e];
                
                if (indegree[e] == 0) queue.offer(e);
            }
        }
    }
}
