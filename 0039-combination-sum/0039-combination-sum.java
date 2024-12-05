class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int ind, int target, int[] cand, List<Integer> list, List<List<Integer>> ans) {
        if(ind == cand.length) {
            if(target == 0) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if (cand[ind] <= target) {
            list.add(cand[ind]);
            helper(ind, target - cand[ind], cand, list, ans);
            list.remove(list.size() - 1);
        }
        helper(ind + 1, target, cand, list, ans);

    }
}