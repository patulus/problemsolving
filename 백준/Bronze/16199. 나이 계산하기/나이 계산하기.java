import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] birthAry = br.readLine().split(" ");
        String[] baseAry = br.readLine().split(" ");
        
        StringBuilder birth = new StringBuilder(birthAry[0]);
        StringBuilder base = new StringBuilder(baseAry[0]);
        for (int i = 1; i < 3; i++) {
            if (birthAry[i].length() == 1)
                birth.append(0);
            birth.append(birthAry[i]);
            
            if (baseAry[i].length() == 1)
                base.append(0);
            base.append(baseAry[i]);
        }
        
        // 만 나이
        bw.write(((Integer.parseInt(base.toString()) - Integer.parseInt(birth.toString())) / 10000) + "\n");
        
        // 연 나이
        int yearDiff = Integer.parseInt(base.substring(0, 4)) - Integer.parseInt(birth.substring(0, 4));
        bw.write((yearDiff + 1) + "\n");
        
        // 한국 나이
        bw.write(yearDiff + "\n");
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}