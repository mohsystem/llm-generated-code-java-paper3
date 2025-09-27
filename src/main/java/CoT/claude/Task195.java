package CoT.claude;

import java.util.PriorityQueue;

public class Task195 {
    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    
    public Task195() {
        small = new PriorityQueue<>((a,b) -> b-a); // max heap
        large = new PriorityQueue<>(); // min heap
    }
    
    public void addNum(int num) {
        small.add(num);
        
        // make sure every num in small <= every num in large
        if(!small.isEmpty() && !large.isEmpty() && small.peek() > large.peek()) {
            large.add(small.poll());
        }
        
        // handle size property
        while(small.size() > large.size() + 1) {
            large.add(small.poll());
        }
        while(large.size() > small.size()) {
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        if(small.size() > large.size()) {
            return small.peek();
        }
        return (small.peek() + large.peek()) / 2.0;
    }
    
    public static void main(String[] args) {
        Task195 mf = new Task195();
        
        // Test case 1
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian()); // 1.5
        
        // Test case 2
        mf.addNum(3);
        System.out.println(mf.findMedian()); // 2.0
        
        // Test case 3
        Task195 mf2 = new Task195();
        mf2.addNum(5);
        System.out.println(mf2.findMedian()); // 5.0
        
        // Test case 4
        mf2.addNum(4);
        mf2.addNum(3);
        System.out.println(mf2.findMedian()); // 4.0
        
        // Test case 5
        mf2.addNum(2);
        mf2.addNum(1);
        System.out.println(mf2.findMedian()); // 3.0
    }
}
