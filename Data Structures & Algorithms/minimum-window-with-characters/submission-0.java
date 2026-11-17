class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int cnt = 0;
        int min = s.length() + 1;
        int start = -1, end = -1;

        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);

            if(!map.containsKey(c)) continue;

            int prev = map.put(c, map.get(c) - 1);

            if(prev == 1) {
                cnt++;
            } 

            while(cnt == map.size()) {
                if(r - l + 1 < min) {
                    min = r - l + 1;
                    start = l;
                    end = r;
                }

                char lc = s.charAt(l);
                if(map.containsKey(lc)) {
                    int prev2 = map.put(lc, map.get(lc) + 1);
                    if(prev2 == 0) cnt--;
                }

                l++;
            }
        }

        if (start == -1 || end == -1) {
            return "";
        }

        return s.substring(start, end + 1);
    }
}
