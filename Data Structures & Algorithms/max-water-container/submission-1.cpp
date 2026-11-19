class Solution {
public:
    int maxArea(vector<int>& heights) {
        int l = 0, r = heights.size() - 1;

        int res = 0;

        while(l < r) {
            int lh = heights[l];
            int rh = heights[r];
            int area = (r - l) * min(lh, rh);

            if(area > res) {
                res = area;
            }

            if(lh >= rh) {
                r--;
            } else {
                l++;
            }
        }

        return res;
    }
};
