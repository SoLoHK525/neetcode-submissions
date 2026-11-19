class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        int rows[9] = {0};
        int cols[9] = {0};
        int squares[9] = {0};

        for(int r = 0; r < board.size(); r++) {
            for(int c = 0; c < board[r].size(); c++) {
                if (board[r][c] == '.') continue;

                int val = board[r][c] - '0';
                int mask = 1 << val;
                int sqrIdx = (r / 3) * 3 + (c / 3);

                if(rows[r] & mask) return false;
                if(cols[c] & mask) return false;
                if(squares[sqrIdx] & mask) return false;

                rows[r] |= mask;
                cols[c] |= mask;
                squares[sqrIdx] |= mask;
            }
        }

        return true;
    }
};
