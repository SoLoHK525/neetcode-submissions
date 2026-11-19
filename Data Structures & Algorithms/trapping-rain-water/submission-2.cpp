class Solution {
public:
    int trap(vector<int>& height) {
        int ml = 0, mr = 0;
        int res = 0;

        int size = height.size();
        int l = 0, r = size - 1;

        while(l < r) {
            int left = height[l];
            int right = height[r];

            ml = max(left, ml);
            mr = max(right, mr);

            if (ml <= mr) {
                res += ml - left;
                l++;
            } else {
                res += mr - right;
                r--;
            }
        }

        return res;
    }
};
