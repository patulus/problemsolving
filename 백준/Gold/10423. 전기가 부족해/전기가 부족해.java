import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   10423
 * @problemTitle    전기가 부족해
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]); // 도시의 개수
        int M = Integer.parseInt(tokens[1]); // 설치 가능한 케이블의 개수
        int K = Integer.parseInt(tokens[2]); // 발전소의 개수
        
        PriorityQueue<Cable> cables = new PriorityQueue<>();
        
        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            parent[i] = i;
        }
        
        // 발전소끼리는 연결되지 않아도 같은 집합에 속하도록 설정
        tokens = br.readLine().split(" ");
        for (String s : tokens) {
            parent[Integer.parseInt(s)] = 0;
        }
        
        for (int i = 0; i < M; ++i) {
            tokens = br.readLine().split(" ");
            
            int start = Integer.parseInt(tokens[0]);  // 시작 도시
            int end = Integer.parseInt(tokens[1]);    // 종료 도시
            int weight = Integer.parseInt(tokens[2]); // 설치 비용
            
            cables.offer(new Cable(start, end, weight));
        }
        
        // Find MST using Kruskal-Algorithm
        int weight = 0;
        Cable cable;
        while (!cables.isEmpty()) {
            cable = cables.poll();
            
            if (find(parent, cable.start) == find(parent, cable.end)) continue;
            
            union(parent, cable.start, cable.end);
            
            weight += cable.weight;
        }
        
        bw.write(weight +"\n");
        bw.flush();

        bw.close();
        br.close();
    }
    
    private static void union(int[] parent, int u, int v) {
        int pu = find(parent, u);
        int pv = find(parent, v);
        
        if (pu == pv) return;
        
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

class Cable implements Comparable<Cable> {
    int start, end, weight;
    
    public Cable(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    
    @Override
    public int compareTo(Cable o) {
        return this.weight - o.weight;
    }
}