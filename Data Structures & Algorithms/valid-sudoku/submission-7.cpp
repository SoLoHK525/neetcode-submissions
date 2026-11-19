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

                if(rows[r] & (1 << val)) return false;
                if(cols[c] & (1 << val)) return false;
                if(squares[(r / 3) * 3 + (c / 3)] & (1 << val)) return false;

                rows[r] |= 1 << val;
                cols[c] |= 1 << val;
                squares[(r / 3) * 3 + (c / 3)] |= 1 << val;
            }
        }

        return true;
    }

    int getGrid(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }
};
