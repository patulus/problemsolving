import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        
        int N = Integer.parseInt(br.readLine());
        
        String score_line = br.readLine();
        StringTokenizer st = new StringTokenizer(score_line, " ");
        
        double[] score = new double[N];
        for (int i = 0; i < N; i++) {
            score[i] = (double)Integer.parseInt(st.nextToken());
        }
        
        double M = score[0];
        double average = 0.0;
        
        for (int i = 1; i < N; i++) {
            if (M <= score[i]) {
                M = score[i];
            }
        }
        
        for (int i = 0; i < N; i++) {
            score[i] = score[i] / M * 100;
            average += score[i];
        }
        
        average = average / N;
        
        System.out.printf("%.9f\n", average);
    }
}