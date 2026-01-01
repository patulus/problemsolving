import java.util.*;

class Solution {
    private List<Edge> edges;
    private int[] parents;
    private int[] rank;
    
    public int solution(int n, int[][] costs) {
        edges = new ArrayList<>();
        for (int[] e : costs) {
            edges.add(new Edge(e[0], e[1], e[2]));
        }
        
        parents = new int[n];
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }
        
        rank = new int[n];
        
        int answer = kruskal();
        return answer;
    }
    
    private int kruskal() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (Edge e : edges) {
            pq.offer(e);
        }
        
        Edge e;
        int cost = 0;
        while (!pq.isEmpty()) {
            e = pq.poll();
            
            int parentStart = find(e.start);
            int parentEnd = find(e.end);
            
            if (parentStart == parentEnd) {
                continue;
            }
            
            union(e.start, e.end);
            cost += e.weight;
        }
        
        return cost;
    }
    
    private int find(int v) {
        // if (parents[v] == v) return v;
        // return parents[v] = find(parents[v]);
        
        int parentV = v;
        
        // 최상위 부모 찾기
        while (parents[parentV] != parentV) {
            parentV = parents[parentV];
        }
        
        // 경로 압축 (반복)
        while (parents[v] != parentV) {
            int temp = v;
            parents[v] = parentV;
            v = temp;
        }
        
        return parentV;
    }
    
    private void union(int u, int v) {
        // 부모 찾기
        int parentU = find(u);
        int parentV = find(v);
        
        // 합치기
        if (rank[parentU] >= rank[parentV]) {
            parents[parentV] = parentU;
            if (rank[parentU] == rank[parentV]) {
                ++rank[parentU];
            }
        } else {
            parents[parentU] = parentV;
        }
    }
    
    private static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d)", this.start, this.end, this.weight);
        }
    }
}