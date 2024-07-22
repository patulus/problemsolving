import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] userInput = br.readLine().split(" ");

        int i;

        int S = Integer.parseInt(userInput[0]);
        int P = Integer.parseInt(userInput[1]);

        char[] DNAString = br.readLine().toCharArray();
        int[] least = new int[4];
        int[] cntDNA = new int[4];
        userInput = br.readLine().split(" ");
        for (i = 0; i < 4; ++i) {
            least[i] = Integer.parseInt(userInput[i]);
            cntDNA[i] = 0;
        }

        for (i = 0; i < P; ++i) {
            addDNA(cntDNA, DNAString[i]);
        }
        int cnt = chkDNA(least, cntDNA) ? 1 : 0;

        for (i = P; i < S; ++i) {
            addDNA(cntDNA, DNAString[i]);
            delDNA(cntDNA, DNAString[i - P]);

            if (chkDNA(least, cntDNA)) ++cnt;
        }

        bw.write(cnt + "\n");
        bw.flush();
    }

    static void addDNA(int[] cntDNA, char e) {
        switch (e) {
            case 'A':
                ++cntDNA[0];
                break;
            case 'C':
                ++cntDNA[1];
                break;
            case 'G':
                ++cntDNA[2];
                break;
            case 'T':
                ++cntDNA[3];
                break;
        }
    }

    static void delDNA(int[] cntDNA, char e) {
        switch (e) {
            case 'A':
                --cntDNA[0];
                break;
            case 'C':
                --cntDNA[1];
                break;
            case 'G':
                --cntDNA[2];
                break;
            case 'T':
                --cntDNA[3];
                break;
        }
    }

    static boolean chkDNA(int[] least, int[] cntDNA) {
        for (int i = 0; i < 4; ++i) {
            if (cntDNA[i] < least[i]) return false;
        }
        return true;
    }
}