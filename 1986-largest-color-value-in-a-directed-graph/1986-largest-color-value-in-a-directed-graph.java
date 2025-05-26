class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        List<Integer> topo = isCyclic(adjList, indegree.clone(), n);
        if (topo.isEmpty()) {
            return -1; 
        }

        return helper(adjList, colors, topo);
    }

    private int helper(List<List<Integer>> adjList, String colors, List<Integer> topo) {
        int n = colors.length();
        int[][] count = new int[n][26];
        int maxColorValue = 0;

        for (int node : topo) {
            int colorIndex = colors.charAt(node) - 'a';
            count[node][colorIndex]++;

            maxColorValue = Math.max(maxColorValue, count[node][colorIndex]);

            for (int neighbor : adjList.get(node)) {
                for (int c = 0; c < 26; c++) {
                    count[neighbor][c] = Math.max(count[neighbor][c], count[node][c]);
                }
            }
        }

        return maxColorValue;
    }

    private List<Integer> isCyclic(List<List<Integer>> adjList, int[] indegree, int n) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            list.add(node);

            for (int neighbor : adjList.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return list.size() != n ? new ArrayList<>() : list;
    }
}
