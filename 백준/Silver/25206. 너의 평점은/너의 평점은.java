import com.sun.source.tree.LambdaExpressionTree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] userInput;
        double grade = 0.0;
        double score = 0.0;
        double allGrade = 0.0;
        double allScore = 0.0;
        int lecture = 0;
        
        for (int i = 0; i < 20; i++) {
            userInput = br.readLine().split(" ");
            
            if (userInput[2].equals("P")) continue;
            
            grade = Double.parseDouble(userInput[1]);
            switch (userInput[2]) {
                case "A+":
                    score = 4.5;
                    break;
                case "A0":
                    score = 4.0;
                    break;
                case "B+":
                    score = 3.5;
                    break;
                case "B0":
                    score = 3.0;
                    break;
                case "C+":
                    score = 2.5;
                    break;
                case "C0":
                    score = 2.0;
                    break;
                case "D+":
                    score = 1.5;
                    break;
                case "D0":
                    score = 1.0;
                    break;
                case "F":
                    score = 0.0;
                    break;
            }
            
            allGrade += grade;
            allScore += (grade * score);
        }
        allScore /= allGrade;
        
        bw.write(String.format("%.6f", allScore));
        bw.flush();
        
        bw.close();
        br.close();
    }
}