import java.io.*;

class DequeType {
    int[] deque;
    int front, rear;
    int size;

    DequeType(int cnt) {
        deque = new int[cnt];
        front = rear = 0;
        size = 0;
    }

    int empty() {
        return front == rear ? 1 : 0;
    }

    int size() {
        return size;
    }

    void push_front(int x) {
        deque[front] = x;
        front = (deque.length + front - 1) % deque.length;
        size++;
    }

    void push_back(int x) {
        rear = (rear + 1) % deque.length;
        deque[rear] = x;
        size++;
    }

    int pop_front() {
        if (empty() == 1) return -1;
        front = (front + 1) % deque.length;
        size--;
        return deque[front];
    }

    int pop_back() {
        if (empty() == 1) return -1;
        rear = (deque.length + rear - 1) % deque.length;
        size--;
        return deque[(deque.length + rear + 1) % deque.length];
    }

    int front() {
        if (empty() == 1) return -1;
        return deque[(front + 1) % deque.length];
    }

    int back() {
        if (empty() == 1) return -1;
        return deque[rear];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine());
        DequeType d = new DequeType(cnt);
        String[] userInput = null;
        for (int i = 0; i < cnt; i++) {
            userInput = br.readLine().split(" ");
            switch(userInput[0]) {
                case "push_front":
                    d.push_front(Integer.parseInt(userInput[1]));
                    break;
                case "push_back":
                    d.push_back(Integer.parseInt(userInput[1]));
                    break;
                case "pop_front":
                    sb.append(d.pop_front()).append("\n");
                    break;
                case "pop_back":
                    sb.append(d.pop_back()).append("\n");
                    break;
                case "size":
                    sb.append(d.size()).append("\n");
                    break;
                case "empty":
                    sb.append(d.empty()).append("\n");
                    break;
                case "front":
                    sb.append(d.front()).append("\n");
                    break;
                case "back":
                    sb.append(d.back()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}