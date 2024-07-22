import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int M = Integer.parseInt(userInput[1]);
        int[] buckets = new int[N];
        int i, temp;
        for (i = 0; i < N; i++) {
            buckets[i] = i + 1;
        }

        for (i = 0; i < M; i++) {
            userInput = br.readLine().split(" ");
            if (userInput[0].equals(userInput[1])) continue;
            temp = buckets[Integer.parseInt(userInput[0]) - 1];
            buckets[Integer.parseInt(userInput[0]) - 1] = buckets[Integer.parseInt(userInput[1]) - 1];
            buckets[Integer.parseInt(userInput[1]) - 1] = temp;
        }

        for (i = 0; i < N; i++) {
            sb.append(buckets[i]).append(" ");
        }
        sb.append("\n");

        bw.write(sb.toString());
        bw.flush();
    }
}