import java.io.*;

public class Main {
    static void addEdge(boolean[][] adjMatrix, int u, int v) {
        adjMatrix[u][v] = adjMatrix[v][u] = true;
    }

    static StringBuilder sb = new StringBuilder();

    static void dfs(boolean[][] adjMatrix, boolean[] visited, int v) {
        visited[v] = true;
        sb.append(v + 1).append(" ");

        for (int w = 0; w < adjMatrix.length; w++) {
            if (adjMatrix[v][w] && !visited[w]) {
                dfs(adjMatrix, visited, w);
            }
        }
    }

    static void bfs(boolean[][] adjMatrix, boolean[] visited, int v) {
        int[] queue = new int[adjMatrix.length + 1];
        int front = 0;
        int rear = 0;

        rear = (rear + 1) % adjMatrix.length;
        queue[rear] = v;
        visited[v] = true;
        sb.append(v + 1).append(" ");

        while (front != rear) {
            front = (front + 1) % adjMatrix.length;
            v = queue[front];

            for (int w = 0; w < adjMatrix.length; w++) {
                if (adjMatrix[v][w] && !visited[w]) {
                    rear = (rear + 1) % adjMatrix.length;
                    queue[rear] = w;
                    visited[w] = true;
                    sb.append(w + 1).append(" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정점의 개수, 간선의 개수, 탐색 시작 정점
        String[] userInputSplit = br.readLine().split(" ");
        int numVertex = Integer.parseInt(userInputSplit[0]);
        int numEdge = Integer.parseInt(userInputSplit[1]);
        int start = Integer.parseInt(userInputSplit[2]);

        // 인접 행렬 간선 추가
        int iter = 0;
        boolean[][] adjMatrix = new boolean[numVertex][numVertex];
        for (iter = 0; iter < numEdge; iter++) {
            userInputSplit = br.readLine().split(" ");
            addEdge(adjMatrix, Integer.parseInt(userInputSplit[0]) - 1, Integer.parseInt(userInputSplit[1]) - 1);
        }

        // DFS
        boolean[] visited = new boolean[numVertex];
        for (iter = 0; iter < numVertex; iter++) {
            visited[iter] = false;
        }

        dfs(adjMatrix, visited, start - 1);
        sb.append("\n");

        // BFS
        for (iter = 0; iter < numVertex; iter++) {
            visited[iter] = false;
        }

        bfs(adjMatrix, visited, start - 1);
        sb.append("\n");

        // 결과 출력
        bw.write(sb.toString());
        bw.flush();
    }
}