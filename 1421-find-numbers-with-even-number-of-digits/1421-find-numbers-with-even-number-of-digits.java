class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int num : nums) {
            String str = String.valueOf(num);
            if(str.length() % 2 == 0) {
                count ++;
            }
        }   

        return count;
    }
}