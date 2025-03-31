class Solution {
    public long putMarbles(int[] weights, int k) {
        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < weights.length - 1) {
            list.add(weights[i] + weights[i + 1]);
            i++;
        }
        Collections.sort(list);
        long minSum = 0;
        long maxSum = 0;
        for(int j = 0; j < k - 1; j++) {
            minSum += list.get(j);
            maxSum += list.get(list.size() - 1 - j);
        }

        return maxSum - minSum;

    }
}