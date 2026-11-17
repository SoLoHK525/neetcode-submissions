class Solution {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if(len != t.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < len; i++) {
            int sIndex = s.charAt(i) - 'a';
            int tIndex = t.charAt(i) - 'a';
            freq[sIndex]++;
            freq[tIndex]--;
        }

        for (int i : freq) {
            if (i != 0) {
                return false;
            }
        }

        return true;
    }
}
