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

    public static void boundaryTraversal(int[][] matrix) { // Boundary traversal of the matrix
        int n = matrix.length;
        int m = matrix[0].length;
        for (int j = 0; j < m; j++) {
            System.out.print(matrix[0][j] + " ");
        }
        for (int i = 1; i < n - 1; i++) {
            System.out.print(matrix[i][m - 1] + " ");
        }
        if (n > 1) {
            for (int j = m - 1; j >= 0; j--) {
                System.out.print(matrix[n - 1][j] + " ");
            }
        }
        if (m > 1) {
            for (int i = n - 2; i > 0; i--) {
                System.out.print(matrix[i][0] + " ");
            }
        }
        System.out.println();
    }




    public static void printPascalTriangle(int n) { // Pascal's Traingle
        for (int line = 0; line < n; line++) {
            int val = 1;

            for (int space = 0; space < n - line - 1; space++) {
                System.out.print(" ");
            }

            for (int i = 0; i <= line; i++) {
                System.out.print(val + " ");
                val = val * (line - i) / (i + 1);
            }
            System.out.println();
        }
    }

     public static int findMedian(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < r; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][c - 1]);
        }
        int desired = (r * c + 1) / 2;
        while(min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for(int i = 0; i < r; i++) {
                count += countSmallerOrEqual(matrix[i], mid);
            }
            if(count < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public static int countSmallerOrEqual(int[] row, int target) {
        int l = 0, h = row.length;
        while(l < h) {
            int mid = l + (h - l) / 2;
            if(row[mid] <= target)
                l = mid + 1;
            else
                h = mid;
        }
        return l;
    }






    public static void printSnakePattern(int[][] matrix) { // print snake pattern
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++) {
            if(i % 2 == 0) {
                // left to right
                for(int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else {
                // right to left
                for(int j = cols - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }




      public  static void setZeroesInMatrix(int[][] matrix) {
        int rows = matrix.length; int cols = matrix[0].length;
        boolean firstRowZero = false; boolean firstColZero = false;   
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            } }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            } }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }} }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }}}
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            } }
         if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
       
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }




     public static void booleanMatrix(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;

        boolean[] row = new boolean[R];
        boolean[] col = new boolean[C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == 1) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

      
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (row[i] || col[j]) {
                    mat[i][j] = 1;
                }
            }
        }
    }


    


    public static void main(String[] args) {
       int[][] matrix = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

       booleanMatrix(matrix);

        System.out.println("Modified Matrix:");
        printMatrix(matrix);

       

        // int[][] mat2 = {
        // {9, 8, 7},
        // {6, 5, 4},
        // {3, 2, 1}
        // };

        // System.out.println("second matrix :");
        // for (int i = 0; i < mat2.length; i++) {
        // System.out.println(Arrays.toString(mat2[i]));
        // }
        // int[][] result = multiplyMatrices(mat, mat2);

        
        
        

    }
}
