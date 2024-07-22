import java.io.*;

public class Main {
    static void insertionSortForShellSort(int[] arr, int start, int end, int gap) {
        int i, j, key;

        for (i = start + gap; i <= end; i += gap) {
            key = arr[i];

            for (j = i - gap; j >= start && arr[j] > key; j -= gap) {
                arr[j + gap] = arr[j];
            }
            arr[j + gap] = key;
        }
    }
    static void shellSort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < gap; i++) {
                insertionSortForShellSort(arr, i, arr.length - 1, gap);
            }
        }
    }

    static void sort(int[] arr) {
        shellSort(arr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int i;
        for (i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        sort(arr);

        for (i = 0; i < N; i++) {
            sb.append(arr[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}