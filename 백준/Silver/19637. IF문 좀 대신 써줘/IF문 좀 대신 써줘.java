import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   19637
 * @problemTitle    IF문 좀 대신 써줘
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int i;

        String[] userInput = br.readLine().split(" ");
        int N = Integer.parseInt(userInput[0]); // 칭호의 개수
        int M = Integer.parseInt(userInput[1]); // 출력해야 하는 캐릭터의 수

        List<Title> title = new ArrayList<>(); // 칭호 이름 및 걸맞는 전투력
        Set<Integer> chkStrength = new HashSet<>(); // 전투력이 같은 칭호 등록 방지
        for (i = 0; i < N; i++) {
            userInput = br.readLine().split(" ");
            if (!chkStrength.contains(Integer.parseInt(userInput[1]))) {
                title.add(new Title(userInput[0], Integer.parseInt(userInput[1])));
                chkStrength.add(Integer.parseInt(userInput[1]));
            }
        }

        // 이분 탐색을 위한 칭호 배열 정렬
        title.sort(new Comparator<Title>() {
            @Override
            public int compare(Title o1, Title o2) {
                return o1.getStrength() - o2.getStrength();
            }
        });

        int characterStrength; // 입력되는 캐릭터 전투력
        Title characterTitle; // 선택되는 캐릭터 칭호
        int searchIdxLower, searchIdxMiddle, searchIdxUpper;
        for (i = 0; i < M; i++) {
            characterStrength = Integer.parseInt(br.readLine());

            characterTitle = title.get(title.size() - 1);
            searchIdxLower = 0;
            searchIdxUpper = title.size() - 1;
            while (searchIdxLower <= searchIdxUpper) {
                searchIdxMiddle = (searchIdxLower + searchIdxUpper) / 2;

                if (title.get(searchIdxMiddle).getStrength() < characterStrength) { // 캐릭터의 전투력이 칭호의 전투력 상한값보다 높으면
                    searchIdxLower = searchIdxMiddle + 1; // 더 높은 전투력을 가진 칭호가 있는지 탐색
                } else { // 캐릭터의 전투력이 칭호의 전투력 상한값보다 낮거나 같으면
                    characterTitle = title.get(searchIdxMiddle); // 해당 칭호를 선택
                    searchIdxUpper = searchIdxMiddle - 1; // 캐릭터의 전투력과 가까운 칭호가 있는지 탐색
                }
            }

            sb.append(characterTitle.getTitleName()).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}

class Title {
    private final String titleName; // 칭호명
    private final int strength; // 칭호에 걸맞는 전투력

    public Title(String titleName, int strength) {
        this.titleName = titleName;
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public String getTitleName() {
        return titleName;
    }
}