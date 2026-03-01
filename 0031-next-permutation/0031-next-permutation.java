class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;

        int n = nums.length;
        int pivotIndex = -1;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivotIndex = i - 1;
                break;
            }
        }

        if (pivotIndex != -1) {
            for (int i = n - 1; i > pivotIndex; i--) {
                if (nums[i] > nums[pivotIndex]) {
                    swap(pivotIndex, i, nums);
                    break;
                }
            }
        }

        reverse(pivotIndex + 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int index, int[] nums) {
        int i = index;
        int j = nums.length - 1;

        while (i < j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
}