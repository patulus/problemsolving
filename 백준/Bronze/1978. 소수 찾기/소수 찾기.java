import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class PrimeNumber {
    boolean[] primeNumberArray;
    PrimeNumber() {
        primeNumberArray = new boolean[1001];

        primeNumberArray[0] = false; primeNumberArray[1] = false;
        for (int i = 2; i <= 1000; i++) {
            primeNumberArray[i] = true;
        }

        for (int i = 2; i <= 1000; i++) {
            if (primeNumberArray[i]) {
                for (int j = i+i; j <= 1000; j += i) {
                    primeNumberArray[j] = false;
                }
            }
        }
    }

    boolean isPrimeNumber(int N) {
        return primeNumberArray[N];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        PrimeNumber pn = new PrimeNumber();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numEA = Integer.parseInt(br.readLine());
        int cnt = 0;
        String[] checkNums = br.readLine().split(" ");
        for (String n : checkNums) {
            if (pn.isPrimeNumber(Integer.parseInt(n))) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}