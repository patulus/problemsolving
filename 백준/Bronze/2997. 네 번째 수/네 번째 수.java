import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int[] answer = new int[3];
        int d1 = 0;
        int d2 = 0;
        
        for (int i = 0; i < 3; i++) {
            answer[i] = sc.nextInt();
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                if (answer[j - 1] >= answer[j]) {
                    int temp = answer[j - 1];
                    answer[j - 1] = answer[j];
                    answer[j] = temp;
                }
            }
        }
        
        d1 = answer[1] - answer[0];
        d2 = answer[2] - answer[1];
        
        if (d1 > d2) System.out.println(answer[0] + d2);
        else if (d1 == d2) System.out.println(answer[2] + d1);
        else System.out.println(answer[1] + d1);
    }
}