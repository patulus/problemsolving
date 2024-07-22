import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int i, start, end, weight;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String[] userInput;
        List<List<int[]>> adjList = new ArrayList<>(new ArrayList<>());
        for (i = 0; i < N; ++i) {
            adjList.add(new ArrayList<>());
        }
        for (i = 0; i < M; ++i) {
            userInput = br.readLine().split(" ");
            start = Integer.parseInt(userInput[0]) - 1;
            end = Integer.parseInt(userInput[1]) - 1;
            weight = Integer.parseInt(userInput[2]);

            adjList.get(start).add(new int[]{start, end, weight});
        }

        userInput = br.readLine().split(" ");
        start = Integer.parseInt(userInput[0]) - 1;
        end = Integer.parseInt(userInput[1]) - 1;

        Graph g = new Graph(adjList);
        g.dijkstra(start);

        bw.write(g.distance[end] + "\n");
        bw.flush();
    }
}

class Graph {
    List<List<int[]>> adjList;
    int[] distance;

    Graph(List<List<int[]>> adjList) {
        this.adjList = adjList;
        this.distance = new int[adjList.size()];
        for (int i = 0; i < distance.length; ++i) {
            distance[i] = Integer.MAX_VALUE;
        }
    }

    void dijkstra(int s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        pq.offer(new int[]{s,s,0});
        distance[s] = 0;

        int[] e;
        while (!pq.isEmpty()) {
            e = pq.poll();

            if (distance[e[1]] < e[2]) continue;

            for (int[] edge : adjList.get(e[1])) {
                if (distance[edge[0]] + edge[2] < distance[edge[1]]) {
                    distance[edge[1]] = distance[edge[0]] + edge[2];
                    pq.add(edge);
                }
            }
        }
    }
}