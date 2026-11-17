class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        for (int n : nums) {
            if (map.containsKey(n)) {
                return new int[] {map.get(n), i};
            }

            map.put(target - n, i);
            i++;
        }

        throw new RuntimeException("not found");
    }
}
