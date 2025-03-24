
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedMeetings = new ArrayList<>();
        for (int[] meeting : meetings) {
            if (mergedMeetings.isEmpty() || mergedMeetings.get(mergedMeetings.size() - 1)[1] < meeting[0]) {
                mergedMeetings.add(meeting);
            } else {
                mergedMeetings.get(mergedMeetings.size() - 1)[1] = Math.max(mergedMeetings.get(mergedMeetings.size() - 1)[1], meeting[1]);
            }
        }

        long busyDays = 0;
        for (int[] meeting : mergedMeetings) {
            busyDays += (long) (meeting[1] - meeting[0] + 1); 
        }

        return (int) (days - busyDays);
    }
}