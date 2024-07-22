import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringTokenizer st = new StringTokenizer(input, " ");

        StringBuilder stringA = new StringBuilder(st.nextToken());
        StringBuilder stringB = new StringBuilder(st.nextToken());

        stringA.reverse();
        stringB.reverse();

        int numA = Integer.parseInt(stringA.toString());
        int numB = Integer.parseInt(stringB.toString());

        if (numA > numB) {
            System.out.println(numA);
        }
        else {
            System.out.println(numB);
        }
    }
}