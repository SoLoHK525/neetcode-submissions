class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int len = 0;


        for(int i = 0; i < s.length(); i++) {
            int oddLen = expandFromMid(s, i, i);
            int evenLen = expandFromMid(s, i, i + 1);
            int maxLen = Math.max(oddLen, evenLen);

            if(maxLen > len) {
                int startIndex = i - ((maxLen - 1) / 2);
                int endIndex = startIndex + maxLen;
                res = s.substring(startIndex, endIndex);
                len = maxLen;
            }
        }

        return res;
    }

    public int expandFromMid(String s, int l, int r) {
        int len = 0;

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if(r - l + 1 > len) {
                len = r - l + 1;
            }

            l--;
            r++;
        }

        return len; 
    }
}
