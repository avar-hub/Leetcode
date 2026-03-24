class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        Map<String, List<String[]>> map = new HashMap<>();
        boolean[] invalid = new boolean[transactions.length];

        for (int idx = 0; idx < transactions.length; idx++) {
            String s = transactions[idx];
            String[] parts = s.split(",");

            if (Integer.parseInt(parts[2]) > 1000) {
                invalid[idx] = true;
            }

            if (!map.containsKey(parts[0])) {
                map.put(parts[0], new ArrayList<>());
            }

            List<String[]> mapVal = map.get(parts[0]);

            for (String[] arr : mapVal) {
                int prevIndex = Integer.parseInt(arr[4]); // stored index

                if (Math.abs(Integer.parseInt(parts[1]) - Integer.parseInt(arr[1])) <= 60 &&
                        !arr[3].equals(parts[3])) {

                    invalid[idx] = true;
                    invalid[prevIndex] = true;
                }
            }

            // store parts + index
            String[] store = new String[5];
            for (int i = 0; i < 4; i++) store[i] = parts[i];
            store[4] = String.valueOf(idx);

            mapVal.add(store);
        }

        // collect results
        for (int i = 0; i < transactions.length; i++) {
            if (invalid[i]) {
                ans.add(transactions[i]);
            }
        }

        return ans;
    }
}