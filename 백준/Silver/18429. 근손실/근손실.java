import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   18429
 * @problemTitle    근손실
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;
        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]); // 운동 키트 개수
        int K = Integer.parseInt(userInput[1]); // 하루가 지나면 감소하는 중량

        userInput = br.readLine().split(" ");
        int[] kit = new int[N];
        boolean[] visited = new boolean[N];
        for (i = 0; i < N; i++) {
            kit[i] = Integer.parseInt(userInput[i]);
        }

        bw.write(dfs(kit, visited, 0, N, K, 1, 500) + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    /**
     * @param kit     각 운동 키트 중량 증가량
     * @param visited 각 운동 키트 사용 여부
     * @param ans     운동 기간 동안 중량이 500 이상이 되도록하는 경우의 수
     * @param N       서로 다른 운동 키트의 개수
     * @param K       하루가 지나면 감소하는 중량 수치
     * @param depth   지난 일 수
     * @param sum     현재 중량
     */
    private static int dfs(int[] kit, boolean[] visited, int ans, int N, int K, int depth, int sum) {
        if (depth == N) {
            return ans + 1;
        }
        for (int i = 0; i < N; i++) {
            // 미사용한 운동 키트 및 키트 사용 시 중량이 500 이상이면
            if (!visited[i] && sum - K + kit[i] >= 500) {
                // 운동 키트를 사용
                visited[i] = true;
                // 다음 날 다른 키트를 사용
                ans = dfs(kit, visited, ans, N, K, depth + 1, sum - K + kit[i]);
                // 새로운 경우의 수 탐색 위해 운동 키트를 새롭게 함
                visited[i] = false;
            }
        }
        return ans;
    }
}