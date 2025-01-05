import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public final class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;

        int T = Integer.parseInt(br.readLine());
        byte[] tokens;

        int[] cnt = new int[26];
        int[] phoneNumber = new int[6]; // 제일 적은 공간을 차지하는 세 자리 영문 숫자를 기준으로 20자까지 적으면 ONEONEONEONEONEONE, 111111로 최대 6자리의 전화번호를 가짐
        Arrays.fill(phoneNumber, 10); // 정렬을 위해 빈 공간은 10으로 채움 (0 ~ 9까지만 판단)
        int phoneNumberSize; // 전화번호가 기록된 크기 (그 이상은 10으로 채워져 있음)

        int x = 1;
        while (T > 0) {
            tokens = br.readLine().getBytes();

            Arrays.fill(cnt, 0);
            Arrays.fill(phoneNumber, 10);

            countAlphabet(tokens, cnt);

            phoneNumberSize = convertToNumber(tokens, cnt, phoneNumber);
            Arrays.sort(phoneNumber);

            sb.append("Case #").append(x++).append(": ");
            for (i = 0; i < phoneNumberSize; ++i) {
                sb.append(phoneNumber[i]);
            }
            sb.append("\n");

            --T;
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int convertToNumber(byte[] tokens, int[] cnt, int[] phoneNumber) {
        int idx = 0;

        for (int i = 0; i < tokens.length; ++i) {
            if (cnt[tokens[i] - 'A'] <= 0) continue; // 해당 영문 숫자를 사용할 수 없으면 다음 문자로 이동

            if (tokens[i] == 'Z') { // ZERO에서 Z는 영문 숫자 중에서 유일
                if (cnt['Z' - 'A'] - 1 < 0 || cnt['E' - 'A'] - 1 < 0 || cnt['R' - 'A'] - 1 < 0 || cnt['O' - 'A'] - 1 < 0)
                    continue;

                --cnt['Z' - 'A'];
                --cnt['E' - 'A'];
                --cnt['R' - 'A'];
                --cnt['O' - 'A'];

                phoneNumber[idx++] = 0;
                continue;
            }
            if (tokens[i] == 'W') { // TWO에서 W는 영문 숫자 중에서 유일
                if (cnt['T' - 'A'] - 1 < 0 || cnt['W' - 'A'] - 1 < 0 || cnt['O' - 'A'] - 1 < 0) continue;

                --cnt['T' - 'A'];
                --cnt['W' - 'A'];
                --cnt['O' - 'A'];

                phoneNumber[idx++] = 2;
                continue;
            }
            if (tokens[i] == 'U') { // FOUR에서 U는 영문 숫자 중에서 유일
                if (cnt['F' - 'A'] - 1 < 0 || cnt['O' - 'A'] - 1 < 0 || cnt['U' - 'A'] - 1 < 0 || cnt['R' - 'A'] - 1 < 0)
                    continue;

                --cnt['F' - 'A'];
                --cnt['O' - 'A'];
                --cnt['U' - 'A'];
                --cnt['R' - 'A'];

                phoneNumber[idx++] = 4;
                continue;
            }
            if (tokens[i] == 'X') { // SIX에서 X는 영문 숫자 중에서 유일
                if (cnt['S' - 'A'] - 1 < 0 || cnt['I' - 'A'] - 1 < 0 || cnt['X' - 'A'] - 1 < 0) continue;

                --cnt['S' - 'A'];
                --cnt['I' - 'A'];
                --cnt['X' - 'A'];

                phoneNumber[idx++] = 6;
                continue;
            }
            if (tokens[i] == 'G') { // EIGHT에서 G는 영문 숫자 중에서 유일
                if (cnt['E' - 'A'] - 1 < 0 || cnt['I' - 'A'] - 1 < 0 || cnt['G' - 'A'] - 1 < 0 || cnt['H' - 'A'] - 1 < 0 || cnt['T' - 'A'] - 1 < 0)
                    continue;

                --cnt['E' - 'A'];
                --cnt['I' - 'A'];
                --cnt['G' - 'A'];
                --cnt['H' - 'A'];
                --cnt['T' - 'A'];

                phoneNumber[idx++] = 8;
                continue;
            }
        }
        for (int i = 0; i < tokens.length; ++i) {
            if (cnt[tokens[i] - 'A'] <= 0) continue; // 해당 영문 숫자를 사용할 수 없으면 다음 문자로 이동

            if (tokens[i] == 'O') { // ONE에서 O는 남은 영문 숫자 중에서 유일
                if (cnt['O' - 'A'] - 1 < 0 || cnt['N' - 'A'] - 1 < 0 || cnt['E' - 'A'] - 1 < 0) continue;

                --cnt['O' - 'A'];
                --cnt['N' - 'A'];
                --cnt['E' - 'A'];

                phoneNumber[idx++] = 1;
                continue;
            }

            if (tokens[i] == 'T') { // THREE에서 T는 남은 영문 숫자 중에서 유일
                if (cnt['T' - 'A'] - 1 < 0 || cnt['H' - 'A'] - 1 < 0 || cnt['R' - 'A'] - 1 < 0 || cnt['E' - 'A'] - 2 < 0)
                    continue;

                --cnt['T' - 'A'];
                --cnt['H' - 'A'];
                --cnt['R' - 'A'];
                --cnt['E' - 'A'];
                --cnt['E' - 'A'];

                phoneNumber[idx++] = 3;
                continue;
            }
            if (tokens[i] == 'F') { // FIVE에서 F는 남은 영문 숫자 중에서 유일
                if (cnt['F' - 'A'] - 1 < 0 || cnt['I' - 'A'] - 1 < 0 || cnt['V' - 'A'] - 1 < 0 || cnt['E' - 'A'] - 1 < 0)
                    continue;

                --cnt['F' - 'A'];
                --cnt['I' - 'A'];
                --cnt['V' - 'A'];
                --cnt['E' - 'A'];

                phoneNumber[idx++] = 5;
                continue;
            }
            if (tokens[i] == 'S') { // SEVEN에서 S는 남은 영문 숫자 중에서 유일
                if (cnt['S' - 'A'] - 1 < 0 || cnt['E' - 'A'] - 2 < 0 || cnt['V' - 'A'] - 1 < 0 || cnt['N' - 'A'] - 1 < 0)
                    continue;

                --cnt['S' - 'A'];
                --cnt['E' - 'A'];
                --cnt['V' - 'A'];
                --cnt['E' - 'A'];
                --cnt['N' - 'A'];

                phoneNumber[idx++] = 7;
                continue;
            }
            if (tokens[i] == 'N') { // NINE
                if (cnt['N' - 'A'] - 2 < 0 || cnt['I' - 'A'] - 1 < 0 || cnt['E' - 'A'] - 1 < 0) continue;

                --cnt['N' - 'A'];
                --cnt['I' - 'A'];
                --cnt['N' - 'A'];
                --cnt['E' - 'A'];

                phoneNumber[idx++] = 9;
                continue;
            }
        }

        return idx;
    }

    private static void countAlphabet(byte[] tokens, int[] cnt) {
        for (byte c : tokens) {
            ++cnt[c - 'A']; // 'A'(65) - 'A'(65) == 0, 'B'(66) - 'A'(65) == 1
        }
    }
}
