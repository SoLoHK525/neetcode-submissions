class Solution {
public:
    string getSignature(const string& s) {
        int sig[26] = {0}; // Stack array avoids heap allocation
        for (char c : s) {
            sig[c - 'a']++;
        }
        return string(sig, sig + 26); // Constructs 26-char string directly
    }

    vector<vector<string>> groupAnagrams(vector<string>& strs) {
         unordered_map<string, vector<string>> map;

        for (const string& s : strs) {
            map[getSignature(s)].push_back(s);
        }

        vector<vector<string>> result;
        result.reserve(map.size());

        for (auto& [key, value] : map) {
            result.push_back(std::move(value));
        }

        return result;
    }
};
