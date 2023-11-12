package warmup.taskI;

import java.util.Scanner;
import java.util.Stack;


public class ProperBracketSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String toParse = scanner.next();
        Stack<Character> chars = new Stack<>();

        for (int i = 0; i < toParse.length(); i++) {
            if (toParse.charAt(i) == '(' || toParse.charAt(i) == '[' || toParse.charAt(i) == '{') {
                chars.push(toParse.charAt(i));
            } else if (chars.isEmpty()) {
                System.out.println("no");
                System.exit(0);
            } else if (!((toParse.charAt(i) - chars.peek() == 1) || (toParse.charAt(i) - chars.peek() == 2))) {
                System.out.println("no");
                System.exit(0);
            } else {
                chars.pop();
            }
        }
        System.out.println(chars.isEmpty() ? "yes" : "no");
    }
}
