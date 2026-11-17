class Solution {
    public boolean exist(char[][] board, String word) {
        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board[y].length; x++) {
                if(dfs(board, x, y, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int idx) {
        if(idx == word.length()) {
            return true;
        }
        
        if(x < 0 || x >= board[0].length || y < 0 || y >= board.length) {
            return false;
        }

        if(board[y][x] != word.charAt(idx)) {
            return false;
        }

        idx++;

        char c = board[y][x];

        board[y][x] = '#';
        boolean res = dfs(board, x + 1, y, word, idx) || 
            dfs(board, x - 1, y, word, idx) ||
            dfs(board, x, y + 1, word, idx) || 
            dfs(board, x, y - 1, word, idx);

        board[y][x] = c;

        return res;
    }
}
