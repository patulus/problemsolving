import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class SelfNumber {
    int df(int arg) {
        int result = arg;
        String tmp = Integer.toString(arg);

        for (int i : tmp.toCharArray()) {
            result += i - '0';
        }

        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        SelfNumber sn = new SelfNumber();
        HashSet<Integer> set = new HashSet<>(IntStream.range(1, 10001).boxed().collect(Collectors.toList()));

        for (int i = 1; i <= 10000; i++) {
            set.remove(sn.df(i));
        }

        for (int i : set) {
            System.out.println(i);
        }
    }
}