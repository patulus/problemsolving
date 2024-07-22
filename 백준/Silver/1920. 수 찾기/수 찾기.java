import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i, j, k;
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] userInput = br.readLine().split(" ");
        for (i = 0; i < N; ++i) A[i] = Integer.parseInt(userInput[i]);
        Arrays.sort(A);
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        userInput = br.readLine().split(" ");
        for (i = 0; i < M; ++i) B[i] = Integer.parseInt(userInput[i]);

        for (i = 0; i < M; ++i) {
            sb.append(Arrays.binarySearch(A, 0, A.length, B[i]) > -1 ? 1 : 0).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}