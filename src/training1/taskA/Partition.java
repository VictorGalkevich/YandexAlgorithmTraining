package training1.taskA;

import java.io.*;
import java.util.StringTokenizer;

public class Partition {

    public static void main(String[] args) throws IOException {
        FastReader scanner = new FastReader();
        int capacity = scanner.nextInt();
        int[] numbers = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            numbers[i] = scanner.nextInt();
        }
        int x = scanner.nextInt();

        if (capacity > 0) {
            partition(numbers, 0, capacity - 1, x);
        }
        int counter = 0;
        for (int i = 0; i < capacity; i++) {
            if (numbers[i] >= x) {
                break;
            }
            counter++;
        }
        System.out.println(counter);
        System.out.println(capacity - counter);
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static int partition(int[] arr, int low, int high, int x)
    {
        int pivot = x;
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}