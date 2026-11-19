class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> mp;

        int res = 0;
        int l = 0, r = 0;
        
        for(; r < s.length(); r++) {
            char c = s[r];

            if(mp.find(c) != mp.end()) {
                l = max(mp[c] + 1, l);
            }

            mp[c] = r;
            res = max(res, r - l + 1);
        }

        return res;
    }
};
