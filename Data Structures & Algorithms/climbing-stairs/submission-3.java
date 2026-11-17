class Solution {
    int[] cache = new int[3000];
    public int climbStairs(int n) {
        return fib(n);
    }

    public int fib(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(cache[n - 1] != 0) {
            return cache[n - 1];
        }

        int result = fib(n - 2) + fib(n - 1);

        cache[n - 1] = result;

        return result;
    }
}
