class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int count = 0;
        while (count < n) {
            for (int pointer = count; pointer < n; pointer++) {
                int num = matrix[count][pointer];
                matrix[count][pointer] = matrix[pointer][count];
                matrix[pointer][count] = num;
            }
            count++;
        }
        for(int i = 0; i < n; i++) {
            int j = 0 , k = n - 1;
            while(j < k) {
                int num = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = num;
                j++;
                k--;
            }
        }
    }
}