import java.io.*;

public class Main {
    static int solution(int userInput) {
        int sum = 0;
        int temp = 0;

        for (int i = 1; i <= userInput; i++) {
            sum = i;
            temp = i;

            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == userInput) return i;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int userInput = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb.append(solution(userInput)).append("\n");
        bw.write(sb.toString());
        bw.flush();
    }
}