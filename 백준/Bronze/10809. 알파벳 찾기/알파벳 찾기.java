import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String args[]) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        
        String input = br.readLine();
        char[] input_array = input.toLowerCase().toCharArray();
        int[] alpha = new int[26];
        
        for (int i = 0; i < 26; i++) {
            alpha[i] = -1;
        }
        
        for (int i = 0; i < input_array.length; i++) {
            if (alpha[input_array[i] - 'a'] == -1) {
                alpha[input_array[i] - 'a'] = i;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            System.out.print(alpha[i] + " ");
        }
        System.out.println();
    }
}