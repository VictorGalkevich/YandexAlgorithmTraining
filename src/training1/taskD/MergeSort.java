package training1.taskD;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len1 = scanner.nextInt();
        int[] mainArray = new int[len1];
        for (int i = 0; i < len1; i++) {
            mainArray[i] = scanner.nextInt();
        }
        int[] newArr = mergeSort(mainArray);
        for (int i : newArr) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return arr;
        }

        int pivot = arr.length / 2;
        int[] arr1 = new int[pivot];
        int[] arr2 = new int[arr.length - pivot];
        for (int i = 0; i < pivot; i++) {
            arr1[i] = arr[i];
        }
        for (int i = pivot; i < arr.length; i++) {
            arr2[i - pivot] = arr[i];
        }
        int[] farr1 = mergeSort(arr1);
        int[] farr2 = mergeSort(arr2);
        return merge(farr1, farr2);
    }

    public static int[] merge(int pToAs, int pToAe, int pToBs, int pToBe, int[] arr) {
        int[] res = new int[pToBe - pToAs + 1];
        int pa = pToAs;
        int pb = pToBs;
        int i = 0;
        while (pa <= pToAe && pb <= pToBe) {
            if (arr[pa] <= arr[pb]) {
                res[i++] = arr[pa++];
            } else {
                res[i++] = arr[pb++];
            }
        }
        while (pa <= pToAe) {
            res[i++] = arr[pa++];
        }
        while (pb <= pToBe) {
            res[i++] = arr[pb++];
        }
        return res;
    }

    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int pa = 0;
        int pb = 0;
        int i = 0;
        while (pa < a.length && pb < b.length) {
            if (a[pa] <= b[pb]) {
                res[i++] = a[pa++];
            } else {
                res[i++] = b[pb++];
            }
        }
        while (pa < a.length) {
            res[i++] = a[pa++];
        }
        while (pb < b.length) {
            res[i++] = b[pb++];
        }
        return res;
    }
}

