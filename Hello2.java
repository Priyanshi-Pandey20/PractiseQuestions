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

    public static void dfs(int i, int j, char grid[][], int n, int m) { // Count Islands
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

    public static boolean searchMatrix(int[][] matrix, int target) { // search the target in the matrix

        int rows = matrix.length;
        int cols = matrix[0].length;

        int i = 0, j = cols - 1;

        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }









    

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }























    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("first matrix : ");
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }

        int[][] mat2 = {
                {9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}
        };

        System.out.println("second matrix  :");
        for (int i = 0; i < mat2.length; i++) {
            System.out.println(Arrays.toString(mat2[i]));
        }
        int[][] result = multiplyMatrices(mat, mat2);
        System.out.println("Result matrix : ");
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }
}
