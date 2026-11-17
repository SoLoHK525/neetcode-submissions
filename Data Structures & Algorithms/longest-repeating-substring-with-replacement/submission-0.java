class Solution {
    public int characterReplacement(String s, int k) {
        int res = 1;
        int[] freq = new int[26];

        int left = 0, maxf = 0;
        for(int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            freq[index]++;
            maxf = Math.max(maxf, freq[index]);

            while((right - left + 1) - maxf > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(maxf, right - left + 1);
        }
        
        return res;
    }
}
