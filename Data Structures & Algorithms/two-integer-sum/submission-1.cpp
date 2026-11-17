class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result(2, 0);

        unordered_map<int, int> map;

        int idx = 0;
        for(int i : nums) {
            int offset = target - i;

            if(map.contains(i)) {
                return vector<int>{map.at(i), idx};
            }

            map.insert_or_assign(offset, idx);

            idx++;
        }

        return vector<int>();
    }
};
