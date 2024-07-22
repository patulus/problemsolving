import java.io.*;

public class Main {
    static int[] createPrimeNumberTable(int end) {
        int[] primeNumberTable = new int[end + 1];
        int i = 0;
        int j = 0;
        for (; i < primeNumberTable.length; i++) {
            primeNumberTable[i] = i;
        }
        primeNumberTable[1] = 0;

        for (i = 2; i < primeNumberTable.length; i++) {
            if (primeNumberTable[i] == 0) continue;

            for (j = i * 2; j <= end; j += i) {
                primeNumberTable[j] = 0;
            }
        }

        return primeNumberTable;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] userInput = br.readLine().split(" ");
        int begin = Integer.parseInt(userInput[0]);
        int end = Integer.parseInt(userInput[1]);

        int[] primeTable = createPrimeNumberTable(end);
        for (; begin <= end; begin++) {
            if (primeTable[begin] != 0) {
                sb.append(primeTable[begin]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}