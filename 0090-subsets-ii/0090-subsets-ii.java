class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
       List<List<Integer>> list=new ArrayList<>();
       func(list,nums,0,new ArrayList<Integer>());
       return list; 
    }

    public static void func(List<List<Integer>> list , int[] nums , int i , ArrayList<Integer> temp) {

        list.add(new ArrayList<>(temp));
        for(int j=i;j<nums.length;j++) {
        if(j>i && nums[j]==nums[j-1]) continue;
        temp.add(nums[j]);
        func(list,nums,j+1,temp);
        temp.remove(temp.size()-1);
        }
    }
}