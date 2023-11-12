package training2.taskA;

import java.util.Scanner;

public class SubstringEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String base = scanner.next();
        int numberOfCalls = scanner.nextInt();
        long[] hashValues = new long[base.length() + 1];
        long[] xPowers = new long[base.length() + 1];
        xPowers[0] = 1;
        long pValue = 1_000_000_000 + 7;
        int xValue = 307;
        int[][] tests = new int[numberOfCalls][3];
        for (int i = 0; i < numberOfCalls; i++) {
            tests[i][0] = scanner.nextInt();
            tests[i][1] = scanner.nextInt();
            tests[i][2] = scanner.nextInt();
        }
        precalculateValues(xPowers, hashValues, xValue, pValue, base);
        for (int i = 0; i < numberOfCalls; i++) {
            System.out.println(areEqual(tests[i][1], tests[i][2], tests[i][0], xPowers, hashValues, pValue) ? "yes" : "no");
        }
    }

    public static void precalculateValues(long[] xPowers, long[] hashValues, int xValue, long pValue, String base) {
        for (int i = 1; i < base.length() + 1; i++) {
            hashValues[i] = (hashValues[i - 1] * xValue + (base.charAt(i - 1) - 'a' + 1)) % pValue;
            xPowers[i] = (xPowers[i - 1] * xValue) % pValue;
        }
    }

    public static boolean areEqual(int f1, int f2, int length, long[] xPowers, long[] hashValues, long pValue) {
        return (hashValues[f1 + length] + hashValues[f2] * xPowers[length]) % pValue == (hashValues[f2 + length] + hashValues[f1] * xPowers[length]) % pValue;
    }
}
