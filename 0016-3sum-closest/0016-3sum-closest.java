class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length -2 ; i++) {
            int j = i +1;
            int k = nums.length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if(s == target) return s;
                if(diff > Math.abs(s - target)) {
                    diff = Math.abs(s - target);
                    sum = s;
                }
                if(s > target) {
                    k--;
                } else 
                    j++;
            }
        }
        return sum;
    }
}