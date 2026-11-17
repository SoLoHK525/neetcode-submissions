class Solution {
    final static int NONE = 0;
    final static int PACIFIC = 2;
    final static int ATLANTIC = 1;
    final static int BOTH = 3;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < heights.length; r++) {
            for(int c = 0; c < heights[0].length; c++) {
                if(dfs(heights, r, c, Integer.MAX_VALUE) == BOTH) {
                    res.add(List.of(r, c));
                }
            }
        }

        return res;
    }

    // pacific, atlantic
    public int dfs(int[][] heights, int r, int c, int previousHeight) {
        // pacific detection
        if(r < 0 || c < 0) return PACIFIC;
        if(r >= heights.length || c >= heights[0].length) return ATLANTIC;
        if(heights[r][c] == -1 || heights[r][c] > previousHeight) return NONE;

        // CONTINUE dfs logic here
        int height = heights[r][c];
        heights[r][c] = -1;

        int result = dfs(heights, r + 1, c, height) |
        dfs(heights, r - 1, c, height) |
        dfs(heights, r, c + 1, height) |
        dfs(heights, r, c - 1, height);

        heights[r][c] = height;

        return result;
    }

}
