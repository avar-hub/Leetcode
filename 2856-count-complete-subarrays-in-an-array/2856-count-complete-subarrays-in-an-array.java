class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            s.add(nums[i]);
        }
        int dist = s.size();
        System.out.println(dist);
        for(int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i; j < nums.length; j++) {
                set.add(nums[j]);
                if(set.size() == dist) {
                    count++;
                }
            }
        }
        return count;
    }
}