class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        
        // Step 1: Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        ArrayList<int[]> res = new ArrayList<>();
        
        // Step 2: Take the first interval
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        // Step 3: Process all intervals
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= end) {
                // Overlapping → merge
                end = Math.max(end, intervals[i][1]);
            } else {
                // No overlap → push current interval and reset
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        // Step 4: Add the last interval
        res.add(new int[]{start, end});
        
        return res.toArray(new int[res.size()][]);
    }
}
