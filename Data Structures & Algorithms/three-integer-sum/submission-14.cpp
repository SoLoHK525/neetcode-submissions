class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int size = nums.size();
        sort(nums.begin(), nums.end());

        vector<vector<int>> result;

        for(int i = 0; i < size - 2; i++) {
            if(nums[i] > 0) break;
            if(i > 0 && nums[i] == nums[i - 1]) continue; 
            int target = -nums[i];
            int l = i + 1;
            int r = nums.size() - 1;

            while(l < r) {
                int sum = nums[l] + nums[r];
                
                if(sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    result.push_back({nums[i], nums[l], nums[r]});

                    while(l < r && nums[l + 1] == nums[l]) l++;

                    l++;
                }
            }
        }

        return result;
    }
};
