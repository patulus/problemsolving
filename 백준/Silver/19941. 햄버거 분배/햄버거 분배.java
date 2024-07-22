import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int K = Integer.parseInt(userInput[1]);
        userInput = br.readLine().split("");

        int i, j, maxPerson = 0;
        for (i = 0; i < N; ++i) {
            if (!userInput[i].equals("P")) continue;

            for (j = i - K; j <= i + K; ++j) {
                if (j >= 0 && j < N) {
                    if (userInput[j].equals("H")) {
                        userInput[j] = "-";
                        ++maxPerson;
                        break;
                    }
                }
            }
        }

        bw.write(maxPerson + "\n");
        bw.flush();
    }
}