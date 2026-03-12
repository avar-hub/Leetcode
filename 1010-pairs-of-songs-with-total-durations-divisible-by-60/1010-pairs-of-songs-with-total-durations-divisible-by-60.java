class Solution {
    public int numPairsDivisibleBy60(int[] time) {

        int count = 0;

        for (int i = 0; i < time.length; i++) {
            time[i] %= 60;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : time) {

            int complement = (60 - i) % 60;

            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        return count;
    }
}