class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max = citations.length;
        for(int i = 0 ; i < citations.length; i++) {
            if(max <= citations[i]) {
                return max;
            }
            max--;
        }
        return max;
    }
}