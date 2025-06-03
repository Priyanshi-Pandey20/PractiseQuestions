public class Hello2 {

    public static int[][] transposeMatrix(int m, int n, int[][] matrix) {
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

    public static void main(String[] args) {
        int[][] mt = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        int[][] result = transposeMatrix(3, 3, mt);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        printDiagonalElements(mt);
    }
}
