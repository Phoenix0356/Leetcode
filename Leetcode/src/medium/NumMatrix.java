package medium;


class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix = new int[matrix.length+1][matrix[0].length+1];
        for (int i=1;i<this.matrix.length;i++) {
            for (int j = 1; j < this.matrix[0].length; j++) {
                this.matrix[i][j] = this.matrix[i][j-1]+this.matrix[i-1][j]-this.matrix[i-1][j-1]
                + matrix[i-1][j-1];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return matrix[row2+1][col2+1]-matrix[row1][col2+1]-matrix[row2+1][col1]+matrix[row1][col1];
    }
}

