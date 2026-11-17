class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;

        Stack<int[]> s = new Stack<>();

        for(int i = 0; i < heights.length; i++) {
            int n = heights[i];

            if(s.isEmpty() || s.peek()[1] <= n) {
                s.push(new int[]{i, n});
            } else {
                int[] el = null;

                while(!s.isEmpty() && s.peek()[1] > n) {
                    el = s.pop();

                    int area = (i - el[0]) * el[1];

                    if(area > res) {
                        res = area;
                    }
                }

                if(el != null) {
                    s.push(new int[]{el[0], n});
                }
            }
        }

        int i = heights.length;

        while(!s.isEmpty()) {
            int[] el = s.pop();

            int area = (i - el[0]) * el[1];

            if(area > res) {
                res = area;
            }
        }

        return res;
    }
}
