class Solution {
public:
    string minWindow(string s, string t) {
        if(t.empty()) return "";

        unordered_map<char, int> mp, src;

        for(char c : t) {
            src[c]++;
        }

        pair<int, int> res = {-1, -1};
        int resLen = INT_MAX;

        int l = 0;
        int have = 0, want = src.size();

        for(int r = 0; r < s.size(); r++) {
            char c = s[r];
            mp[c]++;

            if(src.count(c) && mp[c] == src[c]) {
                have++;
            }

            while(have == want) {
                if((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res = {l, r};
                }

                mp[s[l]]--;

                if(src.count(s[l]) && mp[s[l]] < src[s[l]]) {
                    have--;
                }

                l++;
            }
        }

        return resLen == INT_MAX ? "" : s.substr(res.first, resLen);
    }
};
