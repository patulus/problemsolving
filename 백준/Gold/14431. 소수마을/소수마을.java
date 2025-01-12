import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   14431
 * @problemTitle    소수마을
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] tokens = br.readLine().split(" ");
        // 시작 마을의 x, y 좌표
        int X1 = Integer.parseInt(tokens[0]);
        int Y1 = Integer.parseInt(tokens[1]);
        // 도착 마을의 x, y 좌표
        int X2 = Integer.parseInt(tokens[2]);
        int Y2 = Integer.parseInt(tokens[3]);
        
        // 경유할 수 있는 마을의 개수
        int N = Integer.parseInt(br.readLine());
        
        // 경유할 수 있는 마을 저장
        List<Village> stopovers = new ArrayList<>();
        // 시작 마을과 종료 마을 추가
        stopovers.add(new Village(X1, Y1));
        stopovers.add(new Village(X2, Y2));
        
        // 경유할 수 있는 마을 추가
        for (int i = 0; i < N; ++i) {
            tokens = br.readLine().split(" ");
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            
            stopovers.add(new Village(x, y));
        }
        
        // 시작 마을, 종료 마을, 경유할 수 있는 마을. 즉 마을과 마을 간 거리가 소수인 마을만 서로 연결
        Village u;
        Village v;
        // 각 마을의 좌표의 절댓값이 3000을 넘지 않으므로 최대 거리는 (-3000, -3000)에서 (3000, 3000)의 마을로 가는 거리임
        // 따라서 최대 거리는 Math.sqrt((3000-(-3000))**2, (3000-(-3000))**2) == 8485.28...이며 문제에서 소수점을 버림하므로 8485임
        // 8485까지의 수들이 소수인지 판별하기 위해 에라토스테네스의 체를 이용한 소수 표를 만들며 인덱스가 0부터 시작이므로 1을 더한 8486을 값으로 사용
        boolean[] primeTable = getPrimeTable(8486);
        // 인접 리스트
        Map<Village, List<Node>> adj = new HashMap<>();
        // NPE 방지
        adj.put(stopovers.get(0), new ArrayList<>());
        adj.put(stopovers.get(1), new ArrayList<>());
        
        for (int i = 0; i < stopovers.size(); ++i) {
            for (int j = 0; j < stopovers.size(); ++j) {
                if (i == j) continue;
                
                u = stopovers.get(i);
                v = stopovers.get(j);
                
                int dis = calcDistance(u.x, u.y, v.x, v.y);
                // 거리가 소수가 아니면 다음 마을을 탐색
                if (!primeTable[dis]) continue;
                
                // 소수이면
                if (!adj.containsKey(stopovers.get(i))) {
                    adj.put(stopovers.get(i), new ArrayList<>());
                }
                adj.get(stopovers.get(i)).add(new Node(stopovers.get(j), dis));
            }
        }
        
        int dis = dijkstra(adj, stopovers.get(0), stopovers.get(1));
        bw.write((dis != Integer.MAX_VALUE ? dis : "-1") + "\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
    
    private static int dijkstra(Map<Village, List<Node>> adj, Village start, Village end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        Map<Village, Integer> distances = new HashMap<>();
        for (Village u : adj.keySet()) {
            distances.put(u, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        
        Node node;
        while (!pq.isEmpty()) {
            // 현재 마을에서 가장 거리가 작은 마을을 확인
            node = pq.poll();
            
            // 현재 마을에서 해당 마을로 가는 경로가 최소 경로인지 확인
            for (Node adjNode : adj.get(node.village)) {
                // 현재 마을을 거쳐 해당 마을로 가는 경로가 지금까지 찾은 해당 마을로 가는 경로보다 최소이면 갱신
                if (distances.get(node.village) + adjNode.d < distances.get(adjNode.village)) {
                    distances.put(adjNode.village, distances.get(node.village) + adjNode.d);
                    pq.offer(new Node(adjNode.village, distances.get(adjNode.village)));
                }
            }
        }

        return distances.get(end);
    }
    
    private static boolean[] getPrimeTable(int N) {
        boolean[] primeTable = new boolean[N + 1];
        Arrays.fill(primeTable, true);
        
        // 0과 1은 소수가 아님이 자명함
        primeTable[0] = primeTable[1] = false;
        // 어떤 수 n은 n의 약수 a와 b로 이루어져 있어 a가 sqrt(n) 이상이면 b는 sqrt(n) 이하이므로 sqrt(n)까지 구하면 됨
        for (int num = 2; num <= Math.sqrt(N); ++num) {
            // 이미 소수로 판별된 수는 굳이 그 배수를 소수가 아니라고 할 필요가 없으며
            // 그 배수들도 이미 이전 수에 의해 제외되었음
            if (!primeTable[num]) continue;
            // num이 5일때 5 * 5부터 시작하는 이유는 5 * 2는 2에 의해, 5 * 3은 3에 의해, 5 * 4는 2에 의해 제외되었기 때문임
            // num의 배수들은 소수가 아니므로 제외
            for (int mul = num * num; mul <= N; mul += num) {
                primeTable[mul] = false;
            }
        }
        
        return primeTable;
    }
    
    private static int calcDistance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }
}

class Village {
    int x, y;
    
    public Village(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Village)) return false;
        
        Village o = (Village) obj;
        return this.x == o.x && this.y == o.y;
    }
    
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Node implements Comparable<Node> {
    Village village;
    int d;
    
    public Node(Village village, int d) {
        this.village = village;
        this.d = d;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.d - o.d;
    }
    
    @Override
    public String toString() {
        return "(" + village.x + ", " + village.y + ")<" + d + ">";
    }
}