import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int K = Integer.parseInt(userInput[1]);
        int i;

        userInput = br.readLine().split(" ");
        int[] degrees = new int[N];
        for (i = 0; i < N; ++i) {
            degrees[i] = Integer.parseInt(userInput[i]);
        }

        int maxDegree = 0;
        for (i = 0; i < K; ++i) {
            maxDegree += degrees[i];
        }

        int sw = maxDegree;
        for (i = K; i < N; ++i) {
            sw += degrees[i] - degrees[i - K];
            maxDegree = Math.max(sw, maxDegree);
        }

        bw.write(maxDegree + "\n");
        bw.flush();
    }
}