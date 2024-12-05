class Solution {
    public boolean canChange(String start, String target) {
        if (start.length() != target.length()) {
            return false;
        }

        int i = 0, j = 0;
        while (i < start.length() || j < target.length()) {
            while (i < start.length() && start.charAt(i) == '_') {
                i++;
            }
            while (j < target.length() && target.charAt(j) == '_') {
                j++;
            }

            if (i == start.length() && j == target.length()) {
                return true;
            }

            if (i == start.length() || j == target.length()) {
                return false;
            }

            if (start.charAt(i) != target.charAt(j)) {
                return false;
            }

            if (start.charAt(i) == 'R' && i > j) {
                return false; 
            }
            if (start.charAt(i) == 'L' && i < j) {
                return false; 
            }

            i++;
            j++;
        }

        return true;
    }
}
