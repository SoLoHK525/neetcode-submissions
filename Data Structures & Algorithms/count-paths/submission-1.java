class Solution {
    public int uniquePaths(int m, int n) {
        return dfs(m, n, 0, 0);
    }

    int dfs(int m, int n, int r, int c) {
        if(r < 0 || r >= m || c < 0 || c >= n) return 0;
        if(r == m - 1 && c == n - 1) return 1;
        
        int rs = dfs(m, n, r + 1, c);
        int cs = dfs(m, n, r, c + 1);

        rs = rs == 0 ? 0 : rs;
        cs = cs == 0 ? 0 : cs;

        return rs + cs;
    }
    
}
