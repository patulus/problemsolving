import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @problemWebsite  acmicpc.net
 * @problemNumber   3190
 * @problemTitle    뱀
 */

class Snake {
    // 뱀 부위의 위치
    private int x, y;
    
    Snake(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int i;
        String[] userInput;
        
        int N = Integer.parseInt(br.readLine()); // 보드의 크기
        int K = Integer.parseInt(br.readLine()); // 사과의 개수
        
        // 보드 초기화
        // 0이면 사과가 없는 칸, 1이면 사과가 있는 칸, 2는 뱀이 있는 칸
        int[][] board = new int[N][N];
        for (i = 0; i < K; i++) {
            userInput = br.readLine().split(" ");
            board[Integer.parseInt(userInput[0])-1][Integer.parseInt(userInput[1])-1] = 1;
        }
        
        // 뱀의 방향 변환 정보 초기화
        int L = Integer.parseInt(br.readLine()); // 뱀의 방향 전환 횟수
        int[][] directionChangeInfo = new int[L][2];
        for (i = 0; i < L; i++) {
            userInput = br.readLine().split(" ");
            directionChangeInfo[i][0] = Integer.parseInt(userInput[0]);
            directionChangeInfo[i][1] = userInput[1].equals("L") ? -1 : 1; // -1은 왼쪽으로 90도 회전, 1은 오른쪽으로 90도 회전
        }
        
        int sec = 0; // 게임 시작 후 지난 시간
        int seeDirection = 1; // 뱀이 보고 있는 방향 0: 위쪽, 1: 오른쪽, 2: 아래쪽, 3: 왼쪽
        int[][] newPosition = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} }; // col: x, row: y
        
        Deque<Snake> snake = new ArrayDeque<>(); // 뱀 머리, 몸통, 꼬리의 위치 정보
        snake.offer(new Snake(0, 0)); // 시작 위치는 맨 위 맨 좌측 (1행 1열)
        board[0][0] = 2;
        
        Snake head;
        int directionChangeInfoIdx = 0; // 방향 전환 정보 확인 인덱스
        while (!snake.isEmpty()) {
            
            // 뱀 머리 위치 확인
            head = snake.getFirst();
            
            sec++;
            
            if (!chkGo(board, head.getX() + newPosition[seeDirection][0], head.getY() + newPosition[seeDirection][1])) { // 다음 칸으로 갈 수 없으면 게임 종료
                break;
            }
            
            if (hasApple(board, head.getX() + newPosition[seeDirection][0], head.getY() + newPosition[seeDirection][1])) { // 다음 칸에 사과가 있으면
//                System.out.println("(" + (head.getX() + newPosition[seeDirection][0]) + ", " + (head.getY() + newPosition[seeDirection][1]) + ") 위치의 사과를 먹었다!");
                board[head.getX() + newPosition[seeDirection][0]][head.getY() + newPosition[seeDirection][1]] = 0; // 그 칸에 있던 사과가 없어지고 꼬리는 움직이지 않음
            } else {
                board[snake.getLast().getX()][snake.getLast().getY()] = 0;
                snake.pollLast(); // 몸길이를 줄여서 꼬리가 위치한 칸을 비워줌 (즉, 몸길이는 변하지 않는다)
            }
            head = new Snake(head.getX() + newPosition[seeDirection][0], head.getY() + newPosition[seeDirection][1]); // 다음 칸에 뱀 몸길이를 늘림
            snake.offerFirst(head);
            board[head.getX()][head.getY()] = 2;
            
//            System.out.println("[현재 뱀의 위치] (현재 시각: " + sec + "초)");
//            for (Snake s : snake) {
//                System.out.print("(" + (s.getX()+1) + ", " + (s.getY()+1) + ") ");
//            }
//            System.out.println();
            
            // 게임 시작 x초 후 뱀의 방향을 전환해야 하는지 확인
            if (directionChangeInfoIdx < directionChangeInfo.length && sec == directionChangeInfo[directionChangeInfoIdx][0]) {
//                System.out.print("뱀이 바라보는 방향을 기준으로 ");
//                showDirection(seeDirection);
//                System.out.print("에서 ");
                seeDirection = setSeeDirection(seeDirection, directionChangeInfo[directionChangeInfoIdx][1]);
//                showDirection(seeDirection);
//                System.out.println("로 변경");
                directionChangeInfoIdx++;
            }
        }
        
        bw.write(sec + "\n");
        bw.flush();
        
        bw.close();
        br.close();
    }
    
    // x와 y가 구간 [0, limit) 내에 위치하고, 자신의 몸과 충돌하지 않는지 확인
    private static boolean chkGo(int[][] board, int x, int y) {
        return (0 <= x && x < board[0].length) && (0 <= y && y < board.length) && (board[x][y] != 2);
    }
    
    // 해당 위치에 사과가 있는지 확인
    private static boolean hasApple(int[][] board, int x, int y) {
        return board[x][y] == 1;
    }
    
    // 뱀이 바라보는 방향 설정
    private static int setSeeDirection(int seeDirection, int directionChangeCriteria) {
        switch (seeDirection) {
            case 0: // 뱀이 위쪽을 바라보고 있음
                if (directionChangeCriteria == -1) { // 왼쪽으로 90도 회전 시
                    return 3; // 뱀은 왼쪽을 바라보게 됨 (보드 왼쪽)
                } else { // 오른쪽으로 90도 회전 시
                    return 1; // 뱀은 오른쪽을 바라보게 됨 (보드 오른쪽)
                }
            case 1: // 뱀이 오른쪽을 바라보고 있음
                if (directionChangeCriteria == -1) { // 왼쪽으로 90도 회전 시
                    return 0; // 뱀은 위쪽을 바라보게 됨 (보드 위쪽)
                } else { // 오른쪽으로 90도 회전 시
                    return 2; // 뱀은 아래쪽을 바라보게 됨 (보드 아래쪽)
                }
            case 2: // 뱀이 아래쪽을 바라보고 있음
                if (directionChangeCriteria == -1) { // 왼쪽으로 90도 회전 시
                    return 1; // 뱀은 왼쪽을 바라보게 됨 (보드 오른쪽)
                } else { // 오른쪽으로 90도 회전 시
                    return 3; // 뱀은 오른쪽을 바라보게 됨 (보드 왼쪽)
                }
            case 3: // 뱀이 왼쪽을 바라보고 있음
                if (directionChangeCriteria == -1) { // 왼쪽으로 90도 회전 시
                    return 2; // 뱀은 아래쪽을 바라보게 됨 (보드 아래쪽)
                } else { // 오른쪽으로 90도 회전 시
                    return 0; // 뱀은 위쪽을 바라보게 됨 (보드 위쪽)
                }
        }
        
        throw new IllegalArgumentException(); // 그 외의 경우는 잘못된 입력 값임
    }
    
//    private static void showDirection(int seeDirection) {
//        if (seeDirection == 0) {
//            System.out.print("위쪽");
//        } else if (seeDirection == 1) {
//            System.out.print("오른쪽");
//        } else if (seeDirection == 2) {
//            System.out.print("아래쪽");
//        } else {
//            System.out.print("왼쪽");
//        }
//    }
}