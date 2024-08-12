import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   24498
 * @problemTitle    blobnom
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;
        int N = Integer.parseInt(br.readLine());

        int[] towerHeights = new int[N];
        String[] userInput = br.readLine().split(" ");
        for (i = 0; i < N; i++) {
            towerHeights[i] = Integer.parseInt(userInput[i]);
        }

        int select, adjacentLeft, adjacentRight;
        int max = maxValue(towerHeights, 0, N-1);
        for (select = 1; select < N-1; select++) {
            adjacentLeft = select - 1;
            adjacentRight = select + 1;

            if (towerHeights[select] < 1 || towerHeights[adjacentLeft] < 1 || towerHeights[adjacentRight] < 1) continue;

            max = Math.max(max, towerHeights[select] + Math.min(towerHeights[adjacentLeft], towerHeights[adjacentRight]));
        }

        bw.write(max + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static int maxValue(int[] ary, int low, int high) {
        int max = ary[low];
        for (int i = low+1; i <= high; i++) {
            if (max < ary[i]) max = ary[i];
        }
        return max;
    }
}