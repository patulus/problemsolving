import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   13418
 * @problemTitle    학교 탐방하기
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]); // 건물의 개수
        int M = Integer.parseInt(tokens[1]); // 도로의 개수
        
        PriorityQueue<Road> roadsGood = new PriorityQueue<>(); // 최적 경로용
        PriorityQueue<Road> roadsBad = new PriorityQueue<>(Comparator.reverseOrder()); // 최악 경로용
        
        int[] parent = new int[N + 1];
        
        Road road;
        for (int i = 0; i <= M; ++i) { // M + 1개
            tokens = br.readLine().split(" ");
            
            int start = Integer.parseInt(tokens[0]);
            int end = Integer.parseInt(tokens[1]);
            int weight = Integer.parseInt(tokens[2]) == 0 ? 1 : 0;
            
            road = new Road(start, end, weight);
            roadsGood.offer(road);
            roadsBad.offer(road);
        }
        
        // 최적 경로
        initParent(parent);
        int uphillGood = kruskal(roadsGood, parent);
        
        // 최악 경로
        initParent(parent);
        int uphillBad = kruskal(roadsBad, parent);
        
        bw.write((int) Math.abs(Math.pow(uphillBad, 2) - Math.pow(uphillGood, 2)) + "\n");
        bw.flush();
 
        bw.close();
        br.close();
    }
    
    private static void initParent(int[] parent) {
        for (int i = 0; i < parent.length; ++i) {
            parent[i] = i;
        }
    }
    
    private static int kruskal(PriorityQueue<Road> roads, int[] parent) {
        int cnt = 0;
        
        Road road;
        while (!roads.isEmpty()) {
            road = roads.poll();
            
            if (find(parent, road.start) == find(parent, road.end)) continue;
            
            union(parent, road.start, road.end);
            cnt += road.weight;
        }
        
        return cnt;
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
        int diffWeight = this.weight - o.weight;
        int diffStart = this.start - o.start;
        int diffEnd = this.end - o.end;
        
        if (diffWeight != 0) {
            return diffWeight;
        } else if (diffStart != 0) {
            return diffStart;
        }
        
        return diffEnd;
    }
}
