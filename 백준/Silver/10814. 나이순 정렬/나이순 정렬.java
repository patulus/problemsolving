import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 * BOJ#10814 나이순 정렬
 */
public final class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tokens;
        int i, age;
        String name;

        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];
        for (i = 0; i < N; ++i) {
            tokens = br.readLine().split(" ");
            age = Integer.parseInt(tokens[0]);
            name = tokens[1];

            members[i] = new Member(i, age, name);
        }

        Arrays.sort(members);

        for (i = 0; i < N; ++i) {
            sb.append(members[i].age).append(" ").append(members[i].name).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}

class Member implements Comparable<Member> {
    int enter;
    int age;
    String name;

    Member(int enter, int age, String name) {
        this.enter = enter;
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Member o) {
        int compAge = this.age - o.age;
        return compAge != 0 ? compAge : this.enter - o.enter;
    }
}
