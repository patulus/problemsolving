import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);

        Stack<Character> stack = new Stack<>();

        char[] input = br.readLine().toCharArray();

        for (int i = 0; i < input.length; i++) {
            stack.push(input[i]);
        }

        int length = stack.size();

        char temp = stack.pop();
        int cnt = 0;
        cnt++;

        for (int i = 1; i < length; i++) {
            if (temp != stack.pop()) {
                break;
            }
            else {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}