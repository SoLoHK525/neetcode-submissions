class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        unordered_map<int, unordered_set<char>> mp;

        for(int y = 0; y < board.size(); y++) {
            for(int x = 0; x < board[y].size(); x++) {
                char value = board[y][x];
                if(value == '.') continue;

                int grid = getGrid(x, y);

                if(mp[grid].contains(value)) {
                    return false;
                }

                for(int r = 0; r < board.size(); r++) {
                    if(r == y) continue;
                    if(value == '.') continue;
                    if(board[r][x] == value) return false;
                }

                for(int c = 0; c < board[y].size(); c++) {
                    if(c == x) continue;
                    if(value == '.') continue;
                    if(board[y][c] == value) return false;
                }

                mp[grid].insert(value);
            }
        }

        return true;
    }

    int getGrid(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }
};
