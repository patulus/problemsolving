import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

class Student {
    String name;
    int scoreKorean, scoreEnglish, scoreMath;

    Student(String name, int scoreKorean, int scoreEnglish, int scoreMath) {
        this.name = name;
        this.scoreKorean = scoreKorean;
        this.scoreEnglish = scoreEnglish;
        this.scoreMath = scoreMath;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        String[] userInput;
        int i;

        for (i = 0; i < N; i++) {
            userInput = br.readLine().split(" ");

            students[i] = new Student(userInput[0], Integer.parseInt(userInput[1]), Integer.parseInt(userInput[2]), Integer.parseInt(userInput[3]));
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int val = o2.scoreKorean - o1.scoreKorean;

                if (val == 0) {
                    val = o1.scoreEnglish - o2.scoreEnglish;

                    if (val == 0) {
                        val = o2.scoreMath - o1.scoreMath;

                        if (val == 0) {
                            val = o1.name.compareTo(o2.name);
                        }
                    }
                }

                return val;
            }
        });

        for (i = 0; i < N; i++) {
            sb.append(students[i].name).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}