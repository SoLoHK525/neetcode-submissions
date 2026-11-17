class Solution {
    public void rotate(int[][] matrix) {
        inverse(matrix);
        transpose(matrix);
    }

    public void inverse(int[][] matrix) {
        int len = matrix.length;
        for(int r = 0; r < len / 2; r++) {
            for(int c = 0; c < matrix[0].length; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[len - 1 - r][c];
                matrix[len - 1 - r][c] = temp;
            }
        }
    }

    public void transpose(int[][] matrix) {
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < r; c++) {
                if(r == c) continue; // ignore diagonal
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }
}
