package warmup.taskH;

import java.util.Scanner;

public class ContestResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int xa = scanner.nextInt();
        int xb = scanner.nextInt();
        int ya = scanner.nextInt();
        boolean value;
        if (xb % ya == 0) {
            value = xa > (xb / ya);
        } else {
            value = xa > ((xb / ya) + 1);
        }
        System.out.println(value ? "Yes" : "No");
    }
}
