package warmup.taskC;

import java.util.Scanner;

public class TravellingInMoscow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int xa = scanner.nextInt();
        int ya = scanner.nextInt();
        int xb = scanner.nextInt();
        int yb = scanner.nextInt();

        double rad1 = getLength(xa, 0, ya, 0);
        double rad2 = getLength(xb, 0, yb, 0);
        double angleTmp = Math.atan2(yb, xb) - Math.atan2(ya, xa);
        double angle = Math.abs(angleTmp);

        if (xa == xb && ya == yb) {
            System.out.println(0);
        } else if (rad1 == rad2 && angle != 0 && angle != Math.PI) {
            double v = angle * rad1;
            if (2 * rad2 > v) {
                System.out.println(v);
            } else {
                System.out.println(2 * rad2);
            }
        } else {
            if (angle == 0 || angle == Math.PI) {
                System.out.println(getLength(xa, xb, ya, yb));
            } else{
                double tmp = Math.abs(rad1 - rad2);
                double len = angle * Math.min(rad1, rad2);
                double val = tmp + len;
                double val2 = rad1 + rad2;
                System.out.println(Math.min(val, val2));
            }
        }
    }

    public static double getLength(int a, int b, int c, int z) {
        return Math.sqrt(Math.pow(a - b, 2) + Math.pow(c - z, 2));
    }
}
