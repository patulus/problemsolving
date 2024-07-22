import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int repeat = Integer.parseInt(br.readLine());

        int[][] arr = new int[repeat][2];

        String[] inputArr = null;
        for (int i = 0; i < repeat; i++) {
            inputArr = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(inputArr[0]);
            arr[i][1] = Integer.parseInt(inputArr[1]);
        }

        for (int i = 0; i < repeat; i++) {
            int rank = 1;

            for (int j = 0; j < repeat; j++) {
                if (i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }

            sb.append(rank).append(" ");
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}