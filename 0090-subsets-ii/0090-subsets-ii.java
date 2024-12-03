class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> ans = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> set = helper(nums, 0, new ArrayList<>(), ans);
        for(List<Integer> l : set) {
            res.add(new ArrayList<>(l));
        }
        return res; 
    }

    private HashSet<List<Integer>> helper(int[] nums, int i, List<Integer> list, HashSet<List<Integer>> ans) {
        if(i >= nums.length) {
            ans.add(new ArrayList<>(list));
            return ans;
        }
        list.add(nums[i]);
        helper(nums, i+1, list, ans);
        list.remove(list.size() - 1);
        helper(nums, i+1, list, ans);
        return ans;
    }
}