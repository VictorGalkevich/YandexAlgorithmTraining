package training4.taskD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TravellingSalesmanProblem {
    static long[][] adjacencyMatrix;
    static long[][] dp;
    static int numberOfVertices;
    public static void main(String[] args) throws FileNotFoundException {
        FastReader scanner = new FastReader();
        numberOfVertices = scanner.nextInt();
        adjacencyMatrix = new long[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        dp = new long[numberOfVertices][(int) Math.pow(2, numberOfVertices)];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < Math.pow(2, numberOfVertices); j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        if (numberOfVertices == 1) {
            System.out.println(0);
        } else {
            System.out.println(findShortestPath(0, (int) Math.pow(2, numberOfVertices) - 1) == Integer.MAX_VALUE ? -1 : findShortestPath(0, (int) Math.pow(2, numberOfVertices) - 1));
        }
    }

    public static long findShortestPath(int i, int mask) {
        if (dp[i][mask] != Integer.MAX_VALUE) {
            return dp[i][mask];
        }
        for (int j = 0; j < numberOfVertices; j++) {
            if (adjacencyMatrix[i][j] != 0 && ((mask >> j) & 1) == 1) {
                dp[i][mask] = Math.min(dp[i][mask], findShortestPath(j, mask - (int) Math.pow(2, j)) + adjacencyMatrix[i][j]);
            }
        }
        return dp[i][mask];
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
