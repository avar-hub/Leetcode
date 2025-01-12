class Solution {
    public int maxArea(int[] height) {
        int i = 0 ,j = height.length - 1;
        int maxCapacity = 0;
        while( i <= j) {
            int min = Math.min(height[i], height[j]);
            int waterContent = min * (j - i);
            maxCapacity = Math.max(maxCapacity, waterContent);
            if (height[i] < height[j]) {
                i++;
            } else if(height[i] > height[j]) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return maxCapacity;
    }
}