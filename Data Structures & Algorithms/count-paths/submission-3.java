class Solution {
    int[][] cache;

    public int uniquePaths(int m, int n) {
        cache = new int[m][n];
        Arrays.stream(cache).forEach(row -> Arrays.fill(row, -1));

        return dfs(m, n, 0, 0);
    }

    int dfs(int m, int n, int r, int c) {
        if(r < 0 || r >= m || c < 0 || c >= n) return 0;
        if(cache[r][c] != -1) return cache[r][c];
        if(r == m - 1 && c == n - 1) return 1;
        
        int rs = dfs(m, n, r + 1, c);
        int cs = dfs(m, n, r, c + 1);

        cache[r][c] = rs + cs;
        return rs + cs;
    }
    
}
