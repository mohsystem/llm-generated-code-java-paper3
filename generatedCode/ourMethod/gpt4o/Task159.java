package ourMethod.openai;
public class Task159 {
    private int[] buffer;

    public Task159(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero");
        }
        buffer = new int[size];
    }

    public int readData(int index) {
        if (index < 0 || index >= buffer.length) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return buffer[index];
    }

    public static void main(String[] args) {
        Task159 task = new Task159(10);
        task.buffer[0] = 100;
        task.buffer[1] = 200;
        task.buffer[2] = 300;
        task.buffer[3] = 400;
        task.buffer[4] = 500;

        System.out.println(task.readData(0));
        System.out.println(task.readData(1));
        System.out.println(task.readData(2));
        System.out.println(task.readData(3));
        System.out.println(task.readData(4));
    }
}