class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int[] horizontalCutsAreaDiff = new int[horizontalCuts.length + 1];
        int[] verticalCutsAreaDiff = new int[verticalCuts.length + 1];
        horizontalCutsAreaDiff[0] = horizontalCuts[0];
        verticalCutsAreaDiff[0] = verticalCuts[0];
        int i = 1;
        while (i < horizontalCuts.length) {
            horizontalCutsAreaDiff[i] = horizontalCuts[i] - horizontalCuts[i - 1];
            i++; 
        }
        horizontalCutsAreaDiff[i] = h - horizontalCuts[horizontalCuts.length - 1];
        i = 1;
        while (i < verticalCuts.length) {
            verticalCutsAreaDiff[i] = verticalCuts[i] - verticalCuts[i - 1];
            i++;
        }
        verticalCutsAreaDiff[i] = w - verticalCuts[verticalCuts.length - 1]; 

        Arrays.sort(horizontalCutsAreaDiff); 
        Arrays.sort(verticalCutsAreaDiff);

        long maxH = horizontalCutsAreaDiff[horizontalCutsAreaDiff.length - 1];
        long maxV = verticalCutsAreaDiff[verticalCutsAreaDiff.length - 1];

        return (int)((maxH * maxV) % 1000000007);
    }
}