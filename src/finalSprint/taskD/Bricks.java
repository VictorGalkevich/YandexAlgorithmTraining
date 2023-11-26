package finalSprint.taskD;

import java.io.*;
import java.util.StringTokenizer;

public class Bricks {
    static int find;
    static int numberOfValues;
    static int[] values;
    static boolean overflow = false;
    static String finalString;
    static int numberOfBanknotes = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        FastReader scanner =  new FastReader();
        find = scanner.nextInt();
        numberOfValues = scanner.nextInt();
        values = new int[2 * numberOfValues];
        int sum = 0;
        for (int i = 0; i < numberOfValues * 2 - 1; i += 2) {
            int tmp = scanner.nextInt();
            values[i] = tmp;
            values[i + 1] = tmp;
            sum += tmp * 2;
        }
        if (sum < find) {
            System.out.println(-1);
            System.exit(0);
        }
        find(values, find, 2 * numberOfValues - 1, "", 0);
        if (numberOfBanknotes != Integer.MAX_VALUE) {
            System.out.println(numberOfBanknotes);
            System.out.println(finalString.trim());
        } else if (overflow) {
            System.out.println(0);
        } else {
            System.out.println(-1);
        }
    }

    public static void find(int[] values, int n, int index, String result, int counter) {
        if (n < 0) {
            overflow = true;
            return;
        } else if (n == 0) {
            if (counter < numberOfBanknotes) {
                numberOfBanknotes = counter;
                finalString = result;
            }
            return;
        }
        if (counter >= numberOfBanknotes) {
            return;
        }
        if (index < 0) {
            return;
        }
        find(values, n - values[index], index - 1, result + values[index] + " ", counter + 1);
        find(values, n, index - 1, result, counter);
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
