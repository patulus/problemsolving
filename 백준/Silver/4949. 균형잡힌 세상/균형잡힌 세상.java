import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   4949
 * @problemTitle    균형잡힌 세상
 */
public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String token;

        char[] stack = new char[100];
        while ((token = br.readLine()).charAt(0) != '.') {
            int top = -1;
            int i = 0;

            for (; i < token.length(); ++i) {
                char ch = token.charAt(i);

                if (ch == '(' || ch == '[') {
                    stack[++top] = ch;
                } else if (ch == ')') {
                    if (top == -1 || stack[top] != '(') {
                        sb.append("no\n");
                        break;
                    }

                    --top;
                } else if (ch == ']') {
                    if (top == -1 || stack[top] != '[') {
                        sb.append("no\n");
                        break;
                    }

                    --top;
                }
            }

            if (i != token.length()) continue;
            sb.append(top == -1 ? "yes\n" : "no\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}