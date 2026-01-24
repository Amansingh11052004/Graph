
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    static class edge{
    int src;
    int dest;

    public edge(int s, int d){
        this.src = s;
        this.dest = d;
    }
}

  public static void createGraph(ArrayList<edge> graph[]){
      for(int i=0; i<graph.length; i++){
        graph[i] = new ArrayList<edge>();
      }
      graph[0].add(new edge(0,1));
      graph[0].add(new edge(0,2));
      graph[1].add(new edge(1,0));
      graph[1].add(new edge(1,3));
      graph[2].add(new edge(2,0));
      graph[2].add(new edge(2,4));
      graph[3].add(new edge(3,1));
      graph[3].add(new edge(3,4));
      graph[3].add(new edge(3,5));
      graph[4].add(new edge(4,2));
      graph[4].add(new edge(4,3));
      graph[4].add(new edge(4,5));
      graph[5].add(new edge(5,3));
      graph[5].add(new edge(5,4));
      graph[5].add(new edge(5,6));
      graph[6].add(new edge(6,5));
      
  }

  //BFS

  public static void bfs(ArrayList<edge> graph[], int v){
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[v];
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == false){
                System.out.print(curr+" ");
                vis[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                    edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }

  }

  // DFS

  public static void dfs(ArrayList<edge> graph[], int curr, boolean[] vis){
    System.out.print(curr+" ");
    vis[curr] = true;
    for(int i=0; i<graph[curr].size(); i++){
        edge e = graph[curr].get(i);
        if(vis[e.dest] == false){
          dfs(graph, e.dest, vis);
        }
    }
  }

  public static void allpath(ArrayList<edge> graph[], boolean[] vis, int curr, String path, int target){
    if(curr == target){
        System.out.print(path+"  ");
        return;
    }

    for(int i=0; i<graph[curr].size(); i++){
        edge e = graph[curr].get(i);
        if(vis[e.dest] == false){
            vis[curr] = true;
            allpath(graph, vis, e.dest, path+e.dest, target);
            vis[curr] = false;
        }
    }
  }

  public static void main(String[] args) {
      int v = 7;
      ArrayList<edge> graph[] = new ArrayList[v];
      createGraph(graph);
    //   bfs(graph, v);
    // dfs(graph, 0, vis);
    int src = 0;
    int target = 5;
    allpath(graph, new boolean[v], src, "0", 5);
      System.out.println();
  }
}