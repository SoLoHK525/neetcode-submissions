class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int res = 0;
        int minEnd = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= minEnd) {
                minEnd = intervals[i][1];
            } else {
                minEnd = Math.min(intervals[i][1], minEnd);
                res++;
            }
        }

        return res;
    }
}
