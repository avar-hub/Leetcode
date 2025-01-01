class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalExp = 0, totalInc = 0;
        for(int i = 0; i< gas.length; i++) {
            totalExp += cost[i];
            totalInc += gas[i];
        }

        if(totalExp > totalInc) 
            return -1;

        int rem = 0;
        int station = 0;

        for (int i = 0; i < gas.length; i++) {
            rem += gas[i] - cost[i];

            if (rem < 0) {
                rem = 0;
                station = i + 1;
            }
        }

        return station;
    }
}