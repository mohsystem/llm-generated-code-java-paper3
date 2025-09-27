package Vanilla.claude;

import java.util.PriorityQueue;

class Task195 {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public Task195() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        
        if (maxHeap.size() < minHeap.size()) {
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
        Task195 medianFinder = new Task195();
        
        // Test case 1
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Expected: 1.5
        
        // Test case 2
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Expected: 2.0
        
        // Test case 3
        Task195 mf2 = new Task195();
        mf2.addNum(5);
        System.out.println(mf2.findMedian()); // Expected: 5.0
        
        // Test case 4
        Task195 mf3 = new Task195();
        mf3.addNum(1);
        mf3.addNum(2);
        mf3.addNum(3);
        mf3.addNum(4);
        System.out.println(mf3.findMedian()); // Expected: 2.5
        
        // Test case 5
        Task195 mf4 = new Task195();
        mf4.addNum(-1);
        mf4.addNum(-2);
        mf4.addNum(-3);
        System.out.println(mf4.findMedian()); // Expected: -2.0
    }
}
