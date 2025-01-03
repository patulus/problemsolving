import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        String[] tokens = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        int key = Integer.parseInt(br.readLine());
        bw.write(counting(arr, key) + "\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static int counting(int[] arr, int key) {
        int res = 0;

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == key) ++res;
        }

        return res;
    }
}
