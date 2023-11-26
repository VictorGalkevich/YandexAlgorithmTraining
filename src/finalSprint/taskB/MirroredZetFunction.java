package finalSprint.taskB;

import java.util.Scanner;

public class MirroredZetFunction {

    static long[] xPowers;
    static long[] hashValues;
    static long[] xBackwardPowers;
    static long[] hashBackwardValues;
    static long pValue = 1_000_000_000 + 7;
    static int stringLength;
    static int xValue = 307;
    static String str;
    static int[] result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        stringLength = scanner.nextInt();
        str = scanner.next();
        xPowers = new long[stringLength + 1];
        hashValues = new long[stringLength + 1];
        hashBackwardValues = new long[stringLength + 1];
        xBackwardPowers = new long[stringLength + 1];
        xPowers[0] = 1;
        result = new int[stringLength];
        precalculateValues();
        buildResult();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            builder.append(result[i]).append(" ");
        }
        System.out.println(builder);
    }

    public static void precalculateValues() {
        for (int i = 1; i < stringLength + 1; i++) {
            hashValues[i] = (hashValues[i - 1] * xValue + str.charAt(i - 1)) % pValue;
            hashBackwardValues[stringLength - i] = (hashBackwardValues[stringLength - i  +1] * xValue + str.charAt(stringLength - i)) % pValue;
            xPowers[i] = (xPowers[i - 1] * xValue) % pValue;
            xBackwardPowers[stringLength - i] = (xBackwardPowers[stringLength - i + 1] * xValue) % pValue;
        }
    }

    public static boolean areEqual(int f1, int f2, int length) {
        return (hashValues[f1 + length] + hashBackwardValues[f2 + 1] * xPowers[length]) % pValue == (hashBackwardValues[f2 - length + 1] + hashValues[f1] * xPowers[length]) % pValue;
    }

    public static void buildResult() {
        for (int i = 0; i < stringLength; i++) {
            int tmpRes = findMaxMirroredPart(i);
            result[i] = tmpRes;
        }
    }

    public static int findMaxMirroredPart(int high){
        int res = 0;
        int low = 0;
        int f2 = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (areEqual(0, f2, f2 - mid + 1)) {
                res = f2 - mid + 1;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
