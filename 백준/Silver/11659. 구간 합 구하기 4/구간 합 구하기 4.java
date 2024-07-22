import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int M = Integer.parseInt(userInput[1]);

        int[] arr = new int[N];
        int i;
        userInput = br.readLine().split(" ");
        for (i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(userInput[i]);
        }

        SegmentTree st = new SegmentTree(arr);
        st.init(0, arr.length - 1, 1);

        for (i = 0; i < M; ++i) {
            userInput = br.readLine().split(" ");
            sb.append(st.sum(0, arr.length - 1, 1, Integer.parseInt(userInput[0]) - 1, Integer.parseInt(userInput[1]) - 1)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}

class SegmentTree {
    int[] arr;
    int[] tree;

    SegmentTree(int[] arr) {
        this.arr = arr;
        this.tree = new int[getSquared(arr.length) * 2];
    }

    int getSquared(int n) {
        int x = 1;
        while (Math.pow(2, x) < n) {
            x++;
        }
        n = (int)Math.pow(2, x);

        return n;
    }

    int init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start];

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    void update(int start, int end, int node, int pos, int dif) {
        if (pos < start || pos > end) return;

        tree[node] += dif;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, pos, dif);
        update(mid + 1, end, node * 2 + 1, pos, dif);
    }

    int sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) return 0;
        else if (left <= start && right >= end) return tree[node];
        else {
            int mid = (start + end) / 2;
            return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
        }
    }
}