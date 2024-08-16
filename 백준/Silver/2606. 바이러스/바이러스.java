import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @problemWebsite  acmipc.net
 * @problemNumber   2606
 * @problemTitle    바이러스
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i;
        String[] userInput;

        int numberOfComputers = Integer.parseInt(br.readLine());
        int numberOfComputerPairs = Integer.parseInt(br.readLine());

        int computerA, computerB;

        boolean[][] adjacencyMatrix = new boolean[numberOfComputers][numberOfComputers];
        boolean[] visited = new boolean[numberOfComputers];
        for (i = 0; i < numberOfComputerPairs; i++) {
            userInput = br.readLine().split(" ");

            computerA = Integer.parseInt(userInput[0]) - 1;
            computerB = Integer.parseInt(userInput[1]) - 1;

            adjacencyMatrix[computerA][computerB] = true;
            adjacencyMatrix[computerB][computerA] = true;
        }

        int numberOfComputersInfectedWithViruses = checkComputerForVirusInfection(adjacencyMatrix, visited, 0);
        bw.write(numberOfComputersInfectedWithViruses + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    private static int checkComputerForVirusInfection(boolean[][] adjacencyMatrix, boolean[] visited, int start) {
        List<Integer> stack = new ArrayList<>();
        stack.add(start);
        visited[start] = true;

        int numberOfComputersInfectedWithViruses = 0;
        int v, w;
        while (!stack.isEmpty()) {
            v = stack.remove(stack.size() - 1);

            for (w = 0; w < adjacencyMatrix.length; w++) {
                if (adjacencyMatrix[v][w] && !visited[w]) {
                    stack.add(w);
                    visited[w] = true;

                    numberOfComputersInfectedWithViruses++;
                }
            }
        }

        return numberOfComputersInfectedWithViruses;
    }
}