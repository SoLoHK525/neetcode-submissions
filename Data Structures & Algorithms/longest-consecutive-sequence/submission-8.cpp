class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> st;
        int res = 0;

        for(int n : nums) st.insert(n);

        for(int n : nums) {
            if(st.find(n - 1) != st.end()) continue;

            int cnt = 1;

            for(int i = 1; i < nums.size(); i++) {
                if(st.find(n + i) != st.end()) {
                    cnt++;
                } else {
                    break;
                }
            }

            res = max(res, cnt);
        }

        return res;
    }
};
