import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[10];

        for (int i = 0; i < 10; i++) {
            input[i] = sc.nextInt();
        }

        int[] remain = new int[10];
        int now = 0;
        int temp = 0;

        for (int i = 0; i < 10; i++) {
            remain[i] = -1;
        }

        for (int i = 0; i < 10; i++) {
            temp = 0;

            int rf = input[i] % 42;

            for (int j = 0; j < 10; j++) {
                if (remain[j] == rf) {
                    temp = 0;
                    break;
                }
                else {
                    temp = 1;
                }
            }

            if (temp == 1) {
                remain[now] = rf;
                now++;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (remain[i] == -1) {
                temp = i;
                break;
            }
            else {
                temp = 10;
            }
        }

        System.out.println(temp);
    }
}
