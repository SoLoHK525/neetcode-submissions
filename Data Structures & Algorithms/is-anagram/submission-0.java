class Solution {
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        if(len != t.length()) return false;

        int[] freqS = new int[26];
        int[] freqT = new int[26];

        for (int i = 0; i < len; i++) {
            int sIndex = s.charAt(i) - 'a';
            int tIndex = t.charAt(i) - 'a';
            freqS[sIndex]++;
            freqT[tIndex]++;
        }

        for (int i = 0; i < 26; i++) {
            if (freqS[i] != freqT[i]) {
                return false;
            }
        }

        return true;
    }
}
