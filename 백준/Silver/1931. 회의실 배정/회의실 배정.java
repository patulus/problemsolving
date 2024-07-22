import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInput;
        int i, endTime, cnt = 1;
        int N = Integer.parseInt(br.readLine());
        int[][] activities = new int[N][2];

        for (i = 0; i < N; ++i) {
            userInput = br.readLine().split(" ");
            activities[i][0] = Integer.parseInt(userInput[0]);
            activities[i][1] = Integer.parseInt(userInput[1]);
        }

        Arrays.sort(activities, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        endTime = activities[0][1];
        for (i = 1; i < N; ++i) {
            if (activities[i][0] < endTime) continue;

            endTime = activities[i][1];
            ++cnt;
        }

        System.out.println(cnt);
    }
}