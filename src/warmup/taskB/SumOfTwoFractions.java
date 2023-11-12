package warmup.taskB;

import java.util.Scanner;

public class SumOfTwoFractions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a, b, c, d, m, n, i;
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        d = scanner.nextInt();
        m = a * d + b * c;
        n = b * d;
        i = 2;
        while (i <= n && i <= m) {
            if (n % i == 0 && m % i == 0)
            {
                n = n / i;
                m = m / i;
            }
            else {
                i++;
            }
        }

        System.out.println(m + " " + n);
    }
}
