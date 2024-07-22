import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 길이 N과 구하고자 하는 합 S를 입력 받기
        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]);
        int S = Integer.parseInt(userInput[1]);
        
        // 각 원소가 공백으로 구분된 수열을 입력 받기
        // 문자열 배열을 int형 배열로 만들기
        userInput = br.readLine().split(" ");
        int[] arr = new int[userInput.length];
        
        int i;
        // arr = Arrays.stream(userInput).mapToInt(Integer::parseInt).toArray();
        for (i = 0; i < userInput.length; i++) {
            arr[i] = Integer.parseInt(userInput[i]);
        }
        
        // 투 포인터를 이용해 구하고자 하는 합 이상이 되는 최소 길이를 구하기
        int low = 0;
        int high = 0;
        int sum = arr[low];
        int minLength = N + 1;
        
        while (true) {
            // sum이 구하고자 하는 합보다 작은 경우 high 인덱스 증가
            if (sum < S) {
                high++;
                
                // 인덱스 범위를 벗어나면 중단
                if (high == N) break;
                
                // 벗어나지 않으면 sum에 합산
                sum += arr[high];
            } else { // sum이 구하고자 하는 합보다 크거나 같은 경우
                // 이전에 구한 최소 길이와 비교해 작은 것을 선택
                minLength = Math.min(minLength, high - low + 1);
                
                // sum이 S보다 큰 경우의 다른 최소 길이를 찾기 위해 low 인덱스 증가
                sum -= arr[low];
                low++;
            }
        }
        
        bw.write((minLength == N + 1 ? 0 : minLength) + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
}