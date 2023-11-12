package warmup.taskD;

import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.next();
        String s2 = scanner.next();

        int[] chars = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            chars['z' - s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            chars['z' - s2.charAt(i)]--;
        }
        if(arrIsZeroed(chars)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }

    public static boolean arrIsZeroed(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
