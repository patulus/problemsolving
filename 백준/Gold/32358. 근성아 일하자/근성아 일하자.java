import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   32358
 * @problemTitle    근성아 일하자
 */

public final class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 효율적인 좌표 찾기를 찾기 위해 균형 잡힌 이진 탐색 트리인 레드-블랙 트리를 생성한다.
        TreeSet<Integer> coordinates = new TreeSet<>();

        // 근성이의 위치를 저장한다.
        int pos = 0;
        int temp = 0;
        long totalDistance = 0;

        // 첫 번째 줄에 쿼리의 개수를 입력 받는다.
        int numOfQueries = Integer.parseInt(br.readLine());

        String[] userInput = null;
        while (numOfQueries > 0) {
            userInput = br.readLine().split(" ");

            switch (userInput[0]) {
                case "1":
                    // 쓰레기 좌표를 레드-블랙 트리에 삽입한다.
                    coordinates.add(Integer.valueOf(userInput[1]));
                    break;
                case "2":
                    // 모든 쓰레기를 수거할 때까지 쓰레기가 있는 가장 가까운 나무로 이동해 쓰레기를 수거한다.
                    while (coordinates.size() > 0) {
                        // 선택된 나무에서 쓰레기를 줍고 해당 위치를 기록합니다.
                        temp = findTrash(coordinates, pos);
                        // 이동한 거리를 더합니다.
                        totalDistance += Math.abs(pos - temp);
                        // 선택된 나무의 위치로 근성이의 위치를 정합니다.
                        pos = temp;
                    }
                    break;
                default:
                    System.out.println("Oops! 일어나서는 안 되는 예기치 못한 오류가 발생했습니다.");
                    break;
            }

            --numOfQueries;
        }

        bw.write(String.format("%d\n", totalDistance));
        bw.flush();

        bw.close();
        br.close();
    }

    private static int findTrash(TreeSet<Integer> coordinates, int pos) {
        // pos보다 작은 가장 가까운 위치를 가져옵니다.
        Integer lower = coordinates.lower(pos);
        // pos보다 큰 가장 가까운 위치를 가져옵니다.
        Integer higher = coordinates.higher(pos);

        Integer selected = null;
        // 가장 가까운 나무를 선택합니다.
        if (lower == null && higher == null) {
            // 쓰레기가 버려진 나무가 없으면 선택하지 않습니다.
            selected = 0;
        } else if (lower == null && higher != null) {
            selected = higher;
        } else if (lower != null && higher == null) {
            selected = lower;
        } else {
            // 가장 가까운 나무가 두 그루 이상이라면 좌표가 가장 가까운 나무로 이동합니다.
            if (Math.abs(pos - lower) <= Math.abs(pos - higher)) {
                selected = lower;
            } else {
                selected = higher;
            }
        }

        // 선택된 쓰레기가 버려진 나무를 목록에서 삭제합니다.
        coordinates.remove(selected);
        return selected;
    }
}