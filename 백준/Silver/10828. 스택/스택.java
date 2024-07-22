import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

class ListNode {
    int data;
    ListNode next;
    
    public ListNode() {
        this.data = 0;
        this.next = null;
    }
    
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
    
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

class Stack {
    OutputStreamWriter writer = new OutputStreamWriter(System.out);
    BufferedWriter bw = new BufferedWriter(writer);
    
    ListNode head;
    int lengths;
    
    public Stack() {
        head = null;
        lengths = 0;
    }
    
    public void push(int data) {
        ListNode node = new ListNode(data);
        
        if (head == null) {
            head = node;
        }
        else {
            ListNode temp = head;
            
            head = node;
            head.next = temp;
        }
        
        lengths++;
    }
    
    public void pop() throws IOException {
        if (head == null) {
            bw.write("-1\n");
        }
        else {
            bw.write(head.data + "\n");
            
            ListNode temp = head.next;
            
            head = temp;
            lengths--;
        }
        
        bw.flush();
    }
    
    public void size() throws IOException {
        bw.write(lengths + "\n");
        bw.flush();
    }
    
    public void empty() throws IOException {
        if (head == null) {
            bw.write("1\n");
        }
        else {
            bw.write("0\n");
        }
        
        bw.flush();
    }
    
    public void top() throws IOException {
        if (head == null) {
            bw.write("-1\n");
        }
        else {
            bw.write(head.data + "\n");
        }
        
        bw.flush();
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        
        Stack stack = new Stack();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int iter = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < iter; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            
            switch (command) {
                case "push":
                    int data = Integer.parseInt(st.nextToken());
                    stack.push(data);
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;
            }
        }
    }
}