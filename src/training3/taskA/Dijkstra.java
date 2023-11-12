package training3.taskA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dijkstra {
    static int[] dist;
    static boolean[] visited;
    static int[][] adjacencyMatrix;
    static int numberOfRoots;
    static int startRootNumber;
    static int endRootNumber;
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        numberOfRoots = scanner.nextInt();
        startRootNumber = scanner.nextInt();
        endRootNumber = scanner.nextInt();
        adjacencyMatrix = new int[numberOfRoots][numberOfRoots];
        for (int i = 0; i < numberOfRoots; i++) {
            for (int j = 0; j < numberOfRoots; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        dist = new int[numberOfRoots];
        for (int i = 0; i < numberOfRoots; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        visited = new boolean[numberOfRoots];
        dijkstra();
        System.out.println(dist[endRootNumber - 1] == Integer.MAX_VALUE ? -1 : dist[endRootNumber - 1]);
    }

    public static void dijkstra() {
        dist[startRootNumber - 1] = 0;

        for (int i = 0; i < numberOfRoots; i++) {
            int closestRoot = findMin();

            visited[closestRoot] = true;


            for (int j = 0; j < numberOfRoots; j++) {
                if (adjacencyMatrix[closestRoot][j] > 0 && !visited[j] && dist[closestRoot] != Integer.MAX_VALUE) {
                    int newPathDist = adjacencyMatrix[closestRoot][j] + dist[closestRoot];
                    if (newPathDist < dist[j]) {
                        dist[j] = newPathDist;
                    }
                }
            }
        }

    }

    public static int findMin() {
        int minRoot = -1;

        for (int i = 0; i < numberOfRoots; i++) {
            if (!visited[i] && (minRoot == -1 || dist[i] < dist[minRoot])) {
                minRoot = i;
            }
        }

        return minRoot;
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
