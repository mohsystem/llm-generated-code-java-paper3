package Vanilla.llama31;
import java.util.PriorityQueue;

public class Task195 {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public Task195() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Balance the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return (double) maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        Task195 medianFinder = new Task195();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2.0

        medianFinder = new Task195();
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2.5
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian()); // Output: 3.0

        medianFinder = new Task195();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian()); // Output: -1.5
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian()); // Output: -2.0

        medianFinder = new Task195();
        medianFinder.addNum(10);
        medianFinder.addNum(20);
        System.out.println(medianFinder.findMedian()); // Output: 15.0
        medianFinder.addNum(30);
        System.out.println(medianFinder.findMedian()); // Output: 20.0

        medianFinder = new Task195();
        medianFinder.addNum(5);
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian()); // Output: 5.0
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian()); // Output: 5.0
    }
}