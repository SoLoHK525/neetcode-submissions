class Solution {
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        return fib(n);
    }

    public int fib(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(cache.containsKey(n)) {
            return cache.get(n);
        }

        int result = fib(n - 2) + fib(n - 1);

        cache.put(n, result);

        return result;
    }
}
