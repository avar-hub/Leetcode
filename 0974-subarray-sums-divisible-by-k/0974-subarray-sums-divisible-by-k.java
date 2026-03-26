class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            prefix[i] = sum;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for(int i : prefix) {
            int rem = (i % k + k) % k;
            if(map.containsKey(rem)) {
                count += map.get(rem);
                map.put(rem, map.get(rem) + 1);
            } else {
                map.put(rem, 1);
            }
        }
        return count;
    }
}