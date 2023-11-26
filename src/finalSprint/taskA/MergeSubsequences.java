package finalSprint.taskA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSubsequences {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());

        long[] sequenceC = new long[x];

        int indexA = 0;
        int indexB = 0;
        int indexC = 0;

        while (indexC < x) {
            long nextA = (long) Math.pow(indexA + 1, 2);
            long nextB = (long) Math.pow(indexB + 1, 3);

            if (nextA < nextB) {
                sequenceC[indexC++] = nextA;
                indexA++;
            } else if (nextA > nextB) {
                sequenceC[indexC++] = nextB;
                indexB++;
            } else {
                sequenceC[indexC++] = nextA;
                indexA++;
                indexB++;
            }
        }

        System.out.println(sequenceC[x - 1]);
    }
}