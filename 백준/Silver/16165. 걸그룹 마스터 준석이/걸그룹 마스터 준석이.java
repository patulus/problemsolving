import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   16165
 * @problemTitle    걸그룹 마스터 준석이
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int i, j;
        
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]); // 입력받을 걸그룹의 수
        int M = Integer.parseInt(NM[1]); // 맞춰야 하는 문제의 수
        
        Set<String> group;
        int G; // 해당 그룹의 인원 수
        
        Map<String, Set<String>> girlGroups = new HashMap<>();
        for (i = 0; i < N; i++) {
            group = new HashSet<>();
            girlGroups.put(br.readLine(), group);
            
            G = Integer.parseInt(br.readLine());
            for (j = 0; j < G; j++) {
                group.add(br.readLine());
            }
        }
        
        List<String> sortedGroupMember;
        String name;
        int sel;
        
        for (i = 0; i < M; i++) {
            name = br.readLine();
            sel = Integer.parseInt(br.readLine());
            
            switch (sel) {
                case 0:
                    sortedGroupMember = new ArrayList<>(girlGroups.get(name));
                    sortedGroupMember.sort(new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return o1.compareTo(o2);
                        }
                    });
                    for (String member : sortedGroupMember) {
                        bw.write(member);
                        bw.write('\n');
                    }
                    break;
                case 1:
                    for (String groupName : girlGroups.keySet()) {
                        if (girlGroups.get(groupName).contains(name)) {
                            bw.write(groupName);
                            bw.write('\n');
                        }
                    }
                    break;
            }
        }
        
        bw.flush();
        
        bw.close();
        br.close();
    }
}