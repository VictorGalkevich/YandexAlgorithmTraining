package warmup.taskG;

import java.util.Scanner;

public class RabbitStudyingGeometry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len1 = scanner.nextInt();
        int len2 = scanner.nextInt();
        int[][] initialArray = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                initialArray[i][j] = scanner.nextInt();
            }
        }
        int[][] resArr = new int[len1][len2];
        fulfill(initialArray, resArr);
        printRes(resArr);
    }

    public static void fulfill(int[][] arr, int[][] res) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1) {
                    int v1 = (i - 1 >= 0) ? res[i - 1][j] : 0;
                    int v2 = (j - 1 >= 0) ? res[i][j - 1] : 0;
                    int v3 = (i - 1 >= 0 && j - 1 >= 0) ? res[i - 1][j - 1] : 0;
                    res[i][j] = Math.min(v1, Math.min(v2, v3)) + 1;
                }
            }
        }
    }

    public static void printRes(int[][] arr) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        System.out.println(max);
    }
}

