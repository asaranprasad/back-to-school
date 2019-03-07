// **The idea is simple:**
// 1. Disintegrate the given line segments as points in the co-ordinate system with a flag pointing whether they are start points or end points. O(NLogN) time.
// 2. There after its a simple O(N) execution, as we loop through this sorted list of points, add height to a PriorityQueue if its a start point and removing height if its a end point.
// 3. We print the current point's x-val and the current max height in the priority queue as output.
// 4. The idea behind point 2 and 3 is that we remember all the heights of the active (non-ended) buildings in descending order which is very useful. This way, we just print the change in height whenever the current iter height is different from that in the priority queue (thus noting a change in building height).

// **Important points to remember:**
// 1. Init the Priority Queue with value 0, to handle the base case of no buildings in the heap. this way we can print the ground coordinates.

// To understand the SORTING steps, think for a moment how we would rather like to have it when we move from left to right of the skyline. Think of what we would like to do in cases when 1. a new building starts, and 2. an existing building ends. 

// 2. If two buildings start at same x-val, make the one with larger height come up first in the sorted list. Cauz, for starting points, we ADD heights to the MaxHeap and then update result if its different from previous. So this way, when two starting points have same x-val, we give preference to the one with more height. (Otherwise we get both the heights printed as per our subsequent code)

// 3. If two buildings end at same x-val, make the one with smaller height come up first in the sorted list. Cauz, just like the previous step, for ending points, we REMOVE heights from the MaxHeap. Now, since we are removing from Heap, if we remove the larger height, the next smaller height building ending at same x would still remain in the heap and will eventually get printed in the output since we have "a change in height". This is not what we want. Instead, if a series of buildings are ending at same x, we would want to print the lowest NON-terminating building's height from the heap, or if none present, print height ZERO.
 
// 4. And also, quite obviously, we give priority to the starting point of a building to come up in the sorted list.
    
class SkyLine {
    class Point{
        int x, y, startOrEnd;
        Point(int x, int y, int startOrEnd){
            this.x = x;
            this.y = y;
            this.startOrEnd = startOrEnd; // start = 0; end = 1;
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> out = new LinkedList<>();
        
        List<Point> points = new LinkedList<>();
        for(int[] b : buildings){
            points.add(new Point(b[0], b[2], 0));
            points.add(new Point(b[1], b[2], 1));
        }
        
        Collections.sort(points, (a,b) -> {
            if(a.x != b.x) return a.x - b.x;
            if(a.startOrEnd != b.startOrEnd) return a.startOrEnd - b.startOrEnd;
            if(a.startOrEnd == 0) return b.y - a.y;
            return a.y - b.y;
        });
        
        // Max Heap init with a zero height element
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        pq.add(0);
        int prevMax = 0;
        
        for(Point p : points){
            if(p.startOrEnd == 0) pq.add(p.y);
            else pq.remove(p.y);
            
            int currentMaxHeight = pq.peek();
            if(currentMaxHeight != prevMax){
                out.add(new int[]{p.x, currentMaxHeight});
                prevMax = currentMaxHeight;
            }
        }
        
        return out;
    }
}