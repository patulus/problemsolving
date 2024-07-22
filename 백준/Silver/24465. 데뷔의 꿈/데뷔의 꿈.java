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

public class Main {
    public static String findJari(String[] date) {
        switch (date[0]) {
            case "1":
                if (Integer.parseInt(date[1]) >= 20) {
                    return "Mulbyeong";
                } else {
                    return "Yeomso";
                }
            case "2":
                if (Integer.parseInt(date[1]) >= 19) {
                    return "Mulgogi";
                } else {
                    return "Mulbyeong";
                }
            case "3":
                if (Integer.parseInt(date[1]) >= 21) {
                    return "Yang";
                } else {
                    return "Mulgogi";
                }
            case "4":
                if (Integer.parseInt(date[1]) >= 20) {
                    return "Hwangso";
                } else {
                    return "Yang";
                }
            case "5":
                if (Integer.parseInt(date[1]) >= 21) {
                    return "Ssangdungi";
                } else {
                    return "Hwangso";
                }
            case "6":
                if (Integer.parseInt(date[1]) >= 22) {
                    return "Gae";
                } else {
                    return "Ssangdungi";
                }
            case "7":
                if (Integer.parseInt(date[1]) >= 23) {
                    return "Saja";
                } else {
                    return "Gae";
                }
            case "8":
                if (Integer.parseInt(date[1]) >= 23) {
                    return "Cheonyeo";
                } else {
                    return "Saja";
                }
            case "9":
                if (Integer.parseInt(date[1]) >= 23) {
                    return "Cheonching";
                } else {
                    return "Cheonyeo";
                }
            case "10":
                if (Integer.parseInt(date[1]) >= 23) {
                    return "Jeongal";
                } else {
                    return "Cheonching";
                }
            case "11":
                if (Integer.parseInt(date[1]) >= 23) {
                    return "Sasu";
                } else {
                    return "Jeongal";
                }
            case "12":
                if (Integer.parseInt(date[1]) >= 22) {
                    return "Yeomso";
                } else {
                    return "Sasu";
                }
        }
        
        return null;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int i;
        String[] userInput;

        String[][] arrWolle = new String[7][2];
        Set<String> jariWolle = new HashSet<>();
        for (i = 0; i < 7; i++) {
            userInput = br.readLine().split(" ");
            
            arrWolle[i] = userInput;
            jariWolle.add(findJari(userInput));
        }
        
        int N = Integer.parseInt(br.readLine());
        String[][] arrJiwon = new String[N][2];
        for (i = 0; i < N; i++) {
            userInput = br.readLine().split(" ");
            
            arrJiwon[i] = userInput;
        }
        
        List<String[]> sus = new ArrayList<>();
        for (i = 0; i < N; i++) {
            if (!jariWolle.contains(findJari(arrJiwon[i]))) {
                sus.add(arrJiwon[i]);
            }
        }
        
        if (!sus.isEmpty()) {
            sus.sort(new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    if (o1[0].equals(o2[0])) {
                        return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                    }
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
            });
            for (String[] e : sus) {
                bw.write(e[0] + " " + e[1] + "\n");
            }
        } else {
            bw.write("ALL FAILED\n");
        }
        bw.flush();
        
        bw.close();
        br.close();
    }
}