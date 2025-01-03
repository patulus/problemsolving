import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] res = countingSort(arr);

        for (i = 0; i < N; ++i) {
            sb.append(res[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int[] countingSort(int[] arr) {
        int i;
        int max = arr[0];
        for (i = 1; i < arr.length; ++i) {
            if (max < arr[i]) max = arr[i];
        }

        int[] countAry = new int[max + 1];
        for (i = 0; i < arr.length; ++i) {
            ++countAry[arr[i]];
        }
        for (i = 1; i < countAry.length; ++i) {
            countAry[i] += countAry[i - 1];
        }

        int[] res = new int[arr.length];
        for (i = 0; i < arr.length; ++i) {
            res[countAry[arr[i]] - 1] = arr[i];
            --countAry[arr[i]];
        }

        return res;
    }
}
