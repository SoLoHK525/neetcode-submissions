class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        int res = 0;

        unordered_set<int> st;

        for(int n : nums) {
            st.insert(n);
        }

        for(int n : st) {
            if(st.contains(n - 1)) continue;

            int cnt = 1;
            while(st.contains(n + cnt)) {
                cnt++;
            }

            res = max(res, cnt);
        }

        return res;    
    }
};

