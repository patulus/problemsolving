import java.io.*;

class QueueType {
    int[] queue;
    int front, rear;
    int size;

    QueueType(int size) {
        queue = new int[size + 1];
        front = rear = 0;
        size = 0;
    }

    int full() {
        return front == (rear + 1) % queue.length ? 1 : 0;
    }

    int empty() {
        return front == rear ? 1 : 0;
    }

    void push(int x) {
        if (full() == 1) throw new ArrayIndexOutOfBoundsException("Queue is full.");
        rear = (rear + 1) % queue.length;
        queue[rear] = x;
        size++;
    }

    int pop() {
        if (empty() == 1) return -1;
        front = (front + 1) % queue.length;
        size--;
        return queue[front];
    }

    int size() {
        return size;
    }

    int front() {
        if (empty() == 1) return -1;
        return queue[(front + 1) % queue.length];
    }

    int back() {
        if (empty() == 1) return -1;
        return queue[rear];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int cnt = Integer.parseInt(br.readLine());
        QueueType q = new QueueType(cnt);

        String[] userInput = null;
        for (int i = 0; i < cnt; i++) {
            userInput = br.readLine().split(" ");

            switch (userInput[0]) {
                case "push":
                    q.push(Integer.parseInt(userInput[1]));
                    break;
                case "pop":
                    sb.append(q.pop()).append("\n");
                    break;
                case "size":
                    sb.append(q.size()).append("\n");
                    break;
                case "empty":
                    sb.append(q.empty()).append("\n");
                    break;
                case "front":
                    sb.append(q.front()).append("\n");
                    break;
                case "back":
                    sb.append(q.back()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}