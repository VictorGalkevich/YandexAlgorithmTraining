package training2.taskB;

import java.util.Scanner;

public class StringBase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] base = str.toCharArray();
        int[] pi = prefixFunction(base);
        boolean flag = true;
        int tmpK = 0;
        for (int i = 0; i < pi.length - 1; i++) {
            if (!(pi[i] <= pi[i + 1])) {
                tmpK = i + 1;
            }
        }
        int tmpI = 0;
        for (int i = 0; i < pi.length; i++) {
            if (pi[i] == 0) {
                tmpI = i;
            }
        }
        if(tmpI + 1 > tmpK) {
            System.out.println(tmpI + 1);
        } else {
            System.out.println(tmpK);
        }
        System.out.println();
    }

    static int[] prefixFunction(char[] s) {
        int n = s.length;
        int[] pi = new int[n];

        for (int i = 1; i < n; ++i) {

            int j = pi[i - 1];

            while ((j > 0) && (s[i] != s[j])) {
                j = pi[j - 1];
            }

            if (s[i] == s[j]) {
                ++j;
            }

            pi[i] = j;
        }
        return pi;

    }
}