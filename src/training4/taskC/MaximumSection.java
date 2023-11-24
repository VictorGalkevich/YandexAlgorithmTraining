package training4.taskC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSection {
    static int maxLength = 0;
    static int numberOfVertices;
    static int[][] adjacencyMatrix;
    static int maxValue;
    static int maxPermutation = 0;
    public static void main(String[] args) throws FileNotFoundException {
        FastReader scanner = new FastReader();
        numberOfVertices = scanner.nextInt();
        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        maxValue = (int) Math.pow(2, numberOfVertices);
        doCut();
        StringBuilder builder = new StringBuilder();
        builder.append(maxLength).append("\n");
        for (int i = 0; i < numberOfVertices; i++) {
            if (((maxPermutation >> i) & 1) == 1) {
                builder.append(2).append(" ");
            } else {
                builder.append(1).append(" ");
            }
        }
        System.out.println(builder);
    }

    public static void doCut() {
        for (int i = 1; i < maxValue - 1; i++) {
            int currentLength = 0;
            int mask = 0xFFFFFFFF >>> (32 - numberOfVertices);
            if (maxPermutation != (i ^ mask)) {
                for (int j = 0; j < numberOfVertices; j++) {
                    int maskBit = 1 << j;
                    if ((i & maskBit) == 0) {
                        for (int k = 0; k < numberOfVertices; k++) {
                            if (((i >> k) & 1) == 1) {
                                currentLength += adjacencyMatrix[j][k];
                            }
                        }
                    }
                }
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxPermutation = i;
            }
        }
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