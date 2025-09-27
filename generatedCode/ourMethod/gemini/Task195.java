package ourMethod.gemini;
import java.util.PriorityQueue;
import java.util.Collections;

class Task195 {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;

    public Task195() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (small.size() <= large.size()) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
    }

    public double findMedian() {
        if (small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return small.peek();
        }
    }

    public static void main(String[] args) {
        Task195 medianFinder1 = new Task195();
        medianFinder1.addNum(1);
        medianFinder1.addNum(2);
        System.out.println(medianFinder1.findMedian()); // 1.5
        medianFinder1.addNum(3);
        System.out.println(medianFinder1.findMedian()); // 2.0

        Task195 medianFinder2 = new Task195();
        medianFinder2.addNum(2);
        medianFinder2.addNum(3);
        medianFinder2.addNum(4);
        System.out.println(medianFinder2.findMedian()); // 3.0

        Task195 medianFinder3 = new Task195();
        medianFinder3.addNum(-1);
        System.out.println(medianFinder3.findMedian()); // -1.0
        medianFinder3.addNum(-2);
        System.out.println(medianFinder3.findMedian()); // -1.5
        medianFinder3.addNum(-3);
        System.out.println(medianFinder3.findMedian()); // -2.0
        medianFinder3.addNum(-4);
        System.out.println(medianFinder3.findMedian()); // -2.5
        medianFinder3.addNum(-5);
        System.out.println(medianFinder3.findMedian()); // -3

        Task195 medianFinder4 = new Task195();
        medianFinder4.addNum(1);
        medianFinder4.addNum(2);
        medianFinder4.addNum(3);
        medianFinder4.addNum(4);
        medianFinder4.addNum(5);
        System.out.println(medianFinder4.findMedian());


        Task195 medianFinder5 = new Task195();

         medianFinder5.addNum(6);
         System.out.println(medianFinder5.findMedian()); // Output: 6.0
         medianFinder5.addNum(10);
         System.out.println(medianFinder5.findMedian()); // Output: 8.0
         medianFinder5.addNum(7);
         System.out.println(medianFinder5.findMedian()); // Output: 7.0
         medianFinder5.addNum(4);
         System.out.println(medianFinder5.findMedian()); // Output: 6.5
    }
}