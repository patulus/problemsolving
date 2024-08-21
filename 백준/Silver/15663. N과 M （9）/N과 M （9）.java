import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   15663
 * @problemTitle    N과 M (9)
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i;

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]); // N개의 자연수 중에서
        int M = Integer.parseInt(userInput[1]); // M개를 고른 수열을 모두 구하라

        int[] nums = new int[N];
        // 삽입 순서 유지, 동일 요소 무시(HashMap의 key를 이용)
        Set<String> history = new LinkedHashSet<>();
        int[] subHistory = new int[M];
        boolean[] visited = new boolean[N];

        userInput = br.readLine().split(" ");
        for (i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(userInput[i]);
        }

        Arrays.sort(nums);

        dfs(sb, nums, visited, M, history, subHistory, 0);

        for (String e : history) {
            sb.append(e);
        }
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    private static void dfs(StringBuilder sb, int[] nums, boolean[] visited, int M, Set<String> history, int[] subHistory, int depth) {
        if (depth == M) {
            for (int num : subHistory) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            history.add(sb.toString());
            sb.delete(0, sb.length());

            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                subHistory[depth] = nums[i];
                dfs(sb, nums, visited, M, history, subHistory, depth + 1);
                visited[i] = false;
            }
        }
    }
}