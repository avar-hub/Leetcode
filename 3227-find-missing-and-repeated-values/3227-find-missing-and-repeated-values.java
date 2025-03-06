class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int [] ans = new int[2];
        boolean[] arr = new boolean[n * n + 1];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if( arr[grid[i][j]] == true) {
                    ans[0] = grid[i][j];
                }
                arr[grid[i][j]] = true;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(!arr[i]) {
                ans[1] = i;
            }
        }

        return ans;
    }
}