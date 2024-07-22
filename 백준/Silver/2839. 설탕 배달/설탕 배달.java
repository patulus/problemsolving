import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int satou(int N) {
        int prevSum = N;

        for (int i = 0; i <= N / 3; i++) {
            for (int j = 0; j <= N / 5; j++) {
                if (3 * i + 5 * j == N && i + j < prevSum) {
                    prevSum = i + j;
                }
            }
        }

        if (prevSum == N) prevSum = -1;

        return prevSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        System.out.println(satou(input));

        br.close();
    }
}