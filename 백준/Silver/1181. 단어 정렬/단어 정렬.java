import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int compareLength = o1.length() - o2.length();
                return (compareLength == 0) ? o1.compareTo(o2) : compareLength;
            }
        });

        for (int i = 0; i < n; i++) {
            if (i < n - 1 && words[i + 1].equals(words[i])) continue;
            sb.append(words[i]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}