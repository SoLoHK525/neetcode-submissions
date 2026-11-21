class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        unordered_map<char, int> mp;
        for (char c : s1) {
            mp[c]++;
        }

        int cnt = s1.size();
        int l = 0;

        for (int r = 0; r < s2.size(); r++) {
            if(mp.count(s2[r])) {
                if(mp[s2[r]] > 0) {
                    cnt--;
                }
                mp[s2[r]]--;
            }

            if(r - l + 1 > s1.size()) {
                if(mp.count(s2[l])) {
                    if(mp[s2[l]] >= 0) {
                        cnt++;
                    }
                    mp[s2[l]]++;
                }

                l++;
            }

            if(cnt == 0) return true;
        }

        return false;
    }
};