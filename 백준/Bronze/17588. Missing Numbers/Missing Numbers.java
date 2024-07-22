import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        int max = 0;
        
        boolean[] check = new boolean[200];
        boolean done = true;
        
        for (int i = 0; i < size; i++) {
            int input = sc.nextInt();
            
            if (input >= 1 && input <= 200) {
                check[input - 1] = true;
            }
            
            if (max <= input) {
                max = input;
            }
        }

        for (int i = 0; i < max; i++) {
            if (!check[i]) {
                System.out.println(i + 1);
                done = false;
            }
        }
        
        if (done != false) {
            System.out.println("good job");
        }
    }
}