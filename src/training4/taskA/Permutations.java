package training4.taskA;
import java.util.Scanner;

public class Permutations {
    static StringBuilder builder = new StringBuilder();
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < length; i++) {
            s.append(i + 1);
        }
        printPermutations(s.toString(), "");
        System.out.println(builder);
    }

    static void printPermutations(String str,
                                  String ans)
    {
        if (str.isEmpty()) {
            builder.append(ans).append("\n");
            return;
        }
        boolean[] alpha = new boolean[9];

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            if (!alpha[ch - '1'])
                printPermutations(ros, ans + ch);
            alpha[ch - '1'] = true;
        }
    }
}