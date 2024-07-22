import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("<");

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int K = Integer.parseInt(userInput[1]);

        int[] arrB = new int[N];
        int arrBIdx = -1;

        int[] arr = new int[N];
        int i, idx = 0;
        for (i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        int cntA = 0;
        int cntB = 0;

        do {

            if (idx == arr.length) {
                idx = 0;
                arrBIdx = -1;
            }

            if (arr[idx] == -1) {
                idx++;
                continue;
            }

            if (cntA == K - 1) {
                cntA = 0;
                cntB += 1;

                if (cntB != N) {
                    sb.append(arr[idx]).append(", ");
                } else {
                    sb.append(arr[idx]).append(">\n");
                }

                arr[idx++] = -1;
                continue;
            }

            arrB[++arrBIdx] = arr[idx++];
            cntA++;
        } while (cntB != N);

        bw.write(sb.toString());
        bw.flush();
    }
}