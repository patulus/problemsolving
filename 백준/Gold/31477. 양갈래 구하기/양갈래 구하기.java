import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   31477
 * @problemTitle    양갈래 구하기
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] tokens;

        int N = Integer.parseInt(br.readLine()); // 방의 수
        List<List<Vine>> vines = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            vines.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; ++i) { // 덩굴이 N - 1개 존재
            tokens = br.readLine().split(" ");
            int A = Integer.parseInt(tokens[0]) - 1; // A번 방
            int B = Integer.parseInt(tokens[1]) - 1; // B번 방
            int V = Integer.parseInt(tokens[2]); // 덩굴의 두께

            vines.get(A).add(new Vine(B, V));
            vines.get(B).add(new Vine(A, V));
        }

        bw.write(dfs(vines, 0, -1) + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static int dfs(List<List<Vine>> vines, int cur, int parent) {
        if (parent != -1 && vines.get(cur).size() == 1) { // 단말 노드인 경우
            return vines.get(cur).get(0).weight;
        }

        int res = 0;
        for (Vine next : vines.get(cur)) {
            if (next.end == parent) continue;
            res += Math.min(next.weight, dfs(vines, next.end, cur));
        }

        return res;
    }
}

class Vine {
    int end, weight;

    public Vine(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}
