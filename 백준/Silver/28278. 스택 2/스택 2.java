import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   28278
 * @problemTitle    스택 2
 */

class Stack {
    LinkedList<Integer> stk;
    
    Stack() {
        stk = new LinkedList<>();
    }
    
    void push(int x) {
        stk.add(x);
    }
    
    int pop() {
        return !stk.isEmpty() ? stk.removeLast() : -1;
    }
    
    int size() {
        return stk.size();
    }
    
    int isEmpty() {
        return stk.isEmpty() ? 1 : 0;
    }
    
    int peek() {
        return !stk.isEmpty() ? stk.getLast() : -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String[] userInput;
        Stack stk = new Stack();
        
        for (; N > 0; N--) {
            userInput = br.readLine().split(" ");
            
            switch (userInput[0]) {
                case "1":
                    stk.push(Integer.parseInt(userInput[1]));
                    break;
                case "2":
                    sb.append(stk.pop()).append("\n");
                    break;
                case "3":
                    sb.append(stk.size()).append("\n");
                    break;
                case "4":
                    sb.append(stk.isEmpty()).append("\n");
                    break;
                case "5":
                    sb.append(stk.peek()).append("\n");
                    break;
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}