class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1
        // 1, 1, 2, 8
        // 48, 24, 6, 1
        int[] res = new int[nums.length];

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefix; 
            prefix *= nums[i];
        }
        
        prefix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= prefix; 
            prefix *= nums[i];
        }

        return res;
    }
}  
