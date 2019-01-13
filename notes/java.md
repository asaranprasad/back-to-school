#Java

##Queues
Implemented using linked list
Queue<Integer> q = new LinkedList<>();
	Operations: 
		q.add(i);
		h = q.remove(); // Removes the head of the queue
		h = q.peek(); // View the head of the queue i.e. returns reference to the head of the queue


##PriorityQueues
// MIN HEAP - Default
PriorityQueue<String> pQueue = new PriorityQueue<String>(); 

// MAX HEAP - Use Lambda trick
PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

	Operations:
		pQueue.add(elm);
		elm = pQueue.poll(); // Removes and returns the root of the heap. O(1) operation.
		h = q.peek(); // returns reference to the root of the queue WITHOUT removing it.
		bool = pQueue.contains(); // O(logN) operation
		pQueue.toArray(); // comvert toArray


##Iterator
Available for almost all collections
	Usage:
		Iterator itr = pQueue.iterator(); 
        while (itr.hasNext()) 
            System.out.println(itr.next()); 