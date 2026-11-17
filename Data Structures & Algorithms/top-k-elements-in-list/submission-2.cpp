class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> cnt;
        vector<vector<int>> freq(nums.size() + 1);
        for(int i : nums) {
            cnt[i]++;
        }

        for(auto& [k, v] : cnt) {
            freq[v].push_back(k);
        }

        vector<int> res;

        for(int i = freq.size() - 1; i > 0; --i) {
            for(int n : freq[i]) {
                res.push_back(n);

                if(res.size() == k) {
                    return res;
                }
            }
        }
    }
};
