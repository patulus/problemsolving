import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        OutputStream out = System.out;
        OutputStreamWriter writer = new OutputStreamWriter(out);
        BufferedWriter bw = new BufferedWriter(writer);

        int numsOfIter = Integer.parseInt(br.readLine());
        int[][] loc = new int[numsOfIter][2];

        for (int locIdx = 0; locIdx < numsOfIter; locIdx++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input, " "); // Seperate string to tokens based on space

            loc[locIdx][0] = Integer.parseInt(st.nextToken()); // x-coordinate
            loc[locIdx][1] = Integer.parseInt(st.nextToken()); // y-coordinate
        }

        // Sort (y-coordinate ascending order / if y-coordinate is same, x-coordinate ascending order)
        Arrays.sort(loc, (e1, e2) -> {
            if (e1[1] - e2[1] == 0) {
                return e1[0]- e2[0];
            }
            else {
                return e1[1] - e2[1];
            }
        });

        // Print result
        for (int printIdx = 0; printIdx < loc.length; printIdx++) {
            bw.write(loc[printIdx][0] + " " + loc[printIdx][1] + " \n");
        }
        bw.flush();
    }
}