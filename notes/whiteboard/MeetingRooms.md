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