class Solution {
    public int countSubstrings(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            int oddCount = expandFromMid(s, i, i);
            int evenCount = expandFromMid(s, i, i + 1);
            sum += oddCount + evenCount;
        }

        return sum;
    }

    public int expandFromMid(String s, int l, int r) {
        int cnt = 0;

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            cnt++;
            l--;
            r++;
        }

        return cnt; 
    }
}
