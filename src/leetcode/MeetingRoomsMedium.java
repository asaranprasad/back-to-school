// https://leetcode.com/problems/meeting-rooms-ii/submissions/

// Use Sort and Min PriorityQueue
// 1. First, sort by START TIME. This ensures overlap detection in O(N) time.
// 2. Next, iterate over this sorted interval, maintaining a MIN PRIORITY QUEUE over the END TIME.
// 3. We use end time in step 2 because, this would denote the FIRST ROOM that possibly becomes FREE. For an incoming meeting we can use this room. If this end time is greater than incoming meeting's start time, that implies that there is no free room => we add 1 to the meeting room count.

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
    public int minMeetingRooms(Interval[] intervals) {     
        if(intervals.length == 0) return 0;
        
        // Asc Sort - O(NLogN) time
        Arrays.sort(intervals, (a,b) -> a.start - b.start);
        
        // Priority Queue to store END times of the intervals
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Add first meeting to the heap
        minHeap.add(intervals[0].end);
                
        int rooms = 1; 
        
        for(int i = 1; i < intervals.length; i++){
            Interval inv = intervals[i];
            if(minHeap.peek() > inv.start) rooms++;
            else minHeap.poll();
            minHeap.add(intervals[i].end);
        }
        
        return rooms;
    }
}