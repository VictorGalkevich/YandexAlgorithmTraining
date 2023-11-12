package training2.taskC;

import java.io.BufferedReader;
import java.io.FileReader;

public class ZetFunction {
    static long[] hash;
    static long[] xpows;
    static int[] zfunc;
    static int p = (int) Math.pow(10, 9) + 7;
    static int x = 257;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String S = br.readLine();
        int n = S.length();
        hash = new long[n + 1];
        xpows = new long[n + 1];
        xpows[0] = 1;
        zfunc = new int[n];
        StringBuilder result = new StringBuilder();
        result.append("0 ");


        for (int i = 1; i < n + 1; i++) {
            hash[i] = (hash[i - 1] * x + (int) S.charAt(i - 1)) % p;
            xpows[i] = (xpows[i - 1] * x) % p;
        }

        for (int i = 1; i < n; i++){
            zfunc[i] = binarySearch(i, n-1);
            result.append(zfunc[i] + " ");
        }

        System.out.println(result.toString().trim());

    }

    static boolean equalSubStringDefiner(int A, int B, int L) {
        return ((hash[A + L] + hash[B] * xpows[L]) % p) == ((hash[B + L] + hash[A] * xpows[L]) % p);
    }

    static int binarySearch(int left, int right) {
        int minLen = 1, maxLen = right-left+1;
        int z = 0;
        while (maxLen>=minLen){
            int length = (maxLen+minLen)/2;
            if (equalSubStringDefiner(0, left, length)) {
                z=length;
                minLen = length+1;
            }
            else maxLen = length-1;
        }
        return z;
    }
}