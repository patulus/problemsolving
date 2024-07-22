import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;

public class Main {
    static int blackJack(int[] nums, int M) {
        int maxValue = 0;
        int temp = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    temp = nums[i] + nums[j] + nums[k];
                    if (temp > maxValue && temp <= M) {
                        maxValue = temp;
                    }
                }
            }
        }

        return maxValue;
    }

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String userInput;
        String[] userInputAry;
        userInput = br.readLine();
        userInputAry = userInput.split(" ");

        int n = Integer.parseInt(userInputAry[0]);
        int M = Integer.parseInt(userInputAry[1]);


        int[] nums;
        userInput = br.readLine();
        userInputAry = userInput.split(" ");
        nums = Arrays.stream(userInputAry).mapToInt(Integer::parseInt).toArray();

        System.out.println(blackJack(nums, M));
    }
}