import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        String[] userInput = null;
        for (int i = 0; i < n; i++) {
            userInput = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(userInput[0]);
            arr[i][1] = Integer.parseInt(userInput[1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int comp = o1[0] - o2[0];
                return (comp == 0) ? o1[1] - o2[1] : comp;
            }
        });

        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]);
            sb.append(" ");
            sb.append(arr[i][1]);
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}