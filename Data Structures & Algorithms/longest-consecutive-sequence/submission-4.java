class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums) {
            if(!map.containsKey(n)) {
                int len = map.getOrDefault(n - 1, 0) + map.getOrDefault(n + 1, 0) + 1;
                map.put(n, len);

                map.put(n - map.getOrDefault(n - 1, 0), len);
                map.put(n + map.getOrDefault(n + 1, 0), len);
                res = Math.max(res, len);
            }
        }

        return res;
    }
}


