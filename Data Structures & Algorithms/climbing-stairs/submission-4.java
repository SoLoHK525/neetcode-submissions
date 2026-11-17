class Solution {
    int[] cache = new int[300];
    public int climbStairs(int n) {
        return fib(n);
    }

    public int fib(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(cache[n] != 0) {
            return cache[n];
        }

        int result = fib(n - 2) + fib(n - 1);

        cache[n] = result;

        return result;
    }
}
