class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, count = 0, i = 0;
        while (i < nums.length) {
            sum += nums[i];
            if (nums[i] == k) {
                count++;
            }
            int j = i + 1;
            while (j < nums.length) {
                sum += nums[j];
                if (sum == k)
                    count++;
                j++;
            }
            sum = 0;
            i++;
        }
        return count;
    }
}