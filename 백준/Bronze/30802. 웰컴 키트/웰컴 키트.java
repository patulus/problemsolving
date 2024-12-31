import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int N = Integer.parseInt(br.readLine()); // 참가자의 수
        int[] size = new int[6]; // 사이즈별 신청자 수 (S,M,L,XL,XXL,XXXL)
        int totalBundle = 0;
        String[] userInput = br.readLine().split(" ");
        for (i = 0; i < 6; ++i) {
            size[i] = Integer.parseInt(userInput[i]);
        }
        userInput = br.readLine().split(" ");
        int T = Integer.parseInt(userInput[0]); // 티셔츠 한 묶음의 티셔츠 수
        int P = Integer.parseInt(userInput[1]); // 펜 한 묶음의 펜 수
        for (i = 0; i < 6; ++i) {
            totalBundle += size[i] % T == 0 ? size[i] / T : size[i] / T + 1;
        }

        sb.append(totalBundle).append("\n");
        sb.append(N / P).append(" ").append(N % P).append("\n");

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
