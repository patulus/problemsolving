import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 상품 구매 장려를 위해 두 개 이상의 같은 상품을 구매하면 한 개 외의 추가 품목들에 대해 할인된 가격을 적용
        int loopCnt = Integer.parseInt(br.readLine());
        String[] userInput;
        
        int cntItem;
        int itemPrice;
        int sum = 0;
        
        for (int i = 0; i < loopCnt; i++) {
            userInput = br.readLine().split(" ");
            
            cntItem = Integer.parseInt(userInput[0]);
            itemPrice = Integer.parseInt(userInput[1]);
            
            bw.write(cntItem + " " + itemPrice + "\n");
            
            sum += itemPrice;
            for (int j = 1; j < cntItem; j++) {
                sum += itemPrice - 2;
            }
            
            bw.write(sum + "\n");
            
            sum = 0;
        }
        
        bw.flush();
        
        br.close();
        bw.close();
    }
}