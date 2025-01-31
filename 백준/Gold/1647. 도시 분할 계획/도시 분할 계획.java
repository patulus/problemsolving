import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1647
 * @problemTitle    도시 분할 계획
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]); // 집의 개수
        int M = Integer.parseInt(tokens[1]); // 길의 개수
        
        int[] parent = new int[N + 1];
        PriorityQueue<Road> roads = new PriorityQueue<>(M);
        
        for (int i = 0; i <= N; ++i) {
            parent[i] = i;
        }
        
        for (int i = 0; i < M; ++i) {
            tokens = br.readLine().split(" ");
            
            int A = Integer.parseInt(tokens[0]); // 연결하려는 집
            int B = Integer.parseInt(tokens[1]); // 연결하려는 집
            int C = Integer.parseInt(tokens[2]); // 길의 유지비
            
            roads.offer(new Road(A, B, C));
        }
        
        int lastWeight = 0;
        
        // Find MST using Kruskal-Algorithm
        int weight = 0;
        Road curr;
        while (!roads.isEmpty()) {
            curr = roads.poll();
            
            // 이미 연결하려는 집이 연결돼 있다면 다음 도로를 탐색
            if (find(parent, curr.start) == find(parent, curr.end)) continue;
            
            union(parent, curr.start, curr.end);
            weight += curr.weight;
            
            // 최소 비용을 가지도록 마을을 두 개로 분리하기 위해 마지막 도로는 연결 해제
            lastWeight = curr.weight;
        }
        
        weight -= lastWeight;
        bw.write(weight + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
    
    private static void union(int[] parent, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);
        
        if (pu == pv) return;
        
        // 작은 번호가 집합의 부모 번호가 되도록 설정
        if (pu < pv) {
            parent[pv] = pu;
        } else {
            parent[pu] = pv;
        }
    }
    
    private static int find(int[] parent, int v) {
        if (parent[v] == v) return v;
        
        // path compression
        return parent[v] = find(parent, parent[v]);
    }
}

class Road implements Comparable<Road> {
    int start, end, weight;
    
    public Road(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Road o) {
        return this.weight - o.weight;
    }
}