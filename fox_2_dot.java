import java.util.*;

public class fox_2_dot {
    static int n, m;
    static char[][] grid;
    static boolean[][] visited;
    static int[][] depth;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = sc.nextLine().toCharArray();
        }

        visited = new boolean[n][m];
        depth = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, grid[i][j], 1)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }
        System.out.println("No");
    }

    static boolean dfs(int x, int y, char color, int d) {
        visited[x][y] = true;
        depth[x][y] = d;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (grid[nx][ny] != color) continue;

            if (!visited[nx][ny]) {
                if (dfs(nx, ny, color, d + 1)) return true;
            } else {
                if (d - depth[nx][ny] + 1 >= 4) return true;
            }
        }
        return false;
    }
}
