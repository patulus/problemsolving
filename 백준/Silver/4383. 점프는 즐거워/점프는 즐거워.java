import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * 길이가 1인 수열은 모두 jolly jumper임
 * 길이가 2 이상일 때 n개의 연속된 두 수의 차의 절댓값이 1부터 n-1까지 모두 나와야 jolly jumper임
 * 가령 1 4 2 3은 n=4이므로 1부터 3까지 나와야 함 : |1-4|=3, |4-2|=2, |2-3|=1로 1, 2, 3 모두 나오므로 jolly jumper임
 * 가령 1 4 2 -1 6은 n=5이므로 1부터 4까지 나와야 함 : |1-4|=3, |4-2|=2, |2-(-1)|=3, |-1-6|=7이므로 2, 3, 7이므로 jolly jumper가 아님
 *
 * @problemWebsite  acmipc.net
 * @problemNumber   4383
 * @problemTitle    점프는 즐거워
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String userInput;
        String[] splitUserInput;
        
        int userInputIdx;
        int i;
        int n;
        int[] seq; // 수열
        int[] abs; // 연속된 두 수의 차의 절댓값
        boolean[] isPresent; // 1부터 n-1까지 존재하는지 여부
        boolean isJollyJumper; // Jolly jumper 여부
        
        do {
            isJollyJumper = false;
            
            // 사용자로부터 입력을 받음
            // br.readLine() 메서드는 입력이 없으면 null을 반환
            userInput = br.readLine();
            if (userInput == null) break;
            
            splitUserInput = userInput.split(" ");
            
            // 수열의 길이
            n = Integer.parseInt(splitUserInput[0]);
            
            // 수열의 길이가 1인 수열은 무조건 Jolly jumper임
            if (n == 1) {
                isJollyJumper = true;
            } else {
                seq = new int[n];
                abs = new int[n-1];
                isPresent = new boolean[n-1];
                
                // 테스트 케이스 문제로 인한 NumberFormat 예외 발생 해결
                // https://www.acmicpc.net/board/view/143001
                for (i = 0, userInputIdx = 1; userInputIdx < splitUserInput.length; userInputIdx++) {
                    if (!splitUserInput[userInputIdx].isEmpty() && !splitUserInput[userInputIdx].equals(" ")) {
                        seq[i++] = Integer.parseInt(splitUserInput[userInputIdx]);
                    }
                }
                
                // 두 수의 차의 절댓값
                for (i = 0; i < n-1; i++) {
                    abs[i] = Math.abs(seq[i] - seq[i+1]);
                    
                    // 해당 절댓값이 1부터 n-1 중 하나에 해당하는지
                    if (1 <= abs[i] && abs[i] <= n-1) {
                        isPresent[abs[i] - 1] = true;
                    }
                }
                
                // 1부터 n-1 중 하나에 해당하는 절댓값이 있는지
                for (i = 0; i < n-1; i++) {
                    if (!isPresent[i]) {
                        break;
                    }
                }
                // 모두 있었다면 Jolly jumper임
                if (i == n-1) isJollyJumper = true;
                // 어느 하나가 없었다면 Jolly jumper가 아님
            }
            
            bw.write(isJollyJumper ? "Jolly" : "Not jolly");
            bw.write('\n');
        } while (true);
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}