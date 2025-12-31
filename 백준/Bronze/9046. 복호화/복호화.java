import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static final int N_ALPHABET = 26;
    public static final char ASCII_LITTLE_A = 'a';
    public static final char ASCII_LITTLE_Z = 'z';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 입력 1: 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        int[] count; // 문자 빈도

        String s; // 테스트 케이스 문자열
        int max; // 문자의 최고 빈도
        boolean same; // 최고 빈도와 동일한 문자의 빈도가 존재하는지 여부

        while (T-- > 0) {
            // 초기화
            count = new int[N_ALPHABET];
            // 입력 2 ~: 소문자와 공백으로 이루어진 영어 문장
            s = br.readLine().toLowerCase();
            max = 0;
            same = false;

            // 문자 빈도 계산
            for (int i = 0; i < s.length(); ++i) {
                // 소문자 a부터 소문자 z 사이에 위치한 문자가 아니면 빈도를 계산하지 않음
                if (s.charAt(i) < ASCII_LITTLE_A || s.charAt(i) > ASCII_LITTLE_Z) {
                    continue;
                }

                ++count[s.charAt(i) - ASCII_LITTLE_A];
            }

            // 최고 빈도 및 최고 빈도와 동일한 빈도의 여부 확인
            for (int i = 1; i < N_ALPHABET; ++i) {
                if (count[i] > count[max]) {
                    max = i;
                    same = false;
                } else if (count[max] == count[i]) {
                    same = true;
                }
            }

            // 최고 빈도와 동일한 빈도의 문자가 없으면 해당 문자를,
            //                              있으면        ?를 출력
            sb.append(!same ? (char)(max + ASCII_LITTLE_A) : '?');
            sb.append('\n');
        }

        // 모든 테스트 케이스의 결과 출력
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
