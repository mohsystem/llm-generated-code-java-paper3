package Vanilla.gpt4o;
public class Task104 {
    private static final int BUFFER_SIZE = 5;
    private String[] buffer;
    private int index;

    public Task104() {
        buffer = new String[BUFFER_SIZE];
        index = 0;
    }

    public void addToBuffer(String input) {
        if (index < BUFFER_SIZE) {
            buffer[index] = input;
            index++;
        } else {
            System.out.println("Buffer is full");
        }
    }

    public String[] getBuffer() {
        return buffer;
    }

    public static void main(String[] args) {
        Task104 task = new Task104();

        // Test cases
        task.addToBuffer("First");
        task.addToBuffer("Second");
        task.addToBuffer("Third");
        task.addToBuffer("Fourth");
        task.addToBuffer("Fifth");
        task.addToBuffer("Sixth"); // Should print "Buffer is full"

        String[] resultBuffer = task.getBuffer();
        for (String str : resultBuffer) {
            System.out.println(str);
        }
    }
}