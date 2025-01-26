import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   32177
 * @problemTitle    에어드롭
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]); // 친구의 수
        int K = Integer.parseInt(tokens[1]); // 에어드롭 최대 거리
        int T = Integer.parseInt(tokens[2]); // 최대 휴대폰 버전 차

        tokens = br.readLine().split(" ");
        int Xp = Integer.parseInt(tokens[0]); // 푸앙이의 x 좌표
        int Yp = Integer.parseInt(tokens[1]); // 푸앙이의 y 좌표
        int Vp = Integer.parseInt(tokens[2]); // 푸앙이의 휴대폰 버전

        Phone[] phones = new Phone[N + 1];
        phones[0] = new Phone(Xp, Yp, Vp, true); // 푸앙이의 휴대폰

        for (int i = 0; i < N; ++i) {
            tokens = br.readLine().split(" ");
            int Xi = Integer.parseInt(tokens[0]); // 친구의 x 좌표
            int Yi = Integer.parseInt(tokens[1]); // 친구의 y 좌표
            int Vi = Integer.parseInt(tokens[2]); // 친구의 휴대폰 버전
            boolean Pi = Integer.parseInt(tokens[3]) == 1; // 푸앙이와 사진을 찍었는지 여부

            phones[i + 1] = new Phone(Xi, Yi, Vi, Pi);
        }

        int[] parents = new int[N + 1];
        for (int i = 0; i <= N; ++i) {
            parents[i] = i;
        }

        Phone myPhone = null;
        Phone yourPhone = null;
        for (int i = 0; i <= N; ++i) { // 연결 가능한 휴대폰 간 연결
            myPhone = phones[i];
            for (int j = 0; j <= N; ++j) {
                yourPhone = phones[j];
                // 버전을 확인해 휴대폰 간 연결될 수 있는지 확인
                if (Math.abs(yourPhone.version - myPhone.version) > T) continue;
                // 유클리드 거리를 확인해 휴대폰 간 연결될 수 있는지 확인
                if (Math.pow(yourPhone.x - myPhone.x, 2) + Math.pow(yourPhone.y - myPhone.y, 2) > Math.pow(K, 2)) continue;

                // 연결될 수 있다면 i 휴대폰과 j 휴대폰을 동일한 집합에 소속시킴
                union(parents, i, j);
            }
        }

        for (int i = 1; i <= N; ++i) {
            myPhone = phones[i];
            // 사진을 받을 수 없는 위치에 있는 친구인지 확인
            if (find(parents, i) != 0) continue;
            // 푸앙이와 사진을 찍었으며 에어드롭을 받을 수 있는 친구인지 확인
            if (!myPhone.isTaken) continue;

            sb.append(i).append(" ");
        }
        bw.write(sb.length() != 0 ? sb.toString() : "0\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static void union(int[] parents, int u, int v) {
        int pu = find(parents, u);
        int pv = find(parents, v);

        if (pu < pv) {
            parents[pv] = pu;
        } else {
            parents[pu] = pv;
        }
    }

    private static int find(int[] parents, int v) {
        if (parents[v] == v) return v;

        // Path compression
        return parents[v] = find(parents, parents[v]);
    }
}

class Phone {
    int x, y;
    int version;
    boolean isTaken;

    public Phone(int x, int y, int version, boolean isTaken) {
        this.x = x;
        this.y = y;
        this.version = version;
        this.isTaken = isTaken;
    }
}