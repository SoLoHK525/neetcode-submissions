#include <unordered_map>

class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        set<int> st;
        
        for(auto i : nums) {
            if (st.contains(i)) return true;

            st.insert(i);
        }

        return false;
    }
};