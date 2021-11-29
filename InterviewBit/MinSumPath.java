import java.util.ArrayList;

public class MinSumPath {
    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int visited[][] = new int[n][m];
        return dfs(0, 0, A, n, m, visited);
    }

    public int dfs(int i, int j, ArrayList<ArrayList<Integer>> A, int n, int m, int visited[][]) {
        if (i == n - 1 && j == m - 1)
            return A.get(i).get(j);

        if (i >= n || j >= m)
            return Integer.MAX_VALUE;

        if (visited[i][j] != 0)
            return visited[i][j];

        int down = dfs(i + 1, j, A, n, m, visited);
        int right = dfs(i, j + 1, A, n, m, visited);
        return visited[i][j] = A.get(i).get(j) + Math.min(down, right);
    }
}
