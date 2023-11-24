package warmup.taskE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


public class AverageLevel {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();

        int numberOfElements = scanner.nextInt();
        int[] users = new int[numberOfElements];
        int[] sums = new int[numberOfElements];
        int sum = 0;

        for (int i = 0; i < numberOfElements; i++) {
            int tmp = scanner.nextInt();
            users[i] = tmp;
            sum += tmp;
            sums[i] = sum;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(sum - numberOfElements * users[0]).append(" ");
        for (int i = 1; i < numberOfElements; i++) {
            builder.append(sum - numberOfElements * users[i] + 2 * i * users[i] - 2 * sums[i - 1]).append(" ");
        }
        System.out.println(builder);

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
