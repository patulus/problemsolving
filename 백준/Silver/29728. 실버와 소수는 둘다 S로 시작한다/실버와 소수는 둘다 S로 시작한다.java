import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * BOJ#29728 실버와 소수는 둘다 S로 시작한다
 */
public final class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] primeTable = getPrimeTable(N);

        int i;

        boolean temp;
        boolean isFirstCharacterB = false;
        boolean isLastCharacterB = false;

        int cntB = 0;
        int cntS = 0;

        for (i = 1; i <= N; ++i) {
            // 소수가 아니라면
            if (!primeTable[i]) {
                // A의 끝에 알파벳 B를 추가한다.
                ++cntB;
                isLastCharacterB = true;
                continue;
            }

            // 소수라면

            // A의 마지막 문자가 B라면
            if (isLastCharacterB) {
                // B를 S로 교체하고
                // A의 끝에 S를 하나 더 추가한다.
                --cntB;
                cntS += 2;
            } else {
                // 아니라면 단순히 A의 끝에 S를 하나 추가한다.
                ++cntS;
            }

            isLastCharacterB = false;

            // 이후 A를 뒤집는다.
            temp = isFirstCharacterB;
            isFirstCharacterB = isLastCharacterB;
            isLastCharacterB = temp;
        }

        bw.write(cntB + " " + cntS + "\n");
        bw.flush();


        br.close();
        bw.close();
    }

    private static boolean[] getPrimeTable(int N) {
        boolean[] primeTable = new boolean[N + 1]; // 0 ~ N
        Arrays.fill(primeTable, true);

        primeTable[0] = primeTable[1] = false;

        int num, mul;
        for (num = 2; num <= Math.sqrt(N); ++num) {
            if (!primeTable[num]) continue;

            for (mul = num * num; mul <= N; mul += num) {
                primeTable[mul] = false;
            }
        }

        return primeTable;
    }
}
