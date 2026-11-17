class Solution {
    public int rob(int[] nums) {
        int rob1 = 0, // robbing
        rob2 = 0; // not robbing

        for(int i : nums) {
            int temp = Math.max(i + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
