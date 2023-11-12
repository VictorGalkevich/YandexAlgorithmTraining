package warmup.taskA;

import java.util.Scanner;

public class NotAMinimum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElements = scanner.nextInt();
        int numberOfTests = scanner.nextInt();

        int[] seq = new int[numberOfElements];

        for (int i = 0; i < numberOfElements; i++) {
            seq[i] = scanner.nextInt();
        }

        int[][] tests = new int[numberOfTests][2];

        for (int i = 0; i < numberOfTests; i++) {
            tests[i][0] = scanner.nextInt();
            tests[i][1] = scanner.nextInt();
        }

        for (int i = 0; i < numberOfTests; i++) {
            int tmp = isOneElemented(tests[i][0], tests[i][1], seq);
            if (tmp != -1) {
                System.out.println(tmp);
            } else {
                System.out.println("NOT FOUND");
            }
        }
    }

    public static int isOneElemented(int start, int end, int[] arr) {
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] != arr[i - 1]) {
                return Math.max(arr[i], arr[i - 1]);
            }
        }
        return -1;
    }
}
