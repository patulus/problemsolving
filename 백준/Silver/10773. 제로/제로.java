import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        int userInput;
        int i;
        int[] stack = new int[K];
        int stackSize = -1;
        int sum = 0;

        for (i = 0; i < K; i++) {
            userInput = Integer.parseInt(br.readLine());
            if (userInput == 0) {
                stackSize--;
            } else {
                stack[++stackSize] = userInput;
            }
        }
        for (i = 0; i < stackSize + 1; i++) {
            sum += stack[i];
        }

        bw.write(Integer.toString(sum));
        bw.write("\n");
        bw.flush();
    }
}