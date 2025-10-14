package ourMethod.openai;
import java.util.ArrayList;
import java.util.Collections;

public class Task195 {

    public static class MedianFinder {
        private ArrayList<Integer> data;

        public MedianFinder() {
            data = new ArrayList<>();
        }

        public void addNum(int num) {
            data.add(num);
            Collections.sort(data);
        }

        public double findMedian() {
            int size = data.size();
            if (size % 2 == 1) {
                return data.get(size / 2);
            } else {
                return (data.get(size / 2 - 1) + data.get(size / 2)) / 2.0;
            }
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
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian()); // 3.0
    }
}