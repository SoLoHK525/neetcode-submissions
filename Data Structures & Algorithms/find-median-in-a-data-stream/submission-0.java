class MedianFinder {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.add(num);
        } else {
            maxHeap.add(num);
        }

        int diff = minHeap.size() - maxHeap.size();

        if(diff > 1) {
            maxHeap.add(minHeap.poll());
        } else if(diff < -1) {
            minHeap.add(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        boolean isEven = (maxHeap.size() + minHeap.size()) % 2 == 0;

        if(isEven) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }
}
