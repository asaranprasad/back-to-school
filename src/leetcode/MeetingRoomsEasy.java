// RunTime: O(NLogN) - cauz of sorting.
// Space: O(1) - No Extra space

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (a,b) -> a.start - b.start);
        for(int i = 0; i < intervals.length - 1; i++){
            if(intervals[i + 1].start < intervals[i].end) return false;
        }
        return true;
    }
}