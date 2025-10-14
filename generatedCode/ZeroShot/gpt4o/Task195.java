package ZeroShot.openai;
import java.util.PriorityQueue;

class Task195 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2.0
        medianFinder.addNum(4);
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian()); // Output: 3.0
    }
}

class MedianFinder {
    private PriorityQueue<Integer> low;
    private PriorityQueue<Integer> high;

    public MedianFinder() {
        low = new PriorityQueue<>((a, b) -> b - a);
        high = new PriorityQueue<>();
    }

    public void addNum(int num) {
        low.add(num);
        high.add(low.poll());
        if (low.size() < high.size()) {
            low.add(high.poll());
        }
    }

    public double findMedian() {
        if (low.size() > high.size()) {
            return low.peek();
        } else {
            return (low.peek() + high.peek()) / 2.0;
        }
    }
}