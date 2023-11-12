package training1.taskE;

import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String delimiter = "**********";
        String initArray = "Initial array:";
        String sortedArray = "Sorted array:";
        int numberOfStrokes = scanner.nextInt();
        String[] numbers = new String[numberOfStrokes];
        for (int i = 0; i < numberOfStrokes; i++) {
            numbers[i] = scanner.next();
        }
        System.out.println(initArray);
        System.out.print(numbers[0]);
        for (int i = 1; i < numberOfStrokes; i++) {
            System.out.printf(", %s", numbers[i]);
        }
        System.out.println();
        System.out.println(delimiter);
        int phase = 1;
        for (int i = numbers[0].length() - 1; i > -1; i--) {
            numbers = sortCounting(numbers, i);
            output(numbers, phase, i);
            System.out.println(delimiter);
            phase++;
        }


        System.out.println(sortedArray);
        System.out.print(numbers[0]);
        for (int i = 1; i < numberOfStrokes; i++) {
            System.out.printf(", %s", numbers[i]);
        }
    }

    public static String[] sortCounting(String[] arr, int digitNo) {
        String[] result = new String[arr.length];
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i].charAt(digitNo) - '0']++;
        }
        int[] pos = new int[10];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            int val = count[i];
            if (val != 0) {
                pos[i] = index;
                index += val;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            result[pos[arr[i].charAt(digitNo) - '0']++] = arr[i];
        }
        return result;
    }

    public static void output(String[] arr, int phase, int digitNo) {
        System.out.println("Phase " + phase);
        int start = 0;
        int end = 0;
        for (int i = 0; i < 10; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j].charAt(digitNo) - '0' == i) {
                    end++;
                    flag = true;
                }
            }
            if(flag){
                System.out.printf("Bucket %s: %s", i, arr[start++]);
                for (int j = start; j < end; j++) {
                    System.out.printf(", %s", arr[j]);
                }
                System.out.println();
            } else{
                System.out.printf("Bucket %s: empty", i);
                System.out.println();
            }
            start = end;
        }
    }
}