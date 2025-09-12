import java.util.Arrays;

public class Hello2 {

    public static int[][] transposeMatrix(int m, int n, int[][] matrix) { // find transpose of matrix pblm 
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;
    }

    public static void printDiagonalElements(int[][] matrix) { // print the diagonal elements pblm
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

    public static void dfs(int i, int j, char grid[][], int n, int m) { // Count Islands pblm
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

    public static boolean searchMatrix(int[][] matrix, int target) { // search the target in the matrix pblm 

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

    public static int[][] multiplyMatrices(int[][] A, int[][] B) { // multiply matrices pblm
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

    public static void boundaryTraversal(int[][] matrix) { // Boundary traversal of the matrix pblm 
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

    public static void printPascalTriangle(int n) { // Pascal's Traingle pblm 
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

    public static int findMedian(int[][] matrix) {   // find median in the matrix pblm 
        int r = matrix.length;
        int c = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            min = Math.min(min, matrix[i][0]);
            max = Math.max(max, matrix[i][c - 1]);
        }
        int desired = (r * c + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for (int i = 0; i < r; i++) {
                count += countSmallerOrEqual(matrix[i], mid);
            }
            if (count < desired) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    public static int countSmallerOrEqual(int[] row, int target) { // count Small or equal pblm 
        int l = 0, h = row.length;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (row[mid] <= target)
                l = mid + 1;
            else
                h = mid;
        }
        return l;
    }

    public static void printSnakePattern(int[][] matrix) { // print snake pattern
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                // left to right
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else {
                // right to left
                for (int j = cols - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    public static void setZeroesInMatrix(int[][] matrix) { // set the zero at row and col
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
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

    public static void booleanMatrix(int[][] mat) { // set 1 in entire row and col where it is given 1
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

    public static boolean searchMatrix2(int[][] matrix, int target) {// Search a 2D matrix
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midElement = matrix[mid / n][mid % n];

            if (midElement == target)
                return true;
            else if (midElement < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return false;
    }

    public static int Occurrence(int[][] matrix) { // find the occurancee of element
        int maxElement = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                maxElement = Math.max(maxElement, matrix[i][j]);
            }
        }

        int[] freq = new int[maxElement + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                freq[matrix[i][j]]++;
            }
        }

        int maxFreq = 0;
        System.out.println("Element : Frequency");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println(i + " : " + freq[i]);
                maxFreq = Math.max(maxFreq, freq[i]);
            }
        }

        return maxFreq;
    }

    public static void reverseWholeString(String str) { // reverse the whole string
        str = str.trim();
        int end = str.length();
        String newStr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ' || i == 0) {
                int start = (i == 0) ? i : i + 1;
                for (int j = start; j < end; j++) {
                    newStr += str.charAt(j);
                }
                if (i != 0) {
                    newStr += ' ';
                }
                end = i;

                while (i > 0 && str.charAt(i - 1) == ' ') {
                    i--;
                }
            }
        }
        System.out.println(newStr);
    }

    public static String toUpperCase(String str) { // capitalize first word
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for (int i = 1; i < str.length(); i++)
            if (str.charAt(i) == ' ' && i < str.length() - 1) {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }

        return sb.toString();
    }

    public static boolean staircaseSearch(int matrix[][], int key) { // to find the element
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                System.out.println("found at index (" + row + "," + col + ")");
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        System.out.println("key not found");
        return false;
    }

    public static void printMatrix1(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) { // Rotate matrix by 90 degrees clockwise
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            reverseRow(matrix[i]);
        }
    }

    private static void reverseRow(int[] row) {
        int left = 0, right = row.length - 1;
        while (left < right) {
            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;
            left++;
            right--;
        }
    }

    public static void spiralPrint(int[][] matrix) { // spiral traversal of matrix
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;
        int left = 0;
        int right = cols - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    System.out.print(matrix[bottom][i] + " ");
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }

    public static int maximalRectangle(int[][] matrix) { //maximize rectangle 
        if (matrix.length == 0)
            return 0;

        int maxArea = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] height = new int[cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0)
                    height[j] = 0;
                else
                    height[j] += 1;
            }

            for (int j = 0; j < cols; j++) {
                int minHeight = height[j];
                for (int k = j; k < cols; k++) {
                    if (height[k] == 0)
                        break;
                    minHeight = Math.min(minHeight, height[k]);
                    int width = k - j + 1;
                    maxArea = Math.max(maxArea, width * minHeight);
                }
            }
        }

        return maxArea;
    }







    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 0, 1, 0, 0 },
                { 1, 0, 1, 1, 1 },
                { 1, 1, 1, 1, 1 },
                { 1, 0, 0, 1, 0 }
        };

        System.out.println("Given matrix : ");
        printMatrix1(matrix);
        System.out.println();
       
        System.out.println("Maximum rectangle of 1s: " + maximalRectangle(matrix));

    }
}
