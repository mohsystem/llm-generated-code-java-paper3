package ZeroShot.llama31;
public class Task95 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            long startTime = System.nanoTime();
            // Simulate some work
            for (int j = 0; j < 10000000; j++) {
                Math.sqrt(j);
            }
            long endTime = System.nanoTime();
            double cpuTime = (endTime - startTime) / 1e9;
            System.out.println("CPU time: " + cpuTime + " seconds");
        }
    }
}