import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]); // 몬스터의 수
        int D = Integer.parseInt(userInput[1]); // 기본 대미지
        int p = Integer.parseInt(userInput[2]); // 오버킬 비율

        userInput = br.readLine().split(" ");
        int[] monsters = new int[N];
        for (i = 0; i < N; ++i) {
            monsters[i] = Integer.parseInt(userInput[i]);
        }

        i = 0;
        int turns = 0;
        int overkillDamage = 0;
        while (i < N) {
            if (monsters[i] <= 0) {
                ++i;
                continue;
            }

            ++turns;
            monsters[i] -= D;
//            System.out.printf("%d번째 몬스터에게 %d의 대미지를 줘, 체력이 %d이 된다.\n", i+1, D, monsters[i]);

            if (monsters[i] == 0) {
                ++i;
            } else if (monsters[i] < 0) {
                overkillDamage = Math.abs(monsters[i]) * p / 100;
                ++i;
                if (i >= N) break;
                monsters[i] -= overkillDamage;
//                System.out.printf("\t%d의 %d%%인 %f를 소수점 첫째자리에서 버림한 %d만큼 %d번째 몬스터에게 대미지를 줘, 체력이 %d이 된다.\n", monsters[i-1], p, (double)Math.abs(monsters[i-1]) * p / 100, overkillDamage, i, monsters[i]);
            }
        }

        bw.write(String.format("%d\n", turns));
        bw.flush();

        bw.close();
        br.close();
    }
}