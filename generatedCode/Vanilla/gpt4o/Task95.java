package Vanilla.openai;
public class Task95 {
    public static double getCurrentProcessorTimeInSeconds() {
        return (double) System.nanoTime() / 1_000_000_000.0;
    }
    
    public static void main(String[] args) {
        System.out.println(getCurrentProcessorTimeInSeconds());
        System.out.println(getCurrentProcessorTimeInSeconds());
        System.out.println(getCurrentProcessorTimeInSeconds());
        System.out.println(getCurrentProcessorTimeInSeconds());
        System.out.println(getCurrentProcessorTimeInSeconds());
    }
}