class Solution {
    int[] cache;

    public int lengthOfLIS(int[] nums) {
        cache = new int[nums.length];
        Arrays.fill(cache, -1);

        int res = 0;

        for(int i = 0; i < nums.length; i++) {
            res = Math.max(res, dfs(nums, i));
        }

        return res;
    }

    public int dfs(int[] nums, int i) {
        int len = 1;

        if(cache[i] != -1) return cache[i];

        for(int j = i + 1; j < nums.length; j++) {
            if(nums[j] > nums[i]) {
                int result = dfs(nums, j) + 1;
                len = Math.max(len, result);
            }
        }


        cache[i] = len;
        return len;
    }
}
