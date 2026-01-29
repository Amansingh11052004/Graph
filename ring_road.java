import java.util.*;

public class ring_road {

    static class Pair {
        int node, cost;
        Pair(int n, int c) {
            node = n;
            cost = c;
        }
    }

    static long bfs(int start, ArrayList<ArrayList<Pair>> graph, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        long totalCost = 0;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (Pair p : graph.get(u)) {
                if (!visited[p.node]) {
                    visited[p.node] = true;
                    totalCost += p.cost; 
                    q.add(p.node);
                }
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        int[] u = new int[n];
        int[] v = new int[n];
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            u[i] = sc.nextInt();
            v[i] = sc.nextInt();
            w[i] = sc.nextInt();

            graph.get(u[i]).add(new Pair(v[i], 0));

            graph.get(v[i]).add(new Pair(u[i], w[i]));
        }

        long clockwise = bfs(u[0], graph, n);

        long anticlockwise = bfs(v[0], graph, n);

        System.out.println(Math.min(clockwise, anticlockwise));
    }
}
