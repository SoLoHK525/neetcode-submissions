class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        // [-1,0,1,2,-1,-4]
        // [-4, -1, -1, 0, 1, 2]
        sort(nums.begin(), nums.end());
        vector<vector<int>> res;

        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] > 0) break;

            if(i > 0 && nums[i - 1] == nums[i]) continue;

            int target = -nums[i];
            int l = i + 1, r = nums.size() - 1;

            while(l < r) {
                int sum = nums[l] + nums[r];

                if(sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    res.push_back({nums[i], nums[l], nums[r]});
                    
                    l++;
                    
                    while(l < r && nums[l] == nums[l - 1]) l++;
                }
            }
        }

        return res;
    }
};
