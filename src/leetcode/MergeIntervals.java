// Remove using iterator. 
// Make sure to assign prev, curr appropriately.

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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return intervals;
        
        // O(NLogN) time
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        
        Iterator<Interval> iterator = intervals.iterator();
        iterator.next();
        Interval prev = intervals.get(0);
        
        // O(N) time
        while(iterator.hasNext()){
            Interval curr = iterator.next();
            if(prev.end >= curr.start){
                prev.end = Math.max(prev.end, curr.end);
                iterator.remove();
                continue;
            }
            prev = curr;
        }
        
        return intervals;
    }
}