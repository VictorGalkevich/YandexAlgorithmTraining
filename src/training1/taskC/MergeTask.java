package training1.taskC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeTask {
    public static void main(String[] args) throws FileNotFoundException {
        FastReader scanner = new FastReader();
        int len1 = scanner.nextInt();
        int[] arr1 = new int[len1];
        for (int i = 0; i < len1; i++) {
            arr1[i] = scanner.nextInt();
        }
        int len2 = scanner.nextInt();
        int[] arr2 = new int[len2];
        for (int i = 0; i < len2; i++) {
            arr2[i] = scanner.nextInt();
        }
        int[] newArr = merge(arr1, arr2);
        StringBuilder builder = new StringBuilder();
        for (int i : newArr) {
            builder.append(i).append(" ");
        }
        System.out.println(builder);
    }

    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int pa = 0;
        int pb = 0;
        int i = 0;
        while (pa < a.length && pb < b.length) {
            if (a[pa] <= b[pb]) {
                res[i++] = a[pa++];
            } else {
                res[i++] = b[pb++];
            }
        }
        while (pa < a.length) {
            res[i++] = a[pa++];
        }
        while (pb < b.length) {
            res[i++] = b[pb++];
        }
        return res;
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
