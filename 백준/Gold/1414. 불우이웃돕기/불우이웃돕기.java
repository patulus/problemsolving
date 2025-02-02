import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1414
 * @problemTitle    불우이웃돕기
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); // 방(컴퓨터)의 개수 (각각의 방에는 한 대의 컴퓨터만 존재)
        
        PriorityQueue<Cable> cables = new PriorityQueue<>();
        int edge = 0; // 간선 개수
        int totalLength = 0; // 가용 랜선 길이
        int usedLength = 0; // 사용 랜선 길이
        
        int[] parent = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = i;
        }
        
        String tokens;
        for (int i = 0; i < N; ++i) {
            tokens = br.readLine();
            for (int j = 0; j < N; ++j) {
                char token = tokens.charAt(j);
                if (token == '0') continue;
                
                int length;
                if (token >= 'a' && token <= 'z') {
                    length = token - 'a' + 1;
                } else {
                    length = token - 'A' + 27;
                }

                totalLength += length;
                cables.offer(new Cable(i, j, length));
            }
        }
        
        Cable cable;
        while (!cables.isEmpty()) {
            cable = cables.poll();
            
            if (find(parent, cable.start) == find(parent, cable.end)) continue;

            union(parent, cable.start, cable.end);
            usedLength += cable.length;
            ++edge;
            
            if (edge == N - 1) break;
        }
        
        if (usedLength != 0 && edge == N - 1 || N == 1) {
            bw.write((totalLength - usedLength) + "\n");
        } else {
            bw.write("-1\n");
        }
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
        
        return parent[v] = find(parent, parent[v]);
    }
}

class Cable implements Comparable<Cable> {
    int start, end, length;
    
    public Cable(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
    
    @Override
    public int compareTo(Cable o) {
        return this.length - o.length;
    }
    
    @Override
    public String toString() {
        return String.format("%d to %d (%d)", start, end, length);
    }
}
