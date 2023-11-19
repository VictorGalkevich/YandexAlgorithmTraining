package training4.taskE;

import java.util.Scanner;
import java.util.Stack;

public class PrintPBS {
    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        gen(length, "" ,0, 0);
        System.out.println(length % 2 == 0 ? builder : "");
    }

    public static boolean isValidPBS(String toParse) {
        Stack<Character> chars = new Stack<>();

        for (int i = 0; i < toParse.length(); i++) {
            if (toParse.charAt(i) == '(' || toParse.charAt(i) == '[') {
                chars.push(toParse.charAt(i));
            } else if (chars.isEmpty()) {
                return false;
            } else if (!((toParse.charAt(i) - chars.peek() == 1) || (toParse.charAt(i) - chars.peek() == 2))) {
                return false;
            } else {
                chars.pop();
            }
        }
        return chars.isEmpty();
    }

    public static void gen(int n, String ans, int opCo, int clCo) {
        if (clCo + opCo == n && isValidPBS(ans)) {
            builder.append(ans).append("\n");
            return;
        }
        if (opCo < n / 2) {
            gen(n, ans + '(',opCo + 1, clCo);
            gen(n, ans + '[',opCo + 1, clCo);
        }
        if (clCo < opCo) {
            if (ans.charAt(ans.length() - 1) != '[') {
                gen(n, ans + ')',opCo, clCo + 1);
            }
            if (ans.charAt(ans.length() - 1) != '(') {
                gen(n, ans + ']',opCo, clCo + 1);
            }
        }
    }
}
