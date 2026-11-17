class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];

        List<int[]> res = new ArrayList<>();

        int idx = 0;
        while(idx < intervals.length && intervals[idx][1] < start) {
            res.add(intervals[idx]);
            idx++;
        }

        if(idx >= intervals.length) {
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }

        int targetStart = newInterval[0];
        int targetEnd = newInterval[1];

        while(idx < intervals.length && intervals[idx][0] <= targetEnd) {
            targetStart = Math.min(targetStart, intervals[idx][0]);
            targetEnd = Math.max(targetEnd, intervals[idx][1]);
            idx++;
        }

        res.add(new int[] {targetStart, targetEnd});

        for(; idx < intervals.length; idx++) {
            res.add(intervals[idx]);
        }

        return res.toArray(new int[res.size()][]);
    }
}
