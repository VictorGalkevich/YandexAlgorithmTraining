package warmup.taskF;

import java.math.BigInteger;
import java.util.Scanner;

public class Elevator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        long k = scanner.nextLong();
        int n = scanner.nextInt();
        long[] floors = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            floors[i] = scanner.nextLong();
        }
        BigInteger result = BigInteger.ZERO;
        for (int i = n; i > 0; i--) {
            long capacity = k;
            result = result.add(BigInteger.valueOf((floors[i] / k) * i * 2L));
            capacity -= floors[i] % k;
            if (capacity != k) { // else i'th floor is empty
                result = result.add(BigInteger.valueOf(i * 2L));
                while (capacity > 0 && i > 0) {
                    i--;
                    if (floors[i] <= capacity) {
                        capacity -= floors[i];
                    } else {
                        floors[i] -= capacity;
                        i++;
                        break;
                    }
                }


            }
        }
        System.out.println(result);
    }
}