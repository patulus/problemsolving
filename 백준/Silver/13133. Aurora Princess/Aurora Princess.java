import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * 신내림을 받은 개 '떡대'가 N명의 인물 중 사건에 휘말릴 M명의 인물을 예언
 * 사건이 모두 끝난 후 행복한 사람(자기 자신 및 자기 어머니와 아버지가 모두 한국에서 살아있는 사람)은 몇 명인지 구하라.
 * 자기 자신도 어머니 또는 아버지가 될 수 있음
 *
 * @problemWebsite  acmipc.net
 * @problemNumber   13133
 * @problemTitle    Aurora Princess
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] userInput;
        
        int N = Integer.parseInt(br.readLine());
        int[][] person = new int[N][2]; // 사건에 휘말리는 사람의 부모님 정보 (어머니, 아버지 순)
        
        int i;
        for (i = 0; i < N; i++) {
            userInput = br.readLine().split(" ");
            person[i][0] = Integer.parseInt(userInput[0]);
            person[i][1] = Integer.parseInt(userInput[1]);
        }
        
        int M = Integer.parseInt(br.readLine());
        boolean[] deadOrBeInAmerica = new boolean[N+1];
        
        userInput = br.readLine().split(" ");
        for (i = 0; i < M; i++) {
            deadOrBeInAmerica[Integer.parseInt(userInput[i])-1] = true;
        }
        
        int cntHappyPerson = 0; // 사건이 모두 끝나고도 행복한 사람들의 수
        for (i = 0; i < N; i++) {
            if (!deadOrBeInAmerica[i]) { // 자기 자신이 살아 있고, 한국에 있다면
                if (person[i][0] != 0 && person[i][1] != 0) { // 부모님이 행방불명이 아니시라면
                    if (!deadOrBeInAmerica[person[i][0]-1] && !deadOrBeInAmerica[person[i][1]-1]) { // 부모님이 살아 있고, 한국에 있다면
                        // 이 사람은
                        // 자기 자신이 살아 있고, 한국에 있으며
                        // 부모님이 행방불명이 아니고, 살아 있으며 한국에 있으므로
                        // 사건이 모두 끝났을 때 행복한 사람임
                        cntHappyPerson++;
                    }
                }
            }
            // 그 외는 사건이 모두 끝났을 때 행복한 사람이 아님
        }
        
        bw.write(cntHappyPerson + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}