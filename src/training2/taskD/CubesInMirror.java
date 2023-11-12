package training2.taskD;

import java.util.Scanner;

public class CubesInMirror {
    static long[] xPowers;
    static long[] hashValues;
    static long[] xBackwardPowers;
    static long[] hashBackwardValues;
    static long pValue = 1_000_000_000 + 7;
    static int numberOfCubes;
    static int numberOfColors;
    static int[] res;
    static int[] cubes;
    static int xValue;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numberOfCubes = scanner.nextInt();
        numberOfColors = scanner.nextInt();
        res = new int[(numberOfCubes /  2) + 1];
        cubes = new int[numberOfCubes];
        xValue = numberOfColors + 1;
        for (int i = 0; i < numberOfCubes; i++) {
            cubes[i] = scanner.nextInt();
        }
        hashValues = new long[numberOfCubes + 1];
        hashBackwardValues = new long[numberOfCubes + 1];
        xBackwardPowers = new long[numberOfCubes + 1];
        xPowers = new long[numberOfCubes + 1];
        xPowers[0] = 1;
        precalculateValues();
        res[res.length - 1] = numberOfCubes;
        findPlaces();
        for (int i = 0; i < res.length - 1; i++) {
            if (res[i] != 0) {
                System.out.print(res[i] + " ");
            }
        }
        System.out.print(res[res.length - 1]);
    }

    public static void precalculateValues() {
        for (int i = 1; i < numberOfCubes + 1; i++) {
            hashValues[i] = (hashValues[i - 1] * xValue + cubes[i - 1]) % pValue;
            hashBackwardValues[numberOfCubes - i] = (hashBackwardValues[numberOfCubes - i  +1] * xValue + cubes[numberOfCubes - i]) % pValue;
            xPowers[i] = (xPowers[i - 1] * xValue) % pValue;
            xBackwardPowers[numberOfCubes - i] = (xBackwardPowers[numberOfCubes - i + 1] * xValue) % pValue;
        }
    }
    public static boolean isPalindrome(int f1, int f2, int length) {
        return (hashValues[f1 + length] + hashBackwardValues[f2 + 1] * xPowers[length]) % pValue == (hashBackwardValues[f2 - length + 1] + hashValues[f1] * xPowers[length]) % pValue;
    }

    public static void findPlaces() {
        int len = 1;
        for (int i = 0; i <= (numberOfCubes / 2) - 1 ; i++) {
            if (isPalindrome(0, 2 * len - 1, len)) {
                res[res.length - 2 - i] = numberOfCubes - len;
            }
            len++;
        }
    }
}
