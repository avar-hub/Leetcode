class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> zeroRow = new ArrayList<>();
        List<Integer> zeroCol = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row ; i++ ) {
            for(int j = 0 ; j < col; j++){
                if(matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }
        }
        for(int i =0; i < row ; i++ ) {
            for(int j = 0 ; j < col; j++){
                if(zeroRow.contains(i)) {
                    matrix[i][j] = 0;
                }
                if(zeroCol.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}