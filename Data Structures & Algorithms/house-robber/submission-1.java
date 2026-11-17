class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, // robbing
        rob2 = 0; // not robbing

        for(int i : nums) {
            int temp = rob2 + i;
            rob2 = Math.max(rob1, rob2);
            rob1 = temp;
        }

        return Math.max(rob1, rob2);
    }
}
