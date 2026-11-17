class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        int res = 0;
        for(int i = 0; i < n; i++) {
            if(visited.contains(i)) continue;

            dfs(adj, visited, i);
            res++;
        }

        return res;
    }

    void dfs(List<List<Integer>> adj, Set<Integer> visited, int idx) {
        if(visited.contains(idx)) return;

        visited.add(idx);

        for(int neighbor : adj.get(idx)) {
            dfs(adj, visited, neighbor);
        }
    }
}
