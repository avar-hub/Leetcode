import java.util.*;

class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
        }
        
        Collections.sort(list);
        int target = list.get(list.size() / 2);
        
        for (int i : list) {
            if (i % x != target % x) {
                return -1; 
            }
        }
        
        int count = 0;
        for (int i : list) {
            count += Math.abs(target - i) / x;
        }

        return count;
    }
}
