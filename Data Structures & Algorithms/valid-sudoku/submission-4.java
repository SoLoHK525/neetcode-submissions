class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> gridMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();

        for(int i = 0; i < 9; i++) {
            gridMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
        }

        for(int r = 0; r < board.length; r++) {
            Set<Character> rowSet = new HashSet<>();
            for(int c = 0; c < board[r].length; c++) {
                Character cell = board[r][c];
                if (cell == '.') continue; 

                int grid = getGrid(r, c);
                System.out.println("Grid: " + grid + " Cell: " + cell);
                Set<Character> gm = gridMap.get(grid);
                Set<Character> cm = colMap.get(c);

                System.out.println("SSS: " + 
                    cm.contains(cell) +
                    rowSet.contains(cell) +
                    gm.contains(cell)
                );

                if(
                    cm.contains(cell) ||
                    rowSet.contains(cell) ||
                    gm.contains(cell)
                ) {
                    return false;
                } else {
                    rowSet.add(cell);
                    gm.add(cell);
                    cm.add(cell);
                }
            }
        }

        return true;
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