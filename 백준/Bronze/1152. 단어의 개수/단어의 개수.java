import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String fullStr = sc.nextLine();
        String[] splitedStr = fullStr.trim().split(" ");
        
        if (splitedStr.length == 1 && splitedStr[0].equals("")) {
            System.out.println(0);
        }
        else {
            System.out.println(splitedStr.length);
        }
    }
}
