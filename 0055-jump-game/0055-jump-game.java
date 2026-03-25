class Solution {
    public boolean canJump(int[] nums) {
        int left = 0 , right = nums[0], max = 0;
        while(left <= right) {
            max = Math.max(max, left + nums[left]);
            if(max >= nums.length - 1) return true;
            left++;
            right = max;
        }
        return false;
    }
}