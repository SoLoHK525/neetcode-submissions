class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int len = nums.length;
        
        int i = 0;

        while(nums[i] <= 0 && i < len - 1) {
            int ni = nums[i];
            int target = -nums[i];

            int j = i + 1;
            int k = len - 1;

            while(j < k) {
                int nj = nums[j];
                int nk = nums[k];
                int sum = nj + nk;

                if (sum == target) {
                    res.add(List.of(nums[i],nj, nk));

                    while(nj == nums[++j] && j < len - 1);
                    while(nk == nums[--k] && k > 0);
                } else if (sum < target) {
                    while(nj == nums[++j] && j < len - 1);
                } else {
                    while(nk == nums[--k] && k > 0);
                }
            }

            while(nums[++i] == ni && i < len - 1);
        }

        return res;
    }
}
