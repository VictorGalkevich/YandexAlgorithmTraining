package training3.taskD;

import java.io.*;
import java.util.*;

public class BusesInVasyuki {
    static int[] dist;
    static List<List<Pair>> adjacencyList = new ArrayList<>();
    static PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getArrivalTime));
    static int numberOfRoots;
    static int numberOfRides;
    static int startRootNumber;
    static int endRootNumber;
    public static void main(String[] args) throws FileNotFoundException {
        FastReader scanner = new FastReader();
        numberOfRoots = scanner.nextInt();
        for (int i = 0; i < numberOfRoots; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        startRootNumber = scanner.nextInt();
        endRootNumber = scanner.nextInt();
        numberOfRides = scanner.nextInt();
        for (int i = 0; i < numberOfRides; i++) {
            int ik = scanner.nextInt() - 1;
            int tD = scanner.nextInt();
            int jk = scanner.nextInt() - 1;
            int tA = scanner.nextInt();
            adjacencyList.get(ik).add(new Pair(jk, tD, tA));
        }
        dist = new int[numberOfRoots];
        queue.add(new Pair(startRootNumber - 1, 0, 0));
        for (int i = 0; i < numberOfRoots; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dijkstra();
        System.out.println(dist[endRootNumber - 1] == Integer.MAX_VALUE ? -1 : dist[endRootNumber - 1]);
    }

    public static void dijkstra() {
        dist[startRootNumber - 1] = 0;

        for (int i = 0; i < numberOfRoots; i++) {
            while (!queue.isEmpty()) {
                int current = findMin();

                for (Pair pair : adjacencyList.get(current)) {
                    if (pair.getArrivalTime() < dist[pair.getRootNumber()] && dist[current] <= pair.getDepartureTime()) {
                        dist[pair.getRootNumber()] = pair.getArrivalTime();
                        queue.add(new Pair(pair.getRootNumber(), dist[pair.getRootNumber()], pair.getDepartureTime()));
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

        int departureTime;
        int arrivalTime;

        Pair (int rootNumber, int departureTime, int arrivalTime) {
            this.arrivalTime = arrivalTime;
            this.rootNumber = rootNumber;
            this.departureTime = departureTime;
        }

        public int getRootNumber() {
            return rootNumber;
        }

        public int getArrivalTime() {
            return arrivalTime;
        }

        public int getDepartureTime() {
            return departureTime;
        }
    }
}
