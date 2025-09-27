package ZeroShot.gemini;
import java.util.PriorityQueue;
import java.util.Collections;

class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (large.size() > small.size()) {
            return large.peek();
        } else {
            return (small.peek() + large.peek()) / 2.0;
        }
    }


    public static void main(String[] args) {
        MedianFinder medianFinder1 = new MedianFinder();
        medianFinder1.addNum(1);
        medianFinder1.addNum(2);
        System.out.println(medianFinder1.findMedian()); // 1.5
        medianFinder1.addNum(3);
        System.out.println(medianFinder1.findMedian()); // 2.0

        MedianFinder medianFinder2 = new MedianFinder();
        medianFinder2.addNum(-1);
        System.out.println(medianFinder2.findMedian()); // -1.0
        medianFinder2.addNum(-2);
        System.out.println(medianFinder2.findMedian()); // -1.5
        medianFinder2.addNum(-3);
        System.out.println(medianFinder2.findMedian()); // -2.0
        medianFinder2.addNum(-4);
        System.out.println(medianFinder2.findMedian()); // -2.5
        medianFinder2.addNum(-5);
        System.out.println(medianFinder2.findMedian()); // -3

        MedianFinder medianFinder3 = new MedianFinder();


        MedianFinder medianFinder4 = new MedianFinder();
        medianFinder4.addNum(2);
        medianFinder4.addNum(3);
        medianFinder4.addNum(4);
        System.out.println(medianFinder4.findMedian());

        MedianFinder medianFinder5 = new MedianFinder();
        medianFinder5.addNum(2);
        medianFinder5.addNum(3);
        System.out.println(medianFinder5.findMedian());

    }
}