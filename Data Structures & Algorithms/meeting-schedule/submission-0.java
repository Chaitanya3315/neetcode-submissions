/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int res = 0;
        if(intervals.size() == 0) return true;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int prevEnd = intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            if(start>= prevEnd){
                prevEnd= end;
            }else{
                res++;
                prevEnd= Math.min(prevEnd,end);
            }
        }
        return res > 0 ? false : true;
    }
}
