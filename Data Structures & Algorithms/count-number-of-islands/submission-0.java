class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;

        for(int y = 0; y < grid.length; y++) {
            for(int x = 0; x < grid[y].length; x++) {
                if(grid[y][x] == '1') {
                    res++;
                    dfs(grid, x, y);
                }
            }
        }
        
        return res;
    }

    public void dfs(char[][] grid, int x, int y) {
        if(x < 0 || x > grid[0].length - 1 || y < 0 || y > grid.length - 1) {
            return;
        }
        if(grid[y][x] != '1') {
            return;
        }

        grid[y][x] = '#';

        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
