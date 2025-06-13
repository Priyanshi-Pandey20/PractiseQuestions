import java.util.Arrays;

public class Hello2 {

    public static int[][] transposeMatrix(int m, int n, int[][] matrix) { // find transpose of matrix
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;
    }







    public static void printDiagonalElements(int[][] matrix) { // print the diagonal elements
        System.out.print("primary diagonal elements : ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");

        }

        System.out.println();
        System.out.print("secondary diagonal elements : ");
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][matrix.length - 1 - i] + " ");

        }

    }

   public  static void dfs(int i, int j, char grid[][], int n, int m) {  // Count Islands
        if (i < 0 || j < 0 || i == n || j == m || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(i + 1, j, grid, n, m);
        dfs(i - 1, j, grid, n, m);
        dfs(i, j + 1, grid, n, m);
        dfs(i, j - 1, grid, n, m);
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, n, m);
                }
            }
        }
        return count;

    }



    public static void main(String[] args) {
               char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

       Hello2 sol = new Hello2();
        int islands = sol.numIslands(grid);
        System.out.println("Number of islands: " + islands);
       
    }
}
