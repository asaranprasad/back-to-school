#Meeting Rooms

#Type Easy
PS: Given an array of meetings(represented as intervals), check if all the meetings can be attended.
Sol: Check for overlaps. Best way is to SORT BY INTERVAL START TIME. O(NLogN) time, O(1) Space

#Type EasyMedium
PS: Given an array of meetings, and a single room, select as many number of meetings possible that can be scheduled in that single room.
Sol: Greedy Approach
SORT BY INTERVAL END TIME. Add all non-overlapping meetings to the answer list.
O(NLogN) time, O(1) Space

#Type Medium
https://leetcode.com/problems/meeting-rooms-ii/
PS: Given an array of meeting time intervals consisting of start and end times, find the minimum number of conference rooms required.
Sol: Use Sort and Min PriorityQueue
1. First, sort by START TIME. This ensures overlap detection in O(N) time.
2. Next, iterate over this sorted interval, maintaining a MIN PRIORITY QUEUE over the END TIME.
3. We use end time in step 2 because, this would denote the FIRST ROOM that possibly becomes FREE. For an incoming meeting we can use this room. If this end time is greater than incoming meeting's start time, that implies that there is no free room => we add 1 to the meeting room count. 

O(NLogN) time cauz of sort
O(N) space for heap.
