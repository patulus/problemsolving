import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] grade = new int[2];
        grade[0] = br.read();
        grade[1] = br.read();

        switch (grade[0]) {
            case 'A':
                switch (grade[1]) {
                    case '+':
                        bw.write("4.3\n");
                        break;
                    case '0':
                        bw.write("4.0\n");
                        break;
                    case '-':
                        bw.write("3.7\n");
                        break;
                }
                break;
            case 'B':
                switch (grade[1]) {
                    case '+':
                        bw.write("3.3\n");
                        break;
                    case '0':
                        bw.write("3.0\n");
                        break;
                    case '-':
                        bw.write("2.7\n");
                        break;
                }
                break;
            case 'C':
                switch (grade[1]) {
                    case '+':
                        bw.write("2.3\n");
                        break;
                    case '0':
                        bw.write("2.0\n");
                        break;
                    case '-':
                        bw.write("1.7\n");
                        break;
                }
                break;
            case 'D':
                switch (grade[1]) {
                    case '+':
                        bw.write("1.3\n");
                        break;
                    case '0':
                        bw.write("1.0\n");
                        break;
                    case '-':
                        bw.write("0.7\n");
                        break;
                }
                break;
            case 'F':
                bw.write("0.0\n");
                break;
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
