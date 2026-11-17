class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int currMin = 1;
        int currMax = 1;

        for(int n : nums) {
            int tmp = currMax * n;
            currMax = Math.max(Math.max(n * currMax, n * currMin), n);
            currMin = Math.min(Math.min(n * currMin, tmp), n);
            res = Math.max(res, currMax);
        }

        return res;
    }
}
