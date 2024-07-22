import java.io.*;

public class Main {
    static boolean isPalindrome(String[] strAry) {
        if (strAry.length <= 1) return true;

        String[] stack = new String[strAry.length / 2];
        int i = 0;
        int stackSize = -1;

        for (i = 0; i < strAry.length / 2; i++) {
            stack[++stackSize] = strAry[i];
        }

        i = strAry.length / 2;
        if (strAry.length % 2 != 0) i++;

        for (; i < strAry.length; i++) {
            if (!stack[stackSize--].equals(strAry[i])) return false;
        }

        return stackSize == -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String userInput = null;

        while (true) {
            userInput = br.readLine();
            if (userInput.equals("0")) break;
            sb.append(isPalindrome(userInput.trim().split("")) ? "yes" : "no").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}