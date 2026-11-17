class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        int[] rob = new int[nums.length];
        int[] nrob = new int[nums.length];

        rob[0] = nums[0];
        nrob[0] = 0;

        int i = 1;
        for(;i < nums.length; i++) {
            int curr = nums[i];
            rob[i] = nrob[i - 1] + curr;
            nrob[i] = Math.max(rob[i - 1], nrob[i - 1]);
        }

        return Math.max(Math.max(rob[i - 1], rob[i - 2]), Math.max(nrob[i - 1], nrob[i - 2]));
    }
}
