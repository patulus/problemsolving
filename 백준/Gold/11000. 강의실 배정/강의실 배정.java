import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   11000
 * @problemTitle    강의실 배정
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;
        int N = Integer.parseInt(br.readLine());
        String[] userInput;

        Lecture[] lectureSchedule = new Lecture[N];
        for (i = 0; i < N; i++) {
            userInput = br.readLine().split(" ");
            lectureSchedule[i] = new Lecture(Integer.parseInt(userInput[0]), Integer.parseInt(userInput[1]));
        }

        // 강의가 시작하는 시각 순으로 정렬
        Arrays.sort(lectureSchedule, new Comparator<>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o1.getStart() - o2.getStart() != 0 ? o1.getStart() - o2.getStart() : o1.getEnd() - o2.getEnd();
            }
        });

        // 강의가 빨리 끝나는 순으로 정렬
        PriorityQueue<Lecture> rooms = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o1.getEnd() - o2.getEnd() != 0 ? o1.getEnd() - o2.getEnd() : o1.getStart() - o2.getStart();
            }
        });
        rooms.offer(lectureSchedule[0]);
        for (i = 1; i < N; i++) {
            // 현재 강의가 가장 빨리 끝나는 강의가 있는 회의실보다 늦은 시각에 시작되면
            if (lectureSchedule[i].getStart() >= rooms.peek().getEnd()) {
                // 해당 강의실에서 진행
                rooms.poll();
                rooms.offer(lectureSchedule[i]);
            // 현재 강의가 가장 빨리 끝나는 강의가 있는 회의실보다 빠른 시각에 시작되면
            } else {
                // 새로운 강의실에서 진행
                rooms.offer(lectureSchedule[i]);
            }
        }

        bw.write(rooms.size() + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}

class Lecture {
    private final int start, end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}