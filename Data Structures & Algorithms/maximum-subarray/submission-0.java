class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];

        Arrays.fill(dp, 0);
        int res = -1;

        for(int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i + 1]);
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
