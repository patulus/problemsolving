import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public enum RSP {
        R,
        S,
        P;
    }

    public static RSP[] getRspAry(String[] ary) {
        RSP[] res = new RSP[ary.length];
        
        for (int i = 0; i < ary.length; i++) {
            switch (ary[i]) {
                case "R":
                    res[i] = RSP.R;
                    break;
                case "S":
                    res[i] = RSP.S;
                    break;
                case "P":
                    res[i] = RSP.P;
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected character");
            }
        }
        
        return res;
    }
    
    public static String solution(String[] ary) {
        RSP[] rspAry = getRspAry(ary);
        
        if (rspAry[0] == rspAry[1] && ((rspAry[0].ordinal() + 2) % 3 == rspAry[2].ordinal() || (rspAry[0].ordinal() + 2) % 3 == rspAry[3].ordinal())) return "TK";
        else if (rspAry[2] == rspAry[3] && ((rspAry[2].ordinal() + 2) % 3 == rspAry[0].ordinal() || (rspAry[2].ordinal() + 2) % 3 == rspAry[1].ordinal())) return "MS";
        else return "?";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] userInput = br.readLine().split(" ");
        
        bw.write(solution(userInput));
        bw.flush();
        
        bw.close();
        br.close();
    }
}