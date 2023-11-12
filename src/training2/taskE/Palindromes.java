package training2.taskE;

import java.util.Scanner;

public class Palindromes {
    static long[] xPowers;
    static long[] xBackwardPowers;
    static long[] hashValues;
    static long[] hashBackwardValues;
    static String base;
    static long pValue = 1_000_000_000 + 7;
    static long res = 2;
    static int xValue = 307;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        base = scanner.next();
        hashValues = new long[base.length() + 1];
        hashBackwardValues = new long[base.length() + 1];
        xPowers = new long[base.length() + 1];
        xBackwardPowers = new long[base.length() + 1];
        xBackwardPowers[base.length()] = 1;
        xPowers[0] = 1;
        precalculateValues();
        countOddPalindromes(base);
        countEvenPalindromes(base);
        System.out.println(res);
    }

    public static void precalculateValues() {
        int len = base.length();
        for (int i = 1; i < base.length() + 1; i++) {
            hashValues[i] = (hashValues[i - 1] * xValue + (base.charAt(i - 1) - 'a' + 1)) % pValue;
            hashBackwardValues[len - i] = (hashBackwardValues[len - i  +1] * xValue + (base.charAt(len - i) - 'a' + 1)) % pValue;
            xPowers[i] = (xPowers[i - 1] * xValue) % pValue;
            xBackwardPowers[len - i] = (xBackwardPowers[len - i + 1] * xValue) % pValue;
        }
    }

    public static boolean areEqual(int f1, int f2, int length) {
        return (hashValues[f1 + length] + hashValues[f2] * xPowers[length]) % pValue == (hashValues[f2 + length] + hashValues[f1] * xPowers[length]) % pValue;
    }

    public static boolean isPalindrome(int f1, int f2, int length) {
        return (hashValues[f1 + length] + hashBackwardValues[f2 + 1] * xPowers[length]) % pValue == (hashBackwardValues[f2 - length + 1] + hashValues[f1] * xPowers[length]) % pValue;
    }

    public static void countEvenPalindromes(String base) {
        for (int i = 0 ; i < base.length(); i++) {
            binarySearchEven(i, base.length() - 1);
        }
    }
    public static void countOddPalindromes(String base) {
        for (int i = 1 ; i < base.length() - 1; i++) {
            binarySearchOdd(i, base.length() - 1);
        }
    }

    private static void binarySearchOdd(int f1, int high) {
        int counter = 0;
        int low = f1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid - f1 + 1 <= f1 + 1 && isPalindrome(f1 - (mid - f1), mid, mid - f1 + 1)) {
                counter = mid - f1 + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        res += counter;
    }

    private static void binarySearchEven(int f1, int high) {
        int counter = 0;
        int low = f1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid - f1 + 1 < f1 + 1 && isPalindrome(f1 - (mid - f1 + 1), mid, mid - f1 + 1)) {
                counter = mid - f1 + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        res += counter;
    }
}

