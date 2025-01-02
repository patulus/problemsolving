import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i;
        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]); // 정점
        int M = Integer.parseInt(userInput[1]); // 간선

        int[] edges = new int[N + 1];
        int s, e;
        for (i = 0; i < M; ++i) {
            userInput = br.readLine().split(" ");
            s = Integer.parseInt(userInput[0]);
            e = Integer.parseInt(userInput[1]);

            // 3 3
            // 2 1
            // 3 2
            // 1 3
            // 1번째 연산에서 2번 정점이 추가됨. 2번 정점은 1번 이하의 모든 정점(1)과 간선이 연결됨
            // 2번째 연산에서 3번 정점이 추가됨. 3번 정점은 2번 이하의 모든 정점(1,2)과 간선이 연결됨
            // 쉬운 파악을 위해 (2, 1)이면 2번 정점 간선 수 증가 (1:0, 2:1, 3:0)
            //                (3, 2)이면 3번 정점 간선 수 증가 (1:0, 2:1, 3:1)
            //                (1, 3)이면 3번 정점 간선 수 증가 (1:0, 2:1, 3:2)
            if (s > e) ++edges[s];
            else ++edges[e];
        }

        for (i = 2; i <= N; ++i) { // 1번 정점은 확인하지 않아도 됨
            // 현재 정점과 연결된 정점이 없으면 해당 정점의 번호 - 1의 연산은 Nothing
            if (edges[i] == 0) {
                sb.append("N");
            }
            // 현재 정점과 현재 정점을 제외한 모든 정점이 연결돼 있다면 해당 정점의 번호 - 1의 연산은 Everything
            else if (edges[i] == i - 1) {
                sb.append("E");
            }
            // 현재 정점과 일부 정점이 연결돼 있다면 현재 연산만으로는 그래프 생성 불가
            else {
                bw.write("-1\n");
                break;
            }
        }
        // 그래프 생성이 가능하면 출력 (for문에서 break를 만나면 i가 최대 N이 됨, 만나지 않으면 i가 N+1이 됨)
        if (i == N + 1) {
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();

        bw.close();
        br.close();
    }
}
