import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Main {
    public static void main(String args[]) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int cases = Integer.parseInt(br.readLine());
        int allowed = 0;
        
        for (int i = 0; i < cases; i++) {
            String input = br.readLine().replaceAll("  ", " ");
            StringTokenizer st = new StringTokenizer(input, " ");
            
            float length, width, depth, weight;
            length = Float.parseFloat(st.nextToken());
            width = Float.parseFloat(st.nextToken());
            depth = Float.parseFloat(st.nextToken());
            weight = Float.parseFloat(st.nextToken());
            
            if(((length <= 56 && width <= 45 && depth <= 25) || length+width+depth <= 125) && weight <= 7){
                bw.write("1\n");
                bw.flush();

                allowed++;
            }
            else {
                bw.write("0\n");
                bw.flush();
            }
        }
        
        bw.write(allowed + "\n");
        bw.flush();
    }
}
