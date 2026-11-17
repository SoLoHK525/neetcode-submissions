class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n - 1) return false;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();

        return dfs(n, adj, visited, 0, -1) && visited.size() == n;
    }

    public boolean dfs(int n, 
    List<List<Integer>> adj,
    Set<Integer> visited,
    int idx,
    int parent
    ) {
        if(visited.contains(idx)) return false;

        visited.add(idx);
        
        boolean res = true;
        
        for(int neighbor : adj.get(idx)) {
            if(neighbor == parent) continue;

            res &= dfs(n, adj, visited, neighbor, idx);
        }

        return res;
    }
}
