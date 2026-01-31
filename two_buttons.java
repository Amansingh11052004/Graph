import java.util.*;
public class two_buttons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] visited = new boolean[20005];
        int[] distance = new int[20005];

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        distance[n] = 0;
        visited[n] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == m){
                System.out.println(distance[curr]);
                return;
            }

            int u = curr-1;
            int v = curr*2;

            if(u>=1 && !visited[u]){
                visited[u] = true;
                distance[u] = 1 + distance[curr];
                q.add(u);
            }
            if(v<=20000 && !visited[v]){
                visited[v] = true;
                distance[v] = 1 + distance[curr];
                q.add(v);
            }
        }
    }
}
