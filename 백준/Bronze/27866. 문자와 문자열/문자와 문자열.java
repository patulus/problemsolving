import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();

        int idx = Integer.parseInt(sc.nextLine()) - 1;

        System.out.println(S.charAt(idx));
    }
}