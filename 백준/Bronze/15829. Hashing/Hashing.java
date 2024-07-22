import java.io.*;

public class Main {
    static long hashing(int length, String key) {
        long result = 0;
        long pow = 1;
        for (int i = 0; i < length; i++) {
            result += pow * (key.charAt(i) - 'a' + 1);
            pow = (pow * 31) % 1234567891;
        }
        return result % 1234567891;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int keyLength = Integer.parseInt(br.readLine());
        String str = Long.toString(hashing(keyLength, br.readLine()));

        bw.write(str);
        bw.flush();
    }
}