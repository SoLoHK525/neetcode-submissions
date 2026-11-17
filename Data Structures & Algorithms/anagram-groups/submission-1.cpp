class Solution {
public:
    string getSignature(string s) {
        vector<int> sig(26,0);

        for(char c : s) {
            sig[c - 'a']++;
        }

        string result;

        for(int i : sig) {
            result.push_back(i);
        }

        return result;
    }

    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> map;

        for(string s : strs) {
            auto sig = getSignature(s);
            
            if(map.contains(sig)) {
                vector<string> group = map.at(sig);
                group.push_back(s);

                map.insert_or_assign(sig, group);
            } else {
                map.insert({sig, vector<string>{s}});
            }
        }

        vector<vector<string>> result;

        for(const auto& [key, value] : map) {
            result.push_back(value);
        }

        return result;
    }
};
