package ourMethod.claude;

import java.util.PriorityQueue;

class Task195 {
    private PriorityQueue<Integer> maxHeap; // stores smaller half
    private PriorityQueue<Integer> minHeap; // stores larger half
    
    public Task195() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        
        // Balance heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        Task195 mf = new Task195();
        
        // Test case 1
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5
        
        // Test case 2
        mf = new Task195();
        mf.addNum(1);
        System.out.println(mf.findMedian()); // 1.0
        
        // Test case 3
        mf = new Task195();
        mf.addNum(1);
        mf.addNum(2);
        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2.0
        
        // Test case 4
        mf = new Task195();
        mf.addNum(4);
        mf.addNum(2);
        mf.addNum(3);
        mf.addNum(1);
        System.out.println(mf.findMedian()); // 2.5
        
        // Test case 5
        mf = new Task195();
        mf.addNum(5);
        mf.addNum(4);
        mf.addNum(3);
        mf.addNum(2);
        mf.addNum(1);
        System.out.println(mf.findMedian()); // 3.0
    }
}
