class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int end = 0;

        char[] arr = s.toCharArray();
        int res = 0;
        for(char c : arr) {
            if(set.contains(c)) {
                res = Math.max(res, end - start);

                while(arr[start] != c) {
                    set.remove(arr[start]);
                    start++;
                }

                start++;
                end++;
            } else {
                set.add(c);
                end++;
            }
        }

        res = Math.max(res, end - start);

        return res;
    }
}
