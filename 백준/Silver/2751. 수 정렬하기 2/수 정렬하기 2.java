import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int i;
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>(N);
        for (i = 0; i < N; ++i) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        for (i = 0; i < N; ++i) {
            sb.append(list.get(i)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
