class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer> gridMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();

        for(int i = 0; i < 9; i++) {
            gridMap.put(i, 0);
            colMap.put(i, 0);
        }

        for(int r = 0; r < board.length; r++) {
            Integer rowState = 0;
            for(int c = 0; c < board[r].length; c++) {
                Character cell = board[r][c];
                Integer flag = getFlag(cell);
                if (cell == '.') continue; 

                int grid = getGrid(r, c);

                Integer gm = gridMap.get(grid);
                Integer cm = colMap.get(c);

                if(
                    (flag & cm) == flag ||
                    (flag & rowState) == flag ||
                    (flag & gm) == flag
                ) {
                    return false;
                } else {
                    colMap.put(c, cm |= flag);
                    rowState |= flag;
                    gridMap.put(grid, gm |= flag);
                }
            }
        }

        return true;
    }

    Integer getFlag(Character c) {
        return 1 << (c - '0');
    }

    int getGrid(int row, int col) {
        return (row / 3) * 3 + (col / 3);
    }
}
// [
//     [".",".","4",".",".",".","6","3","."],
//     [".",".",".",".",".",".",".",".","."],
//     ["5",".",".",".",".",".",".","9","."],
//     [".",".",".","5","6",".",".",".","."],
//     ["4",".","3",".",".",".",".",".","1"],
//     [".",".",".","7",".",".",".",".","."],
//     [".",".",".","5",".",".",".",".","."],
//     [".",".",".",".",".",".",".",".","."],
//     [".",".",".",".",".",".",".",".","."]
// ]