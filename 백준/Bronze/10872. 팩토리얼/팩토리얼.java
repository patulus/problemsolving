import java.io.*;

public class Main {
    static long factorial(int N) {
        if (N <= 1) return 1;
        else {
            return N * factorial(N - 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(Long.toString(factorial(N)));
        bw.write("\n");
        bw.flush();
    }
}