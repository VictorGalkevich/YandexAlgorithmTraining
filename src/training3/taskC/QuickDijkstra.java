package training3.taskC;

import java.io.*;
import java.util.*;

public class QuickDijkstra {
    static long[] dist;
    static List<List<Pair>> adjacencyList = new ArrayList<>();
    static PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingDouble(Pair::getRootLength));
    static int numberOfRoots;
    static int numberOfEdges;
    static int startRootNumber;
    static int endRootNumber;
    public static void main(String[] args) throws FileNotFoundException {
        FastReader scanner = new FastReader();
        numberOfRoots = scanner.nextInt();
        numberOfEdges = scanner.nextInt();
        for (int i = 0; i < numberOfRoots; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < numberOfEdges; i++) {
            int ik = scanner.nextInt() - 1;
            int jk = scanner.nextInt() - 1;
            int lk = scanner.nextInt();
            adjacencyList.get(ik).add(new Pair(jk, lk));
            adjacencyList.get(jk).add(new Pair(ik, lk));
        }
        startRootNumber = scanner.nextInt();
        endRootNumber = scanner.nextInt();
        dist = new long[numberOfRoots];
        queue.add(new Pair(startRootNumber - 1, 0));
        for (int i = 0; i < numberOfRoots; i++) {
            dist[i] = Long.MAX_VALUE;
        }
        dijkstra();
        System.out.println(dist[endRootNumber - 1] == Long.MAX_VALUE ? -1 : dist[endRootNumber - 1]);
    }

    public static void dijkstra() {
        dist[startRootNumber - 1] = 0;

        for (int i = 0; i < numberOfRoots; i++) {
            while (queue.size() > 0) {
                int current = findMin();

                for (Pair pair : adjacencyList.get(current)) {
                    if (dist[current] + pair.getRootLength() < dist[pair.getRootNumber()] ) {
                        dist[pair.getRootNumber()] = dist[current] + pair.getRootLength();
                        queue.add(new Pair(pair.getRootNumber(), dist[pair.getRootNumber()]));
                    }
                }

            }
        }

    }

    public static int findMin() {
        return queue.poll().getRootNumber();
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() throws FileNotFoundException {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
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

    static class Pair {
        int rootNumber;
        long rootLength;

        Pair (int rootNumber, long rootLength) {
            this.rootLength = rootLength;
            this.rootNumber = rootNumber;
        }

        public int getRootNumber() {
            return rootNumber;
        }

        public long getRootLength() {
            return rootLength;
        }
    }
}
