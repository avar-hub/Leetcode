class Solution {
    public long coloredCells(int n) {
        long ans = 1;
        if(n == 1) {
            return ans;
        }
        for(int i = 1; i < n  ; i++) {
            ans += 4 * i;
        }

        return ans;
    }
}