import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static boolean isPalindrome(String[] arr) {
        String[] stack = new String[arr.length];
        String[] queue = new String[arr.length];
        int top = -1;
        int front = -1;
        int rear = -1;

        for (String ch : arr) {
            stack[++top] = ch;
            queue[++rear] = ch;
        }
        
        while (top != -1 && front != rear) {
            if (!stack[top--].equals(queue[++front])) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] arr = br.readLine().split("");
        bw.write((isPalindrome(arr) ? '1' : '0'));
        bw.write('\n');
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}