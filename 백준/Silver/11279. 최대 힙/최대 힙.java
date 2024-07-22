import java.io.*;

class HeapType {
    int[] heap;
    int heapSize;

    HeapType(int maxSize) {
        heap = new int[maxSize];
        heapSize = 0;
    }

    void insert(int key) {
        int idx = ++heapSize;

        while (idx != 1 && key > heap[idx / 2]) {
            heap[idx] = heap[idx / 2];
            idx /= 2;
        }
        heap[idx] = key;
    }

    int delete() {
        if (heapSize == 0) return 0;

        int r = heap[1];
        int l = heap[heapSize--];

        int parent = 1;
        int child = 2;
        while (child <= heapSize) {
            if (heap[child] < heap[child + 1]) child++;
            if (l > heap[child]) break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = l;

        return r;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int userInput;
        int N = Integer.parseInt(br.readLine());
        HeapType h = new HeapType(N);
        int i;

        for (i = 0; i < N; i++) {
            userInput = Integer.parseInt(br.readLine());

            if (userInput == 0) {
                sb.append(h.delete()).append("\n");
            } else {
                h.insert(userInput);
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}