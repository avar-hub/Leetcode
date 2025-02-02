class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (e1, e2) -> e1[1] - e2[1]);
        Set<Integer> set = new HashSet<>();
        for(int[] point : points) {
            boolean flag = true;
            int start = point[0];
            int end = point[1];
            if(!set.isEmpty()) {
                for(int i : set) {
                    if(i >= start && i <= end) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
                set.add(end);
            }
        }
        return set.size();
    }
}