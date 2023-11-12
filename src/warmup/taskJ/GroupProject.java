package warmup.taskJ;

import java.util.Scanner;


public class GroupProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        int[][] tests = new int[numberOfTests][3];
        for (int i = 0; i < numberOfTests; i++) {
            tests[i][0] = scanner.nextInt();
            tests[i][1] = scanner.nextInt();
            tests[i][2] = scanner.nextInt();
        }
        for (int i = 0; i < numberOfTests; i++) {
            int v1 =  tests[i][0] / tests[i][2];
            int v2 =  tests[i][0] / tests[i][1];
            boolean value = (v2 - v1 >= 1 || tests[i][0] % tests[i][2] == 0 || tests[i][0] % tests[i][1] == 0);
            System.out.println(value ? "YES" : "NO");
        }
    }
}
