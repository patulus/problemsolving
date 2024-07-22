import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine().toUpperCase();
        
        int[] cnt = new int[26];
        
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 'A']++;
        }
        
        int max = -1;
        char ch = '?';
        
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                ch = (char)(i + 65);
            }
            else if (cnt[i] == max) {
                ch = '?';
            }
        }
        
        System.out.println(ch);
    }
}