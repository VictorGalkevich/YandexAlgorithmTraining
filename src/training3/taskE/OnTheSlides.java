package training3.taskE;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class OnTheSlides {
    static double[][] adjacencyMatrix;
    static boolean[] visited;
    static double[] dist;
    static int[] trace;
    static int numberOfNodes;
    static List<List<GraphNode>> adjacencyList = new ArrayList<>();
    static List<GraphNode> nodes = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        FastReader scanner = new FastReader();
        numberOfNodes = scanner.nextInt();
        for (int i = 0; i < numberOfNodes; i++) {
            List<GraphNode> list = new ArrayList<>();
            list.add(new GraphNode(i, scanner.nextInt(), scanner.nextInt()));
            adjacencyList.add(list);
        }
        for (int i = 0; i < numberOfNodes - 1; i++) {
            int firstNodeNumber = scanner.nextInt();
            int secondNodeNumber = scanner.nextInt();
            int distance = scanner.nextInt();
            adjacencyList.get(firstNodeNumber - 1).add(new GraphNode(secondNodeNumber - 1, distance));
            adjacencyList.get(secondNodeNumber - 1).add(new GraphNode(firstNodeNumber - 1, distance));
        }
        adjacencyMatrix = new double[numberOfNodes][numberOfNodes];
        visited = new boolean[numberOfNodes];
        dist = new double[numberOfNodes];
        trace = new int[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                adjacencyMatrix[i][j] = Double.MAX_VALUE;
            }
            adjacencyMatrix[i][i] = adjacencyList.get(i).get(0).slidesChangeTime;
        }
        for (int i = 0; i < numberOfNodes; i++) {
            dfs(adjacencyList.get(i).get(0));
        }
        for (int i = 0; i < numberOfNodes; i++) {
            dist[i] = Double.MAX_VALUE;
        }
        backwardsDijkstra();
        double max = 0;
        int ik = 1;
        for (int i = 0; i < numberOfNodes; i++) {
            if (dist[i] > max) {
                max = dist[i];
                ik = i + 1;
            }
        }
        System.out.println(max);
        System.out.print(ik + " ");
        while (ik != 1) {
            ik = trace[ik - 1];
            System.out.print(ik + " ");
        }
        System.out.println();
    }

    public static void backwardsDijkstra() {
        dist[0] = 0;

        for (int i = 0; i < numberOfNodes; i++) {
            int closestRoot = findMin();

            visited[closestRoot] = true;


            for (int j = 0; j < numberOfNodes; j++) {
                if (!visited[j] && dist[closestRoot] != Integer.MAX_VALUE) {
                    double newPathDist = adjacencyMatrix[j][closestRoot] + dist[closestRoot];
                    if (newPathDist < dist[j]) {
                        trace[j] = closestRoot + 1;
                        dist[j] = newPathDist;
                    }
                }
            }
        }

    }

    public static int findMin() {
        int minRoot = -1;

        for (int i = 0; i < numberOfNodes; i++) {
            if (!visited[i] && (minRoot == -1 || dist[i] < dist[minRoot])) {
                minRoot = i;
            }
        }

        return minRoot;
    }

    public static class GraphNode {
        public int numberOfNode;
        public int slidesChangeTime;
        public int speed;
        public int distance;
        public GraphNode(int numberOfNode, int slidesChangeTime, int speed) {
            this.numberOfNode = numberOfNode;
            this.slidesChangeTime = slidesChangeTime;
            this.speed = speed;
        }

        public GraphNode(int numberOfNode, int distance) {
            this.numberOfNode = numberOfNode;
            this.distance = distance;
        }
    }

    public static void dfs(GraphNode start) {
        Stack<GraphNode> stack = new Stack<>();
        boolean[] isVisited = new boolean[adjacencyList.size()];
        stack.push(start);
        while (!stack.isEmpty()) {
            GraphNode current = stack.pop();
            if (!isVisited[current.numberOfNode]) {
                isVisited[current.numberOfNode] = true;
                    for (int j = 1; j < adjacencyList.get(current.numberOfNode).size(); j++) {
                        if (!isVisited[adjacencyList.get(current.numberOfNode).get(j).numberOfNode]) {
                            stack.push(adjacencyList.get(current.numberOfNode).get(j));
                            if ((adjacencyMatrix[start.numberOfNode][current.numberOfNode] + ((double) adjacencyList.get(current.numberOfNode).get(j).distance / start.speed)) < adjacencyMatrix[start.numberOfNode][adjacencyList.get(current.numberOfNode).get(j).numberOfNode]) {
                                adjacencyMatrix[start.numberOfNode][adjacencyList.get(current.numberOfNode).get(j).numberOfNode] = (adjacencyMatrix[start.numberOfNode][current.numberOfNode] + ((double) adjacencyList.get(current.numberOfNode).get(j).distance / start.speed));
                            }
                        }
                }
            }
        }
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
                    System.out.println(e.getMessage());
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
    }
}
