package CoT.openai;
import java.util.PriorityQueue;

class Task195 {
    static class MedianFinder {
        private PriorityQueue<Integer> lowerHalf;
        private PriorityQueue<Integer> upperHalf;

        public MedianFinder() {
            lowerHalf = new PriorityQueue<>((a, b) -> b - a);
            upperHalf = new PriorityQueue<>();
        }

        public void addNum(int num) {
            lowerHalf.offer(num);
            upperHalf.offer(lowerHalf.poll());
            if (lowerHalf.size() < upperHalf.size()) {
                lowerHalf.offer(upperHalf.poll());
            }
        }

        public double findMedian() {
            if (lowerHalf.size() == upperHalf.size()) {
                return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
            } else {
                return lowerHalf.peek();
            }
        }

        public static void main(String[] args) {
            MedianFinder medianFinder = new MedianFinder();
            medianFinder.addNum(1);
            medianFinder.addNum(2);
            System.out.println(medianFinder.findMedian()); // 1.5
            medianFinder.addNum(3);
            System.out.println(medianFinder.findMedian()); // 2.0
            medianFinder.addNum(4);
            System.out.println(medianFinder.findMedian()); // 2.5
            medianFinder.addNum(5);
            System.out.println(medianFinder.findMedian()); // 3.0
        }
    }
}