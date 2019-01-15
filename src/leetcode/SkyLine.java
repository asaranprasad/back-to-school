class Solution {
    class Point{
        int x, y, startOrEnd;
        Point(int x, int y, int startOrEnd){
            this.x = x;
            this.y = y;
            this.startOrEnd = startOrEnd; // start = 0; end = 1;
        }
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        Point[] points = new Points[buildings.length*2];
        for(int[] b : buildings){
            points.add(new Point(b[0], b[2], 0));
            points.add(new Point(b[1], b[2], 1));
        }
        
        Arrays.sort(points, (a,b) -> {
            if(a.x != b.x) return a.x - b.x;
            if(a.startOrEnd != b.startOrEnd)
        });
        
        // Max Heap init with a zero height element
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        pq.add(0);
        
        
    }
}