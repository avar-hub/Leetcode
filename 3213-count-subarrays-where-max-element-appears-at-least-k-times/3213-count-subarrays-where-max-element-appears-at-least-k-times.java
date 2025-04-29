class Solution {
    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        long count = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        int freq = 0;
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == max) {
                freq++;
            }
            while (freq >= k) {
                count += (nums.length - j);

                if (nums[i] == max) {
                    freq--;
                }
                i++;
            }
            j++;
        }
        return count;
    }
}