class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top = 0,
        right = matrix[0].length - 1,
        bottom = matrix.length - 1,
        left = 0;

        int[] pos = new int[]{0, 0};
        int[] vec = new int[]{1, 0};

        int size = matrix[0].length * matrix.length;

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            System.out.printf("x: %d, y: %d\n", pos[0], pos[1]);
            res.add(matrix[pos[1]][pos[0]]);

            if(vec[0] == 1 && vec[1] == 0 && pos[0] >= right) { // if right
                top++;
                vec = new int[]{0, 1};
            } else if(vec[0] == -1 && vec[1] == 0 && pos[0] <= left) { // if left
                bottom--;
                vec = new int[]{0, -1};
            } else if(vec[0] == 0 && vec[1] == 1 && pos[1] >= bottom) { // if down
                right--;
                vec = new int[]{-1, 0};
            } else if(vec[0] == 0 && vec[1] == -1 && pos[1] <= top) { // if up
                left++;
                vec = new int[]{1, 0};
            }

            pos[0] += vec[0];
            pos[1] += vec[1];
        }

        return res;
    }
}
