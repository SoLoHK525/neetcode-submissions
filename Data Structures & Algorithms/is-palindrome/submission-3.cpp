class Solution {
public:
    bool isPalindrome(string s) {
        if (s.empty()) return true;

        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            cout << "l: " << l << ", r: " << r << endl;

            while(!isalnum(s[l])) l++;
            while(!isalnum(s[r])) r--;

            cout << "l: " << l << ", r: " << r << endl;
            if(l >= r) return true;

            if(tolower(s[l]) != tolower(s[r])) return false;

            l++;
            r--;
        }

        return true;
    }
};
