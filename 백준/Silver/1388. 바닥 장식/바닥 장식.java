import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   1388
 * @problemTitle    바닥 장식
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] userInput = br.readLine().split(" ");
        int row = Integer.parseInt(userInput[0]);
        int col = Integer.parseInt(userInput[1]);
        
        int cntRow = 0;
        int cntCol = 0;
        boolean go = false;
        
        int i, j;
        char[][] floor = new char[row][col];
        for (i = 0; i < row; i++) {
            userInput = br.readLine().split("");
            
            for (j = 0; j < col; j++) {
                floor[i][j] = userInput[j].charAt(0);
            }
        }
        
        // -만 세기
        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                if (floor[i][j] == '|') {
                    if (go) {
                        cntRow++;
                        go = false;
                    }
                } else {
                    go = true;
                }
            }
            cntRow += go ? 1 : 0;
            go = false;
        }
        
        // |만 세기
        for (i = 0; i < col; i++) {
            for (j = 0; j < row; j++) {
                if (floor[j][i] == '-') {
                    if (go) {
                        cntCol++;
                        go = false;
                    }
                } else {
                    go = true;
                }
            }
            cntCol += go ? 1 : 0;
            go = false;
        }
        
        bw.write((cntRow + cntCol) + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}