class Solution {
    public boolean checkPowersOfThree(int n) {
        return helper(n, 0, 0);
    }

    private boolean helper(int n, int index, int value) {
        if(value > n || index > 20) {
            return false;
        }

        if(value == n) {
            return true;
        }

        int a = (int) Math.pow(3, index);
        boolean pick = helper(n, index + 1, value + a);
        boolean notPick = helper(n, index + 1, value);

        return pick || notPick;
    }
}