class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int i = 0, j = 0;
        int reqCount = t.length();
        int ansLength = Integer.MAX_VALUE;
        String ans = "";

        while (j < s.length()) {
            // Expanding the window
            char endChar = s.charAt(j);
            if (map.containsKey(endChar)) {
                if (map.get(endChar) > 0) {
                    reqCount--;
                }
                map.put(endChar, map.get(endChar) - 1);
            }
            j++;

            // Shrinking the window
            while (reqCount == 0) {
                // Update the answer if this window is smaller
                if (j - i < ansLength) {
                    ansLength = j - i;
                    ans = s.substring(i, j);
                }

                char startChar = s.charAt(i);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        reqCount++;
                    }
                }
                i++;
            }
        }

        return ans;
    }
}
