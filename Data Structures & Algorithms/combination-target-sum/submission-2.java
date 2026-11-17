class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        
        backtrack(nums, 0, target, new ArrayList(), 0);

        return res;
    }
    

    public void backtrack(int[] nums, int total, int target, List<Integer> curr, int idx) {
        if(total == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < nums.length; i++) {
            if(total + nums[i] > target) {
                return;
            }

            curr.add(nums[i]);
            backtrack(nums, total + nums[i], target, curr, i);
            curr.remove(curr.size() - 1);
        }
    }
}
