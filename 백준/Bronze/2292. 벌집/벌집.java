import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int nums_pileup = 1;
        int cnt = 1;

        while (input > nums_pileup) {
            nums_pileup += 6 * cnt;
            cnt += 1;
        }

        System.out.println(cnt);
    }
}