import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   17266
 * @problemTitle    어두운 굴다리
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;

        int N = Integer.parseInt(br.readLine()); // 굴다리의 길이
        int M = Integer.parseInt(br.readLine()); // 가로등의 개수

        String[] userInput = br.readLine().split(" ");
        int[] availConstruction = new int[userInput.length]; // 가로등을 설치할 수 있는 위치
        for (i = 0; i < availConstruction.length; i++) {
            availConstruction[i] = Integer.parseInt(userInput[i]);
        }

        int start = 1; // 가로등 높이의 최소
        int end = N; // 가로등 높이의 최대
        int mid = 0; // 선택할 가로등 높이
        int result = 0; // 선택된 가로등 높이 중 최소
        int test = 1;

        while (start <= end) {
            mid = (start + end) / 2;

            if (chkLight(N, availConstruction, mid)) { // 모든 범위가 밝혀지면 해당 높이를 기록하고 더 작은 높이를 찾기
                result = mid;
                end = mid - 1;
            } else { // 모든 범위가 밝혀지지 않으면 가로등 높이를 높인다
                start = mid + 1;
            }

            test++;
        }

        bw.write(result + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static boolean chkLight(int tunnelLength, int[] availConstruction, int lightRange) {
        // 굴다리 시작부터 처음 가로등까지 다 밝혀지는지 파악
        if (availConstruction[0] - 0  > lightRange) { // 다 밝혀지지 않으면 새로운 높이를 찾기
            return false;
        }

        // 처음 가로등부터 마지막 가로등까지 다 밝혀지는지 파악
        for (int i = 1; i < availConstruction.length; i++) {
            // 가로등 A와 가로등 B 간 거리 절반 거리만큼 밝히면 두 가로등에 의해 해당 구간은 모두 밝혀짐
            if (Math.ceil((double)(availConstruction[i] - availConstruction[i-1]) / 2) > lightRange) { // 다 밝혀지지 않으면 새로운 높이를 찾기
                return false;
            }
        }

        // 마지막 가로등부터 굴다리 종료까지 다 밝혀지는지 파악
        if (tunnelLength - availConstruction[availConstruction.length-1] > lightRange) { // 다 밝혀지지 않으면 새로운 높이를 찾기
            return false;
        }

        // 다 밝혀지면 해당 높이를 기록하고 더 작은 높이를 찾기
        return true;
    }
}